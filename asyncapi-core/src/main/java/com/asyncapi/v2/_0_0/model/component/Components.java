package com.asyncapi.v2._0_0.model.component;

import com.asyncapi.v2._0_0.jackson.model.component.ComponentsMessagesDeserializer;
import com.asyncapi.v2._0_0.jackson.model.component.ComponentsParametersDeserializer;
import com.asyncapi.v2._0_0.jackson.model.component.ComponentsSchemasDeserializer;
import com.asyncapi.v2._0_0.jackson.model.component.ComponentsSecuritySchemesDeserializer;
import com.asyncapi.v2._0_0.model.Reference;
import com.asyncapi.v2._0_0.model.channel.Parameter;
import com.asyncapi.v2._0_0.model.channel.message.CorrelationId;
import com.asyncapi.v2._0_0.model.channel.message.Message;
import com.asyncapi.v2._0_0.model.channel.message.MessageTrait;
import com.asyncapi.v2._0_0.model.channel.operation.OperationTrait;
import com.asyncapi.v2._0_0.model.schema.Schema;
import com.asyncapi.v2.binding.channel.ChannelBinding;
import com.asyncapi.v2.binding.message.MessageBinding;
import com.asyncapi.v2.binding.operation.OperationBinding;
import com.asyncapi.v2.jackson.binding.channel.ChannelBindingsDeserializer;
import com.asyncapi.v2.jackson.binding.message.MessageBindingsDeserializer;
import com.asyncapi.v2.jackson.binding.operation.OperationBindingsDeserializer;
import com.asyncapi.v2.jackson.binding.server.ServerBindingsDeserializer;
import com.asyncapi.v2.security_scheme.SecurityScheme;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import java.util.Map;

/**
 * Holds a set of reusable objects for different aspects of the AsyncAPI specification. All objects defined within the
 * components object will have no effect on the API unless they are explicitly referenced from properties outside the
 * components object.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#componentsObject">Components</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Components {

    /**
     * An object to hold reusable Schema Objects.
     *
     * MUST BE:
     * <ul>
     *     <li>{@link Schema}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsSchemasDeserializer.class)
    private Map<String, Object> schemas;

    /**
     * An object to hold reusable Message Objects.
     *
     * MUST BE:
     * <ul>
     *     <li>{@link Message}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsMessagesDeserializer.class)
    private Map<String, Object> messages;

    /**
     * An object to hold reusable Security Scheme Objects.
     *
     * MUST BE:
     * <ul>
     *     <li>{@link SecurityScheme}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsSecuritySchemesDeserializer.class)
    private Map<String, Object> securitySchemes;

    /**
     * An object to hold reusable Parameter Objects.
     *
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link Parameter}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsParametersDeserializer.class)
    private Map<String, Object> parameters;

    /**
     * An object to hold reusable Correlation ID Objects.
     */
    @CheckForNull
    private Map<String, CorrelationId> correlationIds;

    /**
     * An object to hold reusable Operation Trait Objects.
     */
    @CheckForNull
    private Map<String, OperationTrait> operationTraits;

    /**
     * An object to hold reusable Message Trait Objects.
     */
    @CheckForNull
    private Map<String, MessageTrait> messageTraits;

    /**
     * An object to hold reusable Server Binding Objects.
     */
    @CheckForNull
    @JsonDeserialize(using = ServerBindingsDeserializer.class)
    private Map<String, ? extends ServerBindingsDeserializer> serverBindings;

    /**
     * An object to hold reusable Channel Binding Objects.
     */
    @CheckForNull
    @JsonDeserialize(using = ChannelBindingsDeserializer.class)
    private Map<String, ? extends ChannelBinding> channelBindings;

    /**
     * An object to hold reusable Operation Binding Objects.
     */
    @CheckForNull
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, ? extends OperationBinding> operationBindings;

    /**
     * An object to hold reusable Message Binding Objects.
     */
    @CheckForNull
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    private Map<String, ? extends MessageBinding> messageBindings;

}
