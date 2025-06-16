package com.asyncapi.v3._0_0.model.server;

import com.asyncapi.lsp.TextDocumentCompletion;
import com.asyncapi.bindings.ServerBindingsDeserializer;
import com.asyncapi.v3._0_0.jackson.model.server.ServerVariablesDeserializer;
import com.asyncapi.bindings.ServerBinding;
import com.asyncapi.schemas.asyncapi.ExtendableObject;
import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v3._0_0.jackson.model.ExternalDocumentationDeserializer;
import com.asyncapi.v3._0_0.jackson.model.TagsDeserializer;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.schemas.serde.asyncapi.security.v3.SecuritySchemesDeserializer;
import com.asyncapi.schemas.asyncapi.security.v3.SecurityScheme;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * An object representing a message broker, a server or any other kind of computer program capable of sending and/or
 * receiving data.
 * <p>
 * This object is used to capture details such as URIs, protocols and security configuration.
 * <p>
 * Variable substitution can be used so that some details, for example usernames and passwords, can be injected by
 * code generation tools.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#serverObject">Server</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Server extends ExtendableObject {

    /**
     * <b>REQUIRED</b>.
     * <p>
     * The server host name. It MAY include the port. This field supports {@link ServerVariable}.
     * <p>
     * Variable substitutions will be made when a variable is named in {braces}.
     */
    @NotNull
    @JsonProperty
    @Builder.Default
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Server host name\n\n" +
                    "The server host name. It MAY include the port.\n\n" +
                    "This field supports ServerVariable.\n\n" +
                    "Variable substitutions will be made when a variable is named in {braces}."
    )
    private String host = "";

    /**
     * <b>REQUIRED</b>.
     * <p>
     * The protocol this URL supports for connection. Supported protocol include, but are not limited to:
     * amqp, amqps, http, https, jms, kafka, kafka-secure, mqtt, secure-mqtt, stomp, stomps, ws, wss.
     */
    @NotNull
    @JsonProperty
    @Builder.Default
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Protocol for connection\n\n" +
                    "The protocol this URL supports for connection.\n\n" +
                    "Supported protocol include, but are not limited to: \n" +
                    "amqp, amqps, http, https, jms, kafka, kafka-secure, mqtt, secure-mqtt, stomp, stomps, ws, wss."
    )
    private String protocol = "";

    /**
     * The version of the protocol used for connection. For instance: AMQP 0.9.1, HTTP 2.0, Kafka 1.0.0, etc.
     */
    @Nullable
    @JsonProperty
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Version of the protocol\n\n" +
                    "The version of the protocol used for connection.\n\n" +
                    "For instance: AMQP 0.9.1, HTTP 2.0, Kafka 1.0.0, etc."
    )
    private String protocolVersion;

    /**
     * The path to a resource in the host. This field supports {@link ServerVariable}.
     * <p>
     * Variable substitutions will be made when a variable is named in {braces}.
     */
    @Nullable
    @JsonProperty
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Path to a resource in the host\n\n" +
                    "The path to a resource in the host. This field supports ServerVariable.\n\n" +
                    "Variable substitutions will be made when a variable is named in {braces}."
    )
    private String pathname;

    /**
     * An optional string describing the server. <a href="https://spec.commonmark.org/">CommonMark syntax</a> MAY be used for rich text representation.
     */
    @Nullable
    @JsonProperty
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Description of the server\n\n" +
                    "An optional string describing the server. CommonMark syntax MAY be used for rich text representation."
    )
    private String description;

    /**
     * A human-friendly title for the server.
     */
    @Nullable
    @JsonProperty
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Title for the server\n\n" +
                    "A human-friendly title for the server."
    )
    private String title;

    /**
     * A short summary of the server.
     */
    @Nullable
    @JsonProperty
    @TextDocumentCompletion(
            detail = "String",
            documentation = "A short summary of the server."
    )
    private String summary;

    /**
     * A map between a variable name and its value.
     * <p>
     * The value is used for substitution in the server's {@link #getHost()} and {@link #getPathname()} template.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link ServerVariable}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonProperty
    @JsonDeserialize(using = ServerVariablesDeserializer.class)
    @TextDocumentCompletion(
            detail = "Map<String, ServerVariable | Reference>",
            documentation = "Variables for substitution in server templates\n\n" +
                    "A map between a variable name and its value.\n\n" +
                    "The value is used for substitution in the server's host and pathname template.",
            variants = {ServerVariable.class, Reference.class}
    )
    private Map<String, Object> variables;

    /**
     * A declaration of which security schemes can be used with this server. The list of values includes alternative
     * {@link SecurityScheme} objects that can be used.
     * <p>
     * Only one of the security scheme objects need to be satisfied to authorize a connection or operation.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link SecurityScheme}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonProperty
    @JsonDeserialize(using = SecuritySchemesDeserializer.class)
    @TextDocumentCompletion(
            detail = "List<SecurityScheme | Reference>",
            documentation = "Security schemes for this server\n\n" +
                    "A declaration of which security schemes can be used with this server.\n\n" +
                    "Only one of the security scheme objects need to be satisfied to authorize a connection or operation.",
            variants = {SecurityScheme.class, Reference.class}
    )
    private List<Object> security;

    /**
     * A list of tags for logical grouping and categorization of servers.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Tag}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonProperty
    @JsonDeserialize(using = TagsDeserializer.class)
    @TextDocumentCompletion(
            detail = "List<Tag | Reference>",
            documentation = "Tags for categorization of servers\n\n" +
                    "A list of tags for logical grouping and categorization of servers.",
            variants = {Tag.class, Reference.class}
    )
    private List<Object> tags;

    /**
     * Additional external documentation of the exposed API.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link ExternalDocumentation}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonProperty
    @JsonDeserialize(using = ExternalDocumentationDeserializer.class)
    @TextDocumentCompletion(
            detail = "ExternalDocumentation | Reference",
            documentation = "Additional external documentation of the exposed API.",
            variants = {ExternalDocumentation.class, Reference.class}
    )
    private Object externalDocs;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions
     * for the server.
     * <p>
     * MUST be one of:
     * <ul>
     *     <li>{@link ServerBinding}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ServerBindingsDeserializer.class)
    @TextDocumentCompletion(
            detail = "Map<String, ServerBinding | Reference>",
            documentation = "Protocol-specific definitions for the server\n\n" +
                    "A map where the keys describe the name of the protocol and the values describe protocol-specific definitions for the server.",
            variants = {ServerBinding.class, Reference.class}
    )
    private Map<String, Object> bindings;

}
