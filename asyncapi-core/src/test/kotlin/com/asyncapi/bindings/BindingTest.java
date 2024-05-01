package com.asyncapi.bindings;

import com.asyncapi.schemas.ExtendableObject;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class BindingTest<BindingType extends ExtendableObject> {

    private static final ObjectMapper objectMapper = new ObjectMapper()
            .setSerializationInclusion(JsonInclude.Include.NON_NULL);

    protected Class<BindingType> bindingTypeClass;
    protected String pathToBindingJson;
    protected String pathToExtendedBindingJson;
    protected String pathToWronglyExtendedBindingJson;
    protected BindingType binding;

    @Test
    @Order(1)
    @DisplayName("compare binding from Json and from code")
    public void compareBindingFromJsonAndFromCode() throws IOException, URISyntaxException {
        Assertions.assertEquals(read(pathToBindingJson, bindingTypeClass), binding);
    }

    @Test
    @Order(2)
    @DisplayName("compare extended binding from Json and from code")
    public void compareExtendedBindingFromJsonAndFromCode() throws IOException, URISyntaxException {
        var binding = read(pathToExtendedBindingJson, bindingTypeClass);
        Assertions.assertEquals(
                Map.ofEntries(
                        Map.entry("x-number", 0),
                        Map.entry("x-string", ""),
                        Map.entry("x-object", Map.ofEntries(Map.entry("property", Collections.emptyMap())))
                ),
                binding.getExtensionFields()
        );

        Assertions.assertEquals(read(pathToExtendedBindingJson, bindingTypeClass), binding);
    }

    @Test
    @Order(3)
    @DisplayName("deserialize and compare extended binding json with extended binding from code")
    public void deserializeAndCompareExtendedBindingJsonWithExtendedBindingFromCode() throws IOException, URISyntaxException {
        var extensions = new LinkedHashMap<String, Object>();
        extensions.put("x-number", 0);
        extensions.put("x-string", "");
        extensions.put("x-object", Map.ofEntries(Map.entry("property", Collections.emptyMap())));

        binding.setExtensionFields(extensions);
        Assertions.assertEquals(
                read(pathToExtendedBindingJson),
                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(binding)
        );
    }

    @Test
    @Order(4)
    @DisplayName("throw exception when binding extended wrongly")
    public void throwExceptionWhenBindingExtendedWrongly() {
        var exception = Assertions.assertThrows(JsonMappingException.class, () -> {
            read(pathToWronglyExtendedBindingJson, bindingTypeClass);
        });

        Assertions.assertTrue(exception.getMessage().startsWith("\"ext-number\" is not valid extension property (through reference chain:"));
    }

    private String read(@NotNull String pathToJson) throws IOException, URISyntaxException {
        Path path = Path.of(BindingTest.class.getResource(pathToJson).toURI());

        return Files.readString(path);
    }

    private BindingType read(@NotNull String pathToJson, @NotNull Class<BindingType> bindingTypeClass) throws IOException, URISyntaxException {
        Path path = Path.of(BindingTest.class.getResource(pathToJson).toURI());

        return objectMapper.readValue(Files.readString(path), bindingTypeClass);
    }

}
