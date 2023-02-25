package com.asyncapi.v2;

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

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"extensionFields"})
public class ExtendableObject {

    private static final Pattern extensionPropertyNamePattern = Pattern.compile("^x-[\\w\\d\\-\\_]+$");

    /**
     * Extension fields in the form x-extension-field-name for the exposed API.
     */
    @Nullable
    @JsonAnyGetter
    protected Map<String, Object> extensionFields;

    @JsonAnySetter
    protected final void readExtensionProperty(String name, Object value) {
        if (extensionPropertyNamePattern.matcher(name).matches()) {
            if (extensionFields == null) {
                extensionFields = new HashMap<>();
            }

            extensionFields.put(name, value);
        } else {
            throw new IllegalArgumentException(String.format("\"%s\" is not valid extension property", name));
        }
    }

}
