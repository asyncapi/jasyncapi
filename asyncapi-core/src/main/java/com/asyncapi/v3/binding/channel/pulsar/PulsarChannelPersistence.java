package com.asyncapi.v3.binding.channel.pulsar;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes Pulsar channel persistence.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/pulsar#channel-binding-object">Pulsar channel binding</a>
 * @author Pavel Bodiachevskii
 */
@JsonClassDescription("Describes Pulsar channel persistence.")
public enum PulsarChannelPersistence {

    @JsonProperty("persistent")
    PERSISTENT,

    @JsonProperty("non-persistent")
    NON_PERSISTENT

}
