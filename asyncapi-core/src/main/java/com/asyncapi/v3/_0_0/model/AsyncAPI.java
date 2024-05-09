package com.asyncapi.v3._0_0.model;

import com.asyncapi.schemas.asyncapi.ExtendableObject;
import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.jackson.model.channel.ChannelsDeserializer;
import com.asyncapi.v3._0_0.jackson.model.operation.OperationsDeserializer;
import com.asyncapi.v3._0_0.jackson.model.server.ServersDeserializer;
import com.asyncapi.v3._0_0.model.channel.Channel;
import com.asyncapi.v3._0_0.model.component.Components;
import com.asyncapi.v3._0_0.model.info.Info;
import com.asyncapi.v3._0_0.model.operation.Operation;
import com.asyncapi.v3._0_0.model.server.Server;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the root document object for the API specification.
 * It combines resource listing and API declaration together into one document.
 *
 * @version 3.0.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#A2SObject">AsyncAPI</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AsyncAPI extends ExtendableObject {

    /**
     * <b>Required</b>.
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
    private final String asyncapi = "3.0.0";

    /**
     * Identifier of the <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#definitionsApplication">application</a> the AsyncAPI document is defining.
     * <p>
     * This field represents a unique universal identifier of the application the AsyncAPI document is defining.
     * It must conform to the URI format, according to <a href="https://datatracker.ietf.org/doc/html/rfc3986">RFC3986</a>.
     * <p>
     * It is RECOMMENDED to use a URN to globally and uniquely identify the application during long periods of time,
     * even after it becomes unavailable or ceases to exist.
     */
    @Nullable
    private String id;

    /**
     * A string representing the default content type to use when encoding/decoding a message's payload.
     * <p>
     * The value MUST be a specific media type (e.g. application/json).
     * <p>
     * This value MUST be used by schema parsers when the contentType property is omitted.
     * <p>
     * In case a message can't be encoded/decoded using this value, schema parsers MUST use their default content type.
     */
    @Nullable
    private String defaultContentType;

    /**
     * <b>Required</b>.
     * <p>
     * Provides metadata about the API. The metadata can be used by the clients if needed.
     */
    @NotNull
    @Builder.Default
    private Info info = new Info();

    /**
     * Provides connection details of servers.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Server}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @Builder.Default
    @JsonDeserialize(using = ServersDeserializer.class)
    private Map<String, Object> servers = new HashMap<>();

    /**
     * The channels used by this <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#definitionsApplication">application</a>.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Channel}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @Builder.Default
    @JsonDeserialize(using = ChannelsDeserializer.class)
    private Map<String, Object> channels = new HashMap<>();

    /**
     * The operations this <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#definitionsApplication">application</a> MUST implement.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Operation}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @Builder.Default
    @JsonDeserialize(using = OperationsDeserializer.class)
    private Map<String, Object> operations = new HashMap<>();

    /**
     * An element to hold various reusable objects for the specification.
     * <p>
     * Everything that is defined inside this object represents a resource that MAY or MAY NOT be used in the
     * rest of the document and MAY or MAY NOT be used by the implemented <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#definitionsApplication">application</a>.
     */
    @Nullable
    private Components components;

}

