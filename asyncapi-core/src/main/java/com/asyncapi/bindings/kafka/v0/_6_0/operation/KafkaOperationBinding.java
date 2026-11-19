package com.asyncapi.bindings.kafka.v0._6_0.operation;

import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.fasterxml.jackson.annotation.JsonClassDescription;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Describes Kafka operation binding.
 * <p>
 * <code>clientId</code>, <code>groupId</code>, <code>principal</code> and <code>transactionalId</code> are Schema
 * Objects that describe the values a client may use: <code>const</code> (or a one-value <code>enum</code>) means an
 * exact value, <code>pattern: '^&lt;literal&gt;'</code> every value that starts with <code>&lt;literal&gt;</code>.
 * Values shared by many operations, such as the principal of a whole application, can be set once in an operation
 * trait.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/kafka#operation-binding-object">Kafka operation binding</a>
 * @see <a href="https://kafka.apache.org">Kafka</a>
 * @author Pavel Bodiachevskii
 * @version 0.6.0
 * @since 1.0.0-RC6
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonClassDescription("Describes Kafka operation binding.")
public class KafkaOperationBinding extends com.asyncapi.bindings.kafka.KafkaOperationBinding {

    /**
     * The <code>client.id</code> the client uses. Kafka uses it for quotas and logging, not for authorization.
     */
    @Nullable
    @JsonProperty("clientId")
    @JsonPropertyDescription("The `client.id` the client uses. Kafka uses it for quotas and logging, not for authorization")
    private AsyncAPISchema clientId;

    /**
     * The <code>group.id</code> of the group the client joins. Only meaningful on a <code>receive</code> operation.
     */
    @Nullable
    @JsonProperty("groupId")
    @JsonPropertyDescription("The `group.id` of the group the client joins. Only meaningful on a `receive` operation. `pattern: '^<literal>'` matches a PREFIXED Group ACL")
    private AsyncAPISchema groupId;

    /**
     * The type of the group named by <code>groupId</code>. Only meaningful on a <code>receive</code> operation.
     */
    @Nullable
    @JsonProperty("groupType")
    @JsonPropertyDescription("The type of the group named by `groupId`: `classic` (the original group protocol), `consumer` (the consumer group protocol of KIP-848), `share` (a share group, KIP-932) or `streams` (a Kafka Streams group, KIP-1071). Only meaningful on a `receive` operation")
    private KafkaOperationGroupType groupType;

    /**
     * The <code>isolation.level</code> the consumer reads with. Only meaningful on a <code>receive</code> operation.
     * A share group sets this as the group setting <code>share.isolation.level</code> instead.
     */
    @Nullable
    @JsonProperty("isolationLevel")
    @JsonPropertyDescription("The `isolation.level` the consumer reads with. `read_uncommitted` returns every record. `read_committed` returns only committed transactional records: those of aborted transactions are skipped, and those of open transactions wait until they commit. Only meaningful on a `receive` operation. A share group sets this as the group setting `share.isolation.level` instead")
    private KafkaOperationIsolationLevel isolationLevel;

    /**
     * The Kafka principal the client authenticates as, in the <code>&lt;type&gt;:&lt;name&gt;</code> form that ACLs
     * use (for example <code>User:payments-service</code>).
     */
    @Nullable
    @JsonProperty("principal")
    @JsonPropertyDescription("The Kafka principal the client authenticates as, in the `<type>:<name>` form that ACLs use (for example `User:payments-service`). `const` (or `enum`) lists exact principals: Kafka ACLs match a principal exactly, or `User:*` for everyone, never by prefix")
    private AsyncAPISchema principal;

    /**
     * The <code>transactional.id</code> values a transactional producer uses. Its presence means the producer is
     * transactional. Only meaningful on a <code>send</code> operation.
     */
    @Nullable
    @JsonProperty("transactionalId")
    @JsonPropertyDescription("The `transactional.id` values a transactional producer uses. Its presence means the producer is transactional. Only meaningful on a `send` operation. `const` means an exact value; `pattern: '^<literal>'` means every value that starts with `<literal>`, which matches a PREFIXED TransactionalId ACL")
    private AsyncAPISchema transactionalId;

    @Override
    public String getBindingVersion() {
        return "0.6.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.6.0");
    }

}
