package com.asyncapi.v2.model.server;

import com.asyncapi.v2.binding.ServerBinding;
import com.asyncapi.v2.binding.ServerBindingsDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.util.List;
import java.util.Map;

/**
 * An object representing a message broker, a server or any other kind of computer program capable of sending and/or
 * receiving data. This object is used to capture details such as URIs, protocols and security configuration.
 * Variable substitution can be used so that some details, for example usernames and passwords, can be injected by
 * code generation tools.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Server {

    /**
     * REQUIRED.
     *
     * A URL to the target host. This URL supports Server Variables and MAY be relative, to indicate that the host
     * location is relative to the location where the AsyncAPI document is being served. Variable substitutions will be
     * made when a variable is named in {brackets}.
     */
    @Nonnull
    @NonNull
    private String url;

    /**
     * REQUIRED.
     *
     * The protocol this URL supports for connection. Supported protocol include, but are not limited to:
     * amqp, amqps, http, https, jms, kafka, kafka-secure, mqtt, secure-mqtt, stomp, stomps, ws, wss.
     */
    @Nonnull
    @NonNull
    private String protocol;

    /**
     * The version of the protocol used for connection. For instance: AMQP 0.9.1, HTTP 2.0, Kafka 1.0.0, etc.
     */
    @CheckForNull
    private String protocolVersion;

    /**
     * An optional string describing the host designated by the URL. CommonMark syntax MAY be used for rich text
     * representation.
     */
    @CheckForNull
    private String description;

    /**
     * A map between a variable name and its value. The value is used for substitution in the server's URL template.
     */
    @CheckForNull
    private Map<String, ServerVariable> variables;

    /**
     * A declaration of which security mechanisms can be used with this server. The list of values includes alternative
     * security requirement objects that can be used. Only one of the security requirement objects need to be satisfied
     * to authorize a connection or operation.
     *
     * Lists the required security schemes to execute this operation. The name used for each property MUST correspond
     * to a security scheme declared in the Security Schemes under the Components Object.
     *
     * When a list of Security Requirement Objects is defined on a Server object, only one of the Security Requirement
     * Objects in the list needs to be satisfied to authorize the connection.
     */
    @CheckForNull
    private List<Map<String, List<String>>> security;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions
     * for the server.
     */
    @CheckForNull
    @JsonDeserialize(using = ServerBindingsDeserializer.class)
    private Map<String, ? extends ServerBinding> bindings;

}
