package com.asyncapi.bindings;

import com.asyncapi.schemas.ExtendableObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.Nullable;

/**
 * Describes protocol-specific definition for a server.
 * <p>
 * This object MAY be extended with {@link ExtendableObject}.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#specificationExtensions">Specification Extensions</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#serverBindingsObject">Server Binding</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ServerBinding extends ExtendableObject {

    /**
     * The version of this binding.
     * <p>
     * If omitted, 'latest' <b>MUST</b> be assumed.
     */
    @Nullable
    @JsonProperty("bindingVersion")
    private String bindingVersion;

}
