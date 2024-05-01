package com.asyncapi.v3._0_0.model.component;

import com.asyncapi.v3._0_0.jackson.model.component.*;
import com.asyncapi.schemas.Reference;
import com.asyncapi.v3._0_0.model.ExternalDocumentation;
import com.asyncapi.v3._0_0.model.Tag;
import com.asyncapi.v3._0_0.model.channel.Channel;
import com.asyncapi.v3._0_0.model.channel.Parameter;
import com.asyncapi.v3._0_0.model.channel.message.CorrelationId;
import com.asyncapi.v3._0_0.model.channel.message.Message;
import com.asyncapi.v3._0_0.model.channel.message.MessageTrait;
import com.asyncapi.v3._0_0.model.operation.Operation;
import com.asyncapi.v3._0_0.model.operation.OperationTrait;
import com.asyncapi.v3._0_0.model.operation.reply.OperationReply;
import com.asyncapi.v3._0_0.model.operation.reply.OperationReplyAddress;
import com.asyncapi.v3._0_0.model.server.Server;
import com.asyncapi.v3._0_0.model.server.ServerVariable;
import com.asyncapi.bindings.ChannelBinding;
import com.asyncapi.bindings.MessageBinding;
import com.asyncapi.bindings.OperationBinding;
import com.asyncapi.bindings.ServerBinding;
import com.asyncapi.bindings.ChannelBindingsDeserializer;
import com.asyncapi.bindings.MessageBindingsDeserializer;
import com.asyncapi.bindings.OperationBindingsDeserializer;
import com.asyncapi.bindings.ServerBindingsDeserializer;
import com.asyncapi.schemas.multiformat.MultiFormatSchema;
import com.asyncapi.schemas.AsyncAPISchema;
import com.asyncapi.v3.security_scheme.SecurityScheme;
import com.asyncapi.schemas.ExtendableObject;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Holds a set of reusable objects for different aspects of the AsyncAPI specification.
 * All objects defined within the components object will have no effect on the API unless they are explicitly referenced
 * from properties outside the components object.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#componentsObject">Components Object</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Components extends ExtendableObject {

    /**
     * An object to hold reusable Schema Object.
     * <p>
     * If this is a {@link AsyncAPISchema}, then the schemaFormat will be assumed to be "application/vnd.aai.asyncapi+json;version=asyncapi"
     * where the version is equal to the AsyncAPI Version String.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link AsyncAPISchema}</li>
     *     <li>{@link MultiFormatSchema}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsSchemasDeserializer.class)
    private Map<String, Object> schemas;

    /**
     * An object to hold reusable {@link Server} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Server}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsServersDeserializer.class)
    private Map<String, Object> servers;

    /**
     * An object to hold reusable {@link ServerVariable} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link ServerVariable}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsServerVariablesDeserializer.class)
    private Map<String, Object> serverVariables;

    /**
     * An object to hold reusable {@link Channel} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Channel}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsChannelsDeserializer.class)
    private Map<String, Object> channels;

    /**
     * An object to hold reusable {@link Operation} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Operation}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsOperationsDeserializer.class)
    private Map<String, Object> operations;

    /**
     * An object to hold reusable {@link OperationReply} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link OperationReply}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsRepliesDeserializer.class)
    private Map<String, Object> replies;

    /**
     * An object to hold reusable {@link OperationReplyAddress} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link OperationReplyAddress}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsReplyAddressesDeserializer.class)
    private Map<String, Object> replyAddresses;

    /**
     * An object to hold reusable {@link Message} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Message}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsMessagesDeserializer.class)
    private Map<String, Object> messages;

    /**
     * An object to hold reusable {@link SecurityScheme} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link SecurityScheme}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsSecuritySchemesDeserializer.class)
    private Map<String, Object> securitySchemes;

    /**
     * An object to hold reusable {@link Parameter} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *      <li>{@link Parameter}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsParametersDeserializer.class)
    private Map<String, Object> parameters;

    /**
     * An object to hold reusable {@link CorrelationId} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link CorrelationId}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsCorrelationIdsDeserializer.class)
    private Map<String, Object> correlationIds;

    /**
     * An object to hold reusable {@link OperationTrait} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link OperationTrait}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsOperationTraitsDeserializer.class)
    private Map<String, Object> operationTraits;

    /**
     * An object to hold reusable {@link MessageTrait} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link MessageTrait}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsMessageTraitsDeserializer.class)
    private Map<String, Object> messageTraits;

    /**
     * An object to hold reusable {@link ServerBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link ServerBinding}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ServerBindingsDeserializer.class)
    private Map<String, Object> serverBindings;

    /**
     * An object to hold reusable {@link ChannelBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link ChannelBinding}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ChannelBindingsDeserializer.class)
    private Map<String, Object> channelBindings;

    /**
     * An object to hold reusable {@link OperationBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link OperationBinding}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, Object> operationBindings;

    /**
     * An object to hold reusable {@link MessageBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link MessageBinding}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    private Map<String, Object> messageBindings;

    /**
     * An object to hold reusable {@link ExternalDocumentation} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link ExternalDocumentation}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsExternalDocsDeserializer.class)
    private Map<String, Object> externalDocs;

    /**
     * An object to hold reusable {@link Tag} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link Tag}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsTagsDeserializer.class)
    private Map<String, Object> tags;

}
