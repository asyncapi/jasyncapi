package com.asyncapi.bindings;

import com.asyncapi.schemas.ExtendableObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.Nullable;

/**
 * Describes AsyncAPI message binding.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MessageBinding extends ExtendableObject {

    /**
     * The version of this binding.
     * <p>
     * If omitted, 'latest' <b>MUST</b> be assumed.
     */
    @Nullable
    @JsonProperty("bindingVersion")
    private String bindingVersion;

}
