package com.asyncapi.v2._6_0.model;

import com.asyncapi.schemas.asyncapi.ExtendableObject;
import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v2._6_0.jackson.model.server.ServersDeserializer;
import com.asyncapi.v2._6_0.model.channel.ChannelItem;
import com.asyncapi.v2._6_0.model.component.Components;
import com.asyncapi.v2._6_0.model.info.Info;
import com.asyncapi.v2._6_0.model.server.Server;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is the root document object for the API specification.
 * It combines resource listing and API declaration together into one document.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0">AsyncAPI</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AsyncAPI extends ExtendableObject {

    /**
     * Required.
     * <p>
     * Specifies the AsyncAPI Specification version being used.
     * It can be used by tooling Specifications and clients to interpret the version.
     * The structure shall be major.minor.patch, where patch versions must be compatible
     * with the existing major.minor tooling.
     * <p>
     * Typically patch versions will be introduced to address errors in the documentation,
     * and tooling should typically be compatible with the corresponding major.minor (1.0.*).
     * Patch versions will correspond to patches of this document.
     */
    @NotNull
    @Builder.Default
    private final String asyncapi = "2.6.0";

    /**
     * Identifier of the application the AsyncAPI document is defining.
     * <p>
     * This field represents a unique universal identifier of the application the AsyncAPI document is defining.
     * It must conform to the URI format, according to <a href="https://tools.ietf.org/html/rfc3986">RFC3986</a>.
     * <p>
     * It is RECOMMENDED to use a <a href="https://tools.ietf.org/html/rfc8141">URN</a> to globally and uniquely identify the application during long periods of time,
     * even after it becomes unavailable or ceases to exist.
     */
    @Nullable
    private String id;

    /**
     * Required.
     * <p>
     * Provides metadata about the API. The metadata can be used by the clients if needed.
     */
    @NotNull
    @Builder.Default
    private Info info = new Info();

    /**
     * Provides connection details of servers.
     * MUST BE:
     * <ul>
     *     <li>{@link Server}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ServersDeserializer.class)
    private Map<String, Object> servers;

    /**
     * A string representing the default content type to use when encoding/decoding a message's payload.
     * The value MUST be a specific media type (e.g. application/json).
     * This value MUST be used by schema parsers when the contentType property is omitted.
     * <p>
     * In case a message can't be encoded/decoded using this value, schema parsers MUST use their default content type.
     */
    @Nullable
    private String defaultContentType;

    /**
     * Required.
     * <p>
     * The available channels and messages for the API.
     * <p>
     * Holds the relative paths to the individual channel and their operations. Channel paths are relative to servers.
     * <p>
     * Channels are also known as "topics", "routing keys", "event types" or "paths".
     */
    @NotNull
    @Builder.Default
    private Map<String, ChannelItem> channels = new HashMap<>();

    /**
     * An element to hold various schemas for the specification.
     */
    @Nullable
    private Components components;

    /**
     * A list of tags used by the specification with additional metadata. Each tag name in the list MUST be unique.
     */
    @Nullable
    private List<Tag> tags;

    /**
     * Additional external documentation.
     */
    @Nullable
    private ExternalDocumentation externalDocs;

}
