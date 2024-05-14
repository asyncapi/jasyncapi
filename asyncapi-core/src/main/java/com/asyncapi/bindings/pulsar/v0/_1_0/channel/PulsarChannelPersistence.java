package com.asyncapi.bindings.pulsar.v0._1_0.channel;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes Pulsar channel persistence.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/pulsar#channel-binding-object">Pulsar channel binding</a>
 * @see <a href="https://pulsar.apache.org">Pulsar</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@JsonClassDescription("Describes Pulsar channel persistence.")
public enum PulsarChannelPersistence {

    @JsonProperty("persistent")
    PERSISTENT,

    @JsonProperty("non-persistent")
    NON_PERSISTENT

}
