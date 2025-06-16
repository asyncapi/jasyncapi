package com.asyncapi.v3._0_0.model;

import com.asyncapi.lsp.TextDocumentCompletion;
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
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Specifies the AsyncAPI Specification version being used"
    )
    private String asyncapi = "3.0.0";

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
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Identifier of the application the AsyncAPI document is defining"
    )
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
    @TextDocumentCompletion(
            detail = "String",
            documentation = "A string representing the default content type to use when encoding/decoding a message's payload\n\n" +
                    "The value MUST be a specific media type (e.g. application/json)\n" +
                    "This value MUST be used by schema parsers when the contentType property is omitted\n\n" +
                    "In case a message can't be encoded/decoded using this value, schema parsers MUST use their default content type"
    )
    private String defaultContentType;

    /**
     * <b>Required</b>.
     * <p>
     * Provides metadata about the API. The metadata can be used by the clients if needed.
     */
    @NotNull
    @Builder.Default
    @TextDocumentCompletion(
            detail = "Object",
            documentation = "The metadata can be used by the clients if needed",
            variants = {Info.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, Server | Reference>",
            documentation = "Provides connection details of servers\n\n" +
                    "This details will be used by clients to connect to given server",
            variants = {Server.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, Channel | Reference>",
            documentation = "Provides details about available channels\n\n" +
                    "This details will be used by clients to configure available operations",
            variants = {Channel.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, Operation | Reference>",
            documentation = "Provides details about available operations for defined channels\n\n" +
                    "This details will be used by clients to send or receive messages from channels",
            variants = {Operation.class, Reference.class}
    )
    private Map<String, Object> operations = new HashMap<>();

    /**
     * An element to hold various reusable objects for the specification.
     * <p>
     * Everything that is defined inside this object represents a resource that MAY or MAY NOT be used in the
     * rest of the document and MAY or MAY NOT be used by the implemented <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#definitionsApplication">application</a>.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "Object",
            documentation = "An element to hold various reusable objects for the specification\n\n" +
                    "Everything that is defined inside this object represents a resource that MAY or MAY NOT be used in the\n" +
                    "rest of the document and MAY or MAY NOT be used by the implemented application",
            variants = {Components.class}
    )
    private Components components;

}

