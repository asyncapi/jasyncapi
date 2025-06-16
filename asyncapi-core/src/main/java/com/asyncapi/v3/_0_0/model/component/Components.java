package com.asyncapi.v3._0_0.model.component;

import com.asyncapi.lsp.TextDocumentCompletion;
import com.asyncapi.v3._0_0.jackson.model.component.*;
import com.asyncapi.schemas.asyncapi.Reference;
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
import com.asyncapi.schemas.asyncapi.multiformat.MultiFormatSchema;
import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.asyncapi.schemas.asyncapi.security.v3.SecurityScheme;
import com.asyncapi.schemas.asyncapi.ExtendableObject;
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
    @TextDocumentCompletion(
            detail = "Map<String, AsyncAPISchema | MultiFormatSchema | Reference>",
            documentation = "Reusable Schema Objects\n\n" +
                    "An object to hold reusable Schema Objects.",
            variants = {AsyncAPISchema.class, MultiFormatSchema.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, Server | Reference>",
            documentation = "Reusable Server Objects\n\n" +
                    "An object to hold reusable Server Objects.",
            variants = {Server.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, ServerVariable | Reference>",
            documentation = "Reusable ServerVariable Objects\n\n" +
                    "An object to hold reusable ServerVariable Objects.",
            variants = {ServerVariable.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, Channel | Reference>",
            documentation = "Reusable Channel Objects\n\n" +
                    "An object to hold reusable Channel Objects.",
            variants = {Channel.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, Operation | Reference>",
            documentation = "Reusable Operation Objects\n\n" +
                    "An object to hold reusable Operation Objects.",
            variants = {Operation.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, OperationReply | Reference>",
            documentation = "Reusable OperationReply Objects\n\n" +
                    "An object to hold reusable OperationReply Objects.",
            variants = {OperationReply.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, OperationReplyAddress | Reference>",
            documentation = "Reusable OperationReplyAddress Objects\n\n" +
                    "An object to hold reusable OperationReplyAddress Objects.",
            variants = {OperationReplyAddress.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, Message | Reference>",
            documentation = "Reusable Message Objects\n\n" +
                    "An object to hold reusable Message Objects.",
            variants = {Message.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, SecurityScheme | Reference>",
            documentation = "Reusable SecurityScheme Objects\n\n" +
                    "An object to hold reusable SecurityScheme Objects.",
            variants = {SecurityScheme.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, Parameter | Reference>",
            documentation = "Reusable Parameter Objects\n\n" +
                    "An object to hold reusable Parameter Objects.",
            variants = {Parameter.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, CorrelationId | Reference>",
            documentation = "Reusable CorrelationId Objects\n\n" +
                    "An object to hold reusable CorrelationId Objects.",
            variants = {CorrelationId.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, OperationTrait | Reference>",
            documentation = "Reusable OperationTrait Objects\n\n" +
                    "An object to hold reusable OperationTrait Objects.",
            variants = {OperationTrait.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, MessageTrait | Reference>",
            documentation = "Reusable MessageTrait Objects\n\n" +
                    "An object to hold reusable MessageTrait Objects.",
            variants = {MessageTrait.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, ServerBinding | Reference>",
            documentation = "Reusable ServerBinding Objects\n\n" +
                    "An object to hold reusable ServerBinding Objects.",
            variants = {ServerBinding.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, ChannelBinding | Reference>",
            documentation = "Reusable ChannelBinding Objects\n\n" +
                    "An object to hold reusable ChannelBinding Objects.",
            variants = {ChannelBinding.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, OperationBinding | Reference>",
            documentation = "Reusable OperationBinding Objects\n\n" +
                    "An object to hold reusable OperationBinding Objects.",
            variants = {OperationBinding.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, MessageBinding | Reference>",
            documentation = "Reusable MessageBinding Objects\n\n" +
                    "An object to hold reusable MessageBinding Objects.",
            variants = {MessageBinding.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, ExternalDocumentation | Reference>",
            documentation = "Reusable ExternalDocumentation Objects\n\n" +
                    "An object to hold reusable ExternalDocumentation Objects.",
            variants = {ExternalDocumentation.class, Reference.class}
    )
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
    @TextDocumentCompletion(
            detail = "Map<String, ExternalDocumentation | Reference>",
            documentation = "Reusable Tag Objects\n\n" +
                    "An object to hold reusable Tag Objects.",
            variants = {Tag.class, Reference.class}
    )
    private Map<String, Object> tags;

}
