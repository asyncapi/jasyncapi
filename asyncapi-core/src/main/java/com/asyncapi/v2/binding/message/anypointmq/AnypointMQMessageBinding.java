package com.asyncapi.v2.binding.message.anypointmq;

import com.asyncapi.v2.binding.message.MessageBinding;
import com.asyncapi.v2.schema.Schema;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Anypoint MQ message binding.
 *
 * @version 0.0.1
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/anypointmq/README.md#message-binding-object">Anypoint MQ message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Anypoint MQ message binding.")
public class AnypointMQMessageBinding extends MessageBinding {

    /**
     * A Schema object containing the definitions for Anypoint MQ-specific headers (so-called protocol headers).
     * This schema MUST be of type object and have a properties key. Examples of Anypoint MQ protocol headers are
     * messageId and messageGroupId.
     */
    @Nullable
    @JsonProperty("headers")
    @JsonPropertyDescription("A Schema object containing the definitions for Anypoint MQ-specific headers (so-called protocol headers). This schema MUST be of type object and have a properties key. Examples of Anypoint MQ protocol headers are messageId and messageGroupId.")
    private Schema headers;

    /**
     * The version of this binding.
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "bindingVersion")
    @JsonPropertyDescription("The version of this binding.")
    private String bindingVersion = "0.0.1";

}
