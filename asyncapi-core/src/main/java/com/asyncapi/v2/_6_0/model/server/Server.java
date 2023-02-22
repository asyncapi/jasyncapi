package com.asyncapi.v2._6_0.model.server;

import com.asyncapi.v2.ExtendableObject;
import com.asyncapi.v2._6_0.jackson.model.server.ServerVariablesDeserializer;
import com.asyncapi.v2._6_0.model.Tag;
import com.asyncapi.v2.binding.server.ServerBinding;
import com.asyncapi.v2.jackson.binding.server.ServerBindingsDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * An object representing a message broker, a server or any other kind of computer program capable of sending and/or
 * receiving data. This object is used to capture details such as URIs, protocols and security configuration.
 * Variable substitution can be used so that some details, for example usernames and passwords, can be injected by
 * code generation tools.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#serversObject">Server</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Server extends ExtendableObject {

    /**
     * REQUIRED.
     * <p>
     * A URL to the target host. This URL supports Server Variables and MAY be relative, to indicate that the host
     * location is relative to the location where the AsyncAPI document is being served. Variable substitutions will be
     * made when a variable is named in {brackets}.
     */
    @NotNull
    private String url;

    /**
     * REQUIRED.
     * <p>
     * The protocol this URL supports for connection. Supported protocol include, but are not limited to:
     * amqp, amqps, http, https, ibmmq, jms, kafka, kafka-secure, anypointmq, mqtt, secure-mqtt, solace, stomp, stomps, ws, wss, mercure, googlepubsub, pulsar.
     */
    @NotNull
    private String protocol;

    /**
     * The version of the protocol used for connection. For instance: AMQP 0.9.1, HTTP 2.0, Kafka 1.0.0, etc.
     */
    @Nullable
    private String protocolVersion;

    /**
     * An optional string describing the host designated by the URL. <a href="https://spec.commonmark.org/">CommonMark syntax</a> MAY be used for rich text
     * representation.
     */
    @Nullable
    private String description;

    /**
     * A map between a variable name and its value. The value is used for substitution in the server's URL template.
     * <p>
     * MUST be one of:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.server.ServerVariable}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ServerVariablesDeserializer.class)
    private Map<String, Object> variables;

    /**
     * A declaration of which security mechanisms can be used with this server. The list of values includes alternative
     * security requirement objects that can be used. Only one of the security requirement objects need to be satisfied
     * to authorize a connection or operation.
     * <p>
     * Lists the required security schemes to execute this operation. The name used for each property MUST correspond
     * to a security scheme declared in the Security Schemes under the Components Object.
     * <p>
     * When a list of Security Requirement Objects is defined on a Server object, only one of the Security Requirement
     * Objects in the list needs to be satisfied to authorize the connection.
     */
    @Nullable
    private List<Map<String, List<String>>> security;

    /**
     * A list of tags for logical grouping and categorization of servers.
     */
    @Nullable
    private List<Tag> tags;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions
     * for the server.
     * <p>
     * MUST be one of:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link ServerBinding}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ServerBindingsDeserializer.class)
    private Map<String, Object> bindings;

}
