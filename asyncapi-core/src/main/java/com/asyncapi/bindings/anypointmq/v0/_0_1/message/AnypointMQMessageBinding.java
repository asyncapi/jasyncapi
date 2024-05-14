package com.asyncapi.bindings.anypointmq.v0._0_1.message;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
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
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/anypointmq/README.md#message-binding-object">Anypoint MQ message binding</a>
 * @see <a href="https://docs.mulesoft.com/mq/">Anypoint MQ</a>
 * @author Pavel Bodiachevskii
 * @version 0.0.1
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Anypoint MQ message binding.")
public class AnypointMQMessageBinding extends com.asyncapi.bindings.anypointmq.AnypointMQMessageBinding {

    /**
     * A Schema object containing the definitions for Anypoint MQ-specific headers (so-called protocol headers).
     * This schema MUST be of type object and have a properties key. Examples of Anypoint MQ protocol headers are
     * messageId and messageGroupId.
     */
    @Nullable
    @JsonProperty("headers")
    @JsonPropertyDescription("A Schema object containing the definitions for Anypoint MQ-specific headers (so-called protocol headers). This schema MUST be of type object and have a properties key. Examples of Anypoint MQ protocol headers are messageId and messageGroupId.")
    private AsyncAPISchema headers;

    @Override
    public String getBindingVersion() {
        return "0.0.1";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.0.1");
    }

}
