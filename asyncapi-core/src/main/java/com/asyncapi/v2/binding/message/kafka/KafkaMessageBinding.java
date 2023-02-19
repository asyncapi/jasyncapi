package com.asyncapi.v2.binding.message.kafka;

import com.asyncapi.v2.binding.message.MessageBinding;
import lombok.*;

import javax.annotation.CheckForNull;

/**
 * Describes Kafka message binding.
 * <p>
 * Contains information about the message representation in Kafka.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#message-binding-object">Kafka message binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class KafkaMessageBinding extends MessageBinding {

    /**
     * TODO: Avro Schema
     * The message key.
     *
     * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#schemaObject">Schema object</a>
     */
    @CheckForNull
    private Object key;

    /**
     * If a Schema Registry is used when performing this operation, tells where the id of schema is stored (e.g. header or payload).
     */
    @CheckForNull
    private String schemaIdLocation;

    /**
     * Number of bytes or vendor specific values when schema id is encoded in payload (e.g confluent/ apicurio-legacy / apicurio-new).
     */
    @CheckForNull
    private String schemaIdPayloadEncoding;

    /**
     * Freeform string for any naming strategy class to use. Clients should default to the vendor default if not supplied.
     */
    @CheckForNull
    private String schemaLookupStrategy;

    /**
     * The version of this binding. If omitted, "latest" MUST be assumed.
     */
    @CheckForNull
    @Builder.Default
    private String bindingVersion = "0.4.0";

}
