package com.asyncapi.v2._6_0.binding.server.ibmmq;

import com.asyncapi.v2._6_0.binding.server.ServerBinding;
import lombok.*;

import javax.annotation.CheckForNull;

/**
 * Describes IBM MQ server binding.
 * <p>
 * This object contains server connection information about the IBM MQ server, referred to as an IBM MQ queue manager.
 * This object contains additional connectivity information not possible to represent within the core AsyncAPI specification.
 *
 * @version 0.1.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/ibmmq">Redis server binding</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class IBMMQServerBinding extends ServerBinding {

    /**
     * Defines a logical group of IBM MQ server objects. This is necessary to specify multi-endpoint configurations used
     * in high availability deployments. If omitted, the server object is not part of a group.
     * <p>
     * MUST NOT be specified for URI Scheme http:// or file://
     */
    @CheckForNull
    private String groupId;

    /**
     * The name of the IBM MQ queue manager to bind to in the CCDT file.
     * <p>
     * MUST NOT be specified for URI Scheme ibmmq://
     */
    @CheckForNull
    @Builder.Default
    private String ccdtQueueManagerName = "*";

    /**
     * The recommended cipher specification used to establish a TLS connection between the client and the IBM MQ queue manager.
     * More information on SSL/TLS cipher specifications supported by IBM MQ can be found on this page in the IBM MQ Knowledge Center.
     * <p>
     * MUST NOT be specified for protocol ibmmq or URI Scheme file:// or http://
     */
    @CheckForNull
    @Builder.Default
    private String cipherSpec = "ANY";

    /**
     * If multiEndpointServer is true then multiple connections can be workload balanced and applications should not make
     * assumptions as to where messages are processed. Where message ordering, or affinity to specific message resources
     * is necessary, a single endpoint (multiEndpointServer = false) may be required.
     * <p>
     * MUST NOT be specified for URI Scheme file:// or http://
     */
    @Builder.Default
    private boolean multiEndpointServer = false;

    /**
     * The recommended value (in seconds) for the heartbeat sent to the queue manager during periods of inactivity.
     * A value of zero means that no heart beats are sent. A value of 1 means that the client will use the value defined by the queue manager.
     * More information on heart beat interval can be found on this <a href="https://www.ibm.com/support/knowledgecenter/SSFKSJ_latest/com.ibm.mq.ref.dev.doc/q108450_.html">page</a> in the IBM MQ Knowledge Center.
     * <p>
     * MUST be 0-999999
     */
    @Builder.Default
    private int heartBeatInterval = 300;

    /**
     * The version of this binding.
     */
    @Builder.Default
    private String bindingVersion = "0.1.0";

}
