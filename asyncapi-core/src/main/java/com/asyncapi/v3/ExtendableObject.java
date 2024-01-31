package com.asyncapi.v3;

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
 * While the AsyncAPI Specification tries to accommodate most use cases,
 * additional data can be added to extend the specification at certain points.
 * <p>
 * The extensions properties are implemented as patterned fields that are always prefixed by "x-".
 * <p>
 * The extensions may or may not be supported by the available tooling, but those may be extended as
 * well to add requested support (if tools are internal or open-sourced).
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#specificationExtensions">Specification Extensions</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
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
