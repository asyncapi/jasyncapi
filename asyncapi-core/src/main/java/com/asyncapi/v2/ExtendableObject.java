package com.asyncapi.v2;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExtendableObject {

    // ^x-[\w\d\-\_]+$
    /**
     * Extension fields in the form x-extension-field-name for the exposed API.
     */
    @Nullable
    @JsonAnySetter
    @JsonAnyGetter
    protected Map<String, Object> extensionFields;

}
