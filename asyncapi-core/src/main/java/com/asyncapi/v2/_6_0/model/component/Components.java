package com.asyncapi.v2._6_0.model.component;

import com.asyncapi.v2._6_0.binding.server.ServerBinding;
import com.asyncapi.v2._6_0.jackson.binding.server.ServerBindingsDeserializer;
import com.asyncapi.v2._6_0.jackson.model.server.ServerVariablesDeserializer;
import com.asyncapi.v2._6_0.jackson.model.server.ServersDeserializer;
import com.asyncapi.v2.binding.*;
import com.asyncapi.v2.jackson.ComponentsMessagesDeserializer;
import com.asyncapi.v2.jackson.ComponentsParametersDeserializer;
import com.asyncapi.v2.jackson.ComponentsSchemasDeserializer;
import com.asyncapi.v2.jackson.ComponentsSecuritySchemesDeserializer;
import com.asyncapi.v2.model.channel.message.CorrelationId;
import com.asyncapi.v2.model.channel.message.MessageTrait;
import com.asyncapi.v2.model.channel.operation.OperationTrait;
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
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#componentsObject">Components</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Components {

    /**
     * An object to hold reusable {@link }Schema Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2.model.schema.Schema}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsSchemasDeserializer.class)
    private Map<String, Object> schemas;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.server.Server} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.server.Server}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ServersDeserializer.class)
    private Map<String, Object> servers;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.server.ServerVariable} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.server.Server}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ServerVariablesDeserializer.class)
    private Map<String, Object> serverVariables;

    /**
     * An object to hold reusable {@link com.asyncapi.v2.model.channel.ChannelItem} Objects.
     */
    private Map<String, Object> channels;

    /**
     * An object to hold reusable {@link com.asyncapi.v2.model.channel.message.Message} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2.model.channel.message.Message}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsMessagesDeserializer.class)
    private Map<String, Object> messages;

    /**
     * An object to hold reusable {@link com.asyncapi.v2.model.security_scheme.SecurityScheme} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2.model.security_scheme.SecurityScheme}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsSecuritySchemesDeserializer.class)
    private Map<String, Object> securitySchemes;

    /**
     * An object to hold reusable {@link com.asyncapi.v2.model.channel.Parameter} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2.model.channel.Parameter}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsParametersDeserializer.class)
    private Map<String, Object> parameters;

    /**
     * An object to hold reusable {@link com.asyncapi.v2.model.channel.message.CorrelationId} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2.model.channel.message.CorrelationId}</li>
     * </ul>
     */
    @CheckForNull
    private Map<String, CorrelationId> correlationIds;

    /**
     * An object to hold reusable {@link com.asyncapi.v2.model.channel.operation.OperationTrait} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2.model.channel.operation.OperationTrait}</li>
     * </ul>
     */
    @CheckForNull
    private Map<String, OperationTrait> operationTraits;

    /**
     * An object to hold reusable {@link com.asyncapi.v2.model.channel.message.MessageTrait} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2.model.channel.message.MessageTrait}</li>
     * </ul>
     */
    @CheckForNull
    private Map<String, MessageTrait> messageTraits;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.binding.server.ServerBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.binding.server.ServerBinding}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ServerBindingsDeserializer.class)
    private Map<String, ? extends ServerBinding> serverBindings;

    /**
     * An object to hold reusable {@link com.asyncapi.v2.binding.ChannelBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2.binding.ChannelBinding}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ChannelBindingsDeserializer.class)
    private Map<String, ? extends ChannelBinding> channelBindings;

    /**
     * An object to hold reusable {@link com.asyncapi.v2.binding.OperationBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2.binding.OperationBinding}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, ? extends OperationBinding> operationBindings;

    /**
     * An object to hold reusable {@link com.asyncapi.v2.binding.MessageBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2.binding.MessageBinding}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    private Map<String, ? extends MessageBinding> messageBindings;

}
