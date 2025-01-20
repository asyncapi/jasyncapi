package com.asyncapi.bindings.googlepubsub.v0._1_0.channel;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * Describes Google Cloud Pub/Sub MessageStoragePolicy.
 * <p>
 * The Message Storage Policy Object is used to describe the Google Cloud Pub/Sub <a href="https://cloud.google.com/pubsub/docs/reference/rest/v1/projects.topics#MessageStoragePolicy">MessageStoragePolicy</a> Object with AsyncAPI.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/googlepubsub#channel-binding-object">Google Cloud Pub/Sub channel binding</a>
 * @see <a href="https://cloud.google.com/pubsub">Google Cloud Pub/Sub</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonClassDescription("Describe the Google Cloud Pub/Sub MessageStoragePolicy")
public class GooglePubSubChannelMessageStoragePolicy {

    /**
     * A list of IDs of GCP regions where messages that are published to the topic may be persisted in storage
     */
    @Nullable
    @JsonProperty("allowedPersistenceRegions")
    @JsonPropertyDescription("A list of IDs of GCP regions where messages that are published to the topic may be persisted in storage")
    private List<String> allowedPersistenceRegions;

}
