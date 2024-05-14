package com.asyncapi.bindings.mqtt.v0._2_0.message;

import com.asyncapi.schemas.serde.asyncapi.ReferenceOrAsyncAPISchemaOrStringDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes MQTT message binding.
 * <p>
 * Contains information about the message representation in MQTT.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/mqtt#message-binding-object">MQTT message binding</a>
 * @see <a href="https://mqtt.org/mqtt-specification/">MQTT</a>
 * @version 0.2.0
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MQTTMessageBinding extends com.asyncapi.bindings.mqtt.MQTTMessageBinding {

    /**
     * 1 indicates that the payload is UTF-8 encoded character data.
     * <p>
     * 0 indicates that the payload format is unspecified.
     */
    @Nullable
    @Builder.Default
    private Integer payloadFormatIndicator = 0;

    /**
     * Correlation Data is used by the sender of the request message to identify which request the response message is for when it is received.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.schemas.asyncapi.AsyncAPISchema}</li>
     *     <li>{@link com.asyncapi.schemas.asyncapi.Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ReferenceOrAsyncAPISchemaOrStringDeserializer.class)
    private Object correlationData;

    /**
     * String describing the content type of the message payload.
     * <p>
     * This should not conflict with the contentType field of the associated AsyncAPI Message object.
     */
    @Nullable
    private String contentType;

    /**
     * The topic (channel URI) to be used for a response message.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link String} in <code>uri-template</code> format</li>
     *     <li>{@link com.asyncapi.schemas.asyncapi.AsyncAPISchema}</li>
     *     <li>{@link com.asyncapi.schemas.asyncapi.Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ReferenceOrAsyncAPISchemaOrStringDeserializer.class)
    private Object responseTopic;

    @Override
    public String getBindingVersion() {
        return "0.2.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.2.0");
    }

}
