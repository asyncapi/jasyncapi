package com.asyncapi.bindings.solace;

import com.asyncapi.bindings.ServerBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Describes Solace server binding.
 *
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#server-binding-object">Solace server binding</a>
 * @author Dennis Brinley, Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.solace.v0._3_0.server.SolaceServerBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.solace.v0._3_0.server.SolaceServerBinding.class, names = {
                "0.3.0",
                "latest"
        }),
})
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class SolaceServerBinding extends ServerBinding {}