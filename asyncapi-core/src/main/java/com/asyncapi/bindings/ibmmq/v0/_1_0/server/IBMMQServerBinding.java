package com.asyncapi.bindings.ibmmq.v0._1_0.server;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Describes IBM MQ server binding.
 * <p>
 * This object contains server connection information about the IBM MQ server, referred to as an IBM MQ queue manager.
 * This object contains additional connectivity information not possible to represent within the core AsyncAPI specification.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/ibmmq#server-binding-object">IBM MQ server binding</a>
 * @see <a href="https://www.ibm.com/products/mq">IBM MQ</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes IBM MQ server binding.")
public class IBMMQServerBinding extends com.asyncapi.bindings.ibmmq.IBMMQServerBinding {

    /**
     * Defines a logical group of IBM MQ server objects. This is necessary to specify multi-endpoint configurations used
     * in high availability deployments. If omitted, the server object is not part of a group.
     * <p>
     * MUST NOT be specified for URI Scheme http:// or file://
     */
    @Nullable
    @JsonProperty("groupId")
    @JsonPropertyDescription("Defines a logical group of IBM MQ server objects. This is necessary to specify multi-endpoint configurations used in high availability deployments. If omitted, the server object is not part of a group.")
    private String groupId;

    /**
     * The name of the IBM MQ queue manager to bind to in the CCDT file.
     * <p>
     * MUST NOT be specified for URI Scheme ibmmq://
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "ccdtQueueManagerName", defaultValue = "*")
    @JsonPropertyDescription("The name of the IBM MQ queue manager to bind to in the CCDT file.")
    private String ccdtQueueManagerName = "*";

    /**
     * The recommended cipher specification used to establish a TLS connection between the client and the IBM MQ queue manager.
     * More information on SSL/TLS cipher specifications supported by IBM MQ can be found on this page in the IBM MQ Knowledge Center.
     * <p>
     * MUST NOT be specified for protocol ibmmq or URI Scheme file:// or http://
     */
    @Nullable
    @Builder.Default
    @JsonProperty(value = "cipherSpec", defaultValue = "ANY")
    @JsonPropertyDescription("The recommended cipher specification used to establish a TLS connection between the client and the IBM MQ queue manager. More information on SSL/TLS cipher specifications supported by IBM MQ can be found on this page in the IBM MQ Knowledge Center.")
    private String cipherSpec = "ANY";

    /**
     * If multiEndpointServer is true then multiple connections can be workload balanced and applications should not make
     * assumptions as to where messages are processed. Where message ordering, or affinity to specific message resources
     * is necessary, a single endpoint (multiEndpointServer = false) may be required.
     * <p>
     * MUST NOT be specified for URI Scheme file:// or http://
     */
    @Builder.Default
    @JsonProperty(value = "multiEndpointServer", defaultValue = "false")
    @JsonPropertyDescription("If multiEndpointServer is true then multiple connections can be workload balanced and applications should not make assumptions as to where messages are processed. Where message ordering, or affinity to specific message resources is necessary, a single endpoint (multiEndpointServer = false) may be required. MUST NOT be specified for URI Scheme file:// or http://")
    private Boolean multiEndpointServer = false;

    /**
     * The recommended value (in seconds) for the heartbeat sent to the queue manager during periods of inactivity.
     * A value of zero means that no heart beats are sent. A value of 1 means that the client will use the value defined by the queue manager.
     * More information on heart beat interval can be found on this <a href="https://www.ibm.com/support/knowledgecenter/SSFKSJ_latest/com.ibm.mq.ref.dev.doc/q108450_.html">page</a> in the IBM MQ Knowledge Center.
     * <p>
     * MUST be 0-999999
     */
    @Builder.Default
    @javax.validation.constraints.Min(
            value = 0,
            message = "Heart beat interval must be greater or equals to 0"
    )
    @javax.validation.constraints.Max(
            value = 999999,
            message = "Heart beat interval must be less or equals to 999999"
    )
    @JsonProperty(value = "heartBeatInterval", defaultValue = "300")
    @JsonPropertyDescription("The recommended value (in seconds) for the heartbeat sent to the queue manager during periods of inactivity. A value of zero means that no heart beats are sent. A value of 1 means that the client will use the value defined by the queue manager.")
    private int heartBeatInterval = 300;

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
