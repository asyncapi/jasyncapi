package com.asyncapi.bindings.solace;

import com.asyncapi.bindings.MessageBinding;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes Solace message binding.
 *
 * @version 0.3.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#message-binding-object">Solace message binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        defaultImpl = com.asyncapi.bindings.solace.v0._3_0.message.SolaceMessageBinding.class,
        property = "bindingVersion",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = com.asyncapi.bindings.solace.v0._3_0.message.SolaceMessageBinding.class, names = {
                "0.3.0",
                "latest"
        }),
})
@Data
@EqualsAndHashCode(callSuper = true)
public abstract class SolaceMessageBinding extends MessageBinding {}