package com.asyncapi.v2._0_0.model.server;

import com.asyncapi.v2.ExtendableObject;
import com.asyncapi.v2.binding.server.ServerBinding;
import com.asyncapi.v2.jackson.binding.server.ServerBindingsDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
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
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#serverObject">Server</a>
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
     *
     * A URL to the target host. This URL supports Server Variables and MAY be relative, to indicate that the host
     * location is relative to the location where the AsyncAPI document is being served. Variable substitutions will be
     * made when a variable is named in {brackets}.
     */
    @NotNull
    @JsonProperty
    @Builder.Default
    private String url = "";

    /**
     * REQUIRED.
     *
     * The protocol this URL supports for connection. Supported protocol include, but are not limited to:
     * amqp, amqps, http, https, jms, kafka, kafka-secure, mqtt, secure-mqtt, stomp, stomps, ws, wss.
     */
    @NotNull
    @JsonProperty
    @Builder.Default
    private String protocol = "";

    /**
     * The version of the protocol used for connection. For instance: AMQP 0.9.1, HTTP 2.0, Kafka 1.0.0, etc.
     */
    @Nullable
    @JsonProperty
    private String protocolVersion;

    /**
     * An optional string describing the host designated by the URL. CommonMark syntax MAY be used for rich text
     * representation.
     */
    @Nullable
    @JsonProperty
    private String description;

    /**
     * A map between a variable name and its value. The value is used for substitution in the server's URL template.
     */
    @Nullable
    @JsonProperty
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
    @Nullable
    @JsonProperty
    private List<Map<String, List<String>>> security;

    /**
     * A map where the keys describe the name of the protocol and the values describe protocol-specific definitions
     * for the server.
     */
    @Nullable
    @JsonDeserialize(using = ServerBindingsDeserializer.class)
    private Map<String, ? extends ServerBinding> bindings;

}
