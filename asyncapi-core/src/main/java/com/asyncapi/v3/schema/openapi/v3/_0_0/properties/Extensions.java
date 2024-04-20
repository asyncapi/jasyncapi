package com.asyncapi.v3.schema.openapi.v3._0_0.properties;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.0.0.md#specification-extensions">Specification Extensions</a>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"extensions"})
public class Extensions {

    private static final Pattern extensionPropertyNamePattern = Pattern.compile("^x-.*");

    /**
     * Extension fields in the form x-extension-field-name for the exposed API.
     */
    @Nullable
    @JsonAnyGetter
    protected Map<String, Object> extensions;

    @JsonAnySetter
    protected final void readExtensionProperty(String name, Object value) {
        if (extensionPropertyNamePattern.matcher(name).matches()) {
            if (extensions == null) {
                extensions = new HashMap<>();
            }

            extensions.put(name, value);
        } else {
            throw new IllegalArgumentException(String.format("\"%s\" is not valid extension property", name));
        }
    }

}
