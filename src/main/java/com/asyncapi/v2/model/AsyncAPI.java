package com.asyncapi.v2.model;

import com.asyncapi.v2.model.channel.ChannelItem;
import com.asyncapi.v2.model.info.Info;
import com.asyncapi.v2.model.server.Server;
import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

/**
 * This is the root document object for the API specification.
 * It combines resource listing and API declaration together into one document.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AsyncAPI {

    /**
     * Required.
     *
     * Specifies the AsyncAPI Specification version being used.
     * It can be used by tooling Specifications and clients to interpret the version.
     * The structure shall be major.minor.patch, where patch versions must be compatible
     * with the existing major.minor tooling.
     *
     * Typically patch versions will be introduced to address errors in the documentation,
     * and tooling should typically be compatible with the corresponding major.minor (1.0.*).
     * Patch versions will correspond to patches of this document.
     */
    @Nonnull
    @NonNull
    private String asyncapi = "2.0.0";

    /**
     * Identifier of the application the AsyncAPI document is defining.
     *
     * This field represents a unique universal identifier of the application the AsyncAPI document is defining.
     * It must conform to the URI format, according to RFC3986.
     *
     * It is RECOMMENDED to use a URN to globally and uniquely identify the application during long periods of time,
     * even after it becomes unavailable or ceases to exist.
     */
    @CheckForNull
    private String id;

    /**
     * A string representing the default content type to use when encoding/decoding a message's payload.
     * The value MUST be a specific media type (e.g. application/json).
     * This value MUST be used by schema parsers when the contentType property is omitted.
     *
     * In case a message can't be encoded/decoded using this value, schema parsers MUST use their default content type.
     */
    @CheckForNull
    private String defaultContentType;

    /**
     * Required.
     *
     * Provides metadata about the API. The metadata can be used by the clients if needed.
     */
    @Nonnull
    @NonNull
    private Info info;

    /**
     * Provides connection details of servers.
     */
    @CheckForNull
    private Map<String, Server> servers;

    /**
     * Required.
     *
     * The available channels and messages for the API.
     *
     * Holds the relative paths to the individual channel and their operations. Channel paths are relative to servers.
     *
     * Channels are also known as "topics", "routing keys", "event types" or "paths".
     */
    @Nonnull
    @NonNull
    private Map<String, ChannelItem> channels;

    /**
     * An element to hold various schemas for the specification.
     */
//    private Components components;

    /**
     * A list of tags used by the specification with additional metadata. Each tag name in the list MUST be unique.
     */
    private List<Tag> tags;

    /**
     * Additional external documentation.
     */
    private ExternalDocumentation externalDocs;

}
