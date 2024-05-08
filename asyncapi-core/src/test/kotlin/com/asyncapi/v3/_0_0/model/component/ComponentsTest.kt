package com.asyncapi.v3._0_0.model.component

import com.asyncapi.schemas.Reference
import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3._0_0.model.ExternalDocumentationTest
import com.asyncapi.v3._0_0.model.TagTest
import com.asyncapi.v3._0_0.model.TagTestWithReferenceToExternalDocs
import com.asyncapi.v3._0_0.model.channel.ChannelTest
import com.asyncapi.v3._0_0.model.channel.ChannelTestWithReference
import com.asyncapi.v3._0_0.model.channel.ParameterTest
import com.asyncapi.v3._0_0.model.channel.message.*
import com.asyncapi.v3._0_0.model.operation.OperationTest
import com.asyncapi.v3._0_0.model.operation.OperationTestWithReference
import com.asyncapi.v3._0_0.model.operation.OperationTraitTest
import com.asyncapi.v3._0_0.model.operation.OperationTraitTestWithReference
import com.asyncapi.v3._0_0.model.operation.reply.OperationReplyAddressTest
import com.asyncapi.v3._0_0.model.operation.reply.OperationReplyTest
import com.asyncapi.v3._0_0.model.operation.reply.OperationReplyTestWithReference
import com.asyncapi.v3._0_0.model.server.ServerTest
import com.asyncapi.v3._0_0.model.server.ServerVariableTest
import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.json.JsonSchema
import com.asyncapi.schemas.Type
import com.asyncapi.schemas.multiformat.JsonFormatSchema
import com.asyncapi.schemas.security.v3.ApiKeySecuritySchemeTest
import com.asyncapi.schemas.security.v3.OpenIdConnectSecuritySchemeTest
import com.asyncapi.schemas.security.v3.http.HttpApiKeySecuritySchemeTest
import com.asyncapi.schemas.security.v3.http.HttpSecuritySchemeBasicTest
import com.asyncapi.schemas.security.v3.http.HttpSecuritySchemeBearerTest
import com.asyncapi.schemas.security.v3.oauth2.OAuth2SecuritySchemeTest

/**
 * @version 3.0-.0
 * @author Pavel Bodiachevskii
 */
class ComponentsTest: SerDeTest<Components>() {

    override fun objectClass() = Components::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/components/components.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/components/components - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/components/components - wrongly extended.json"

    override fun build(): Components {
        /*
            oauth2 // scopes
            openIdConnect // scopes
         */
        return Components.builder()
                .schemas(mapOf(
                        Pair("Category", AsyncAPISchema.builder()
                                .type(Type.OBJECT)
                                .properties(mapOf(
                                        Pair("id", AsyncAPISchema.builder().type(Type.INTEGER).format("int64").build()),
                                        Pair("name", AsyncAPISchema.builder().type(Type.STRING).build())
                                ))
                                .build()
                        ),
                        Pair("Tag", JsonFormatSchema(
                                "application/schema+json;version=draft-07",
                                JsonSchema.builder()
                                        .type("object")
                                        .properties(
                                                mapOf(
                                                        Pair(
                                                                "id", JsonSchema.builder()
                                                                        .type("integer")
                                                                        .format("int64")
                                                                        .build()
                                                        ),
                                                        Pair(
                                                                "name", JsonSchema.builder()
                                                                        .type("string")
                                                                        .build()
                                                        )
                                                )
                                        )
                                        .build()
                        )
                        ),
                        Pair("User", Reference("#/components/schemas/user"))
                ))
                .servers(mapOf(
                        Pair("mqtt-test", ServerTest().build()),
                        Pair("mqtt-stage",
                            Reference("#/components/servers/mqtt-stage")
                        )
                ))
                .serverVariables(mapOf(
                        Pair("port", ServerVariableTest().build()),
                        Pair("basePath",
                            Reference("#/components/serverVariables/basePath")
                        )
                ))
                .channels(mapOf(
                        Pair("channel 1", ChannelTest().build()),
                        Pair("channel 2", ChannelTestWithReference().build()),
                        Pair("channel 3",
                            Reference("#/components/channels/channel")
                        ),
                ))
                .operations(mapOf(
                        Pair("operation 1", OperationTest().build()),
                        Pair("operation 2", OperationTestWithReference().build()),
                        Pair("operation 3",
                            Reference("#/components/operations/operation")
                        )
                ))
                .replies(mapOf(
                        Pair("reply 1", OperationReplyTest().build()),
                        Pair("reply 2", OperationReplyTestWithReference().build()),
                        Pair("reply 3", Reference("#/components/replies/reply"))
                ))
                .replyAddresses(mapOf(
                        Pair("reply addresses 1", OperationReplyAddressTest().build()),
                        Pair("reply addresses 2",
                            Reference("#/components/replyAddresses/replyAddress")
                        )
                ))
                .messages(mapOf(
                        Pair("message 1", MessageTestWithSchema().build()),
                        Pair("message 2", MessageTestWithMultiFormatSchema().build()),
                        Pair("message 3", MessageTestWithReference().build()),
                        Pair("message 4",
                            Reference("#/components/messages/message")
                        )
                ))
                .securitySchemes(mapOf(
                        Pair("apiKey", ApiKeySecuritySchemeTest().build()),
                        Pair("asymmetricEncryption",
                            Reference("#/components/securitySchemes/asymmetricEncryption")
                        ),
                        Pair("gssapi",
                            Reference("#/components/securitySchemes/gssapi")
                        ),
                        Pair("oauth2", OAuth2SecuritySchemeTest().build()),
                        Pair("openIdConnect", OpenIdConnectSecuritySchemeTest().build()),
                        Pair("httpApiKey", HttpApiKeySecuritySchemeTest().build()),
                        Pair("httpBasic", HttpSecuritySchemeBasicTest().build()),
                        Pair("httpBearer", HttpSecuritySchemeBearerTest().build()),
                        Pair("plain",
                            Reference("#/components/securitySchemes/plain")
                        ),
                        Pair("scramSha256",
                            Reference("#/components/securitySchemes/scramSha256")
                        ),
                        Pair("scramSha512",
                            Reference("#/components/securitySchemes/scramSha512")
                        ),
                        Pair("symmetricEncryption",
                            Reference("#/components/securitySchemes/symmetricEncryption")
                        ),
                        Pair("userPassword",
                            Reference("#/components/securitySchemes/userPassword")
                        ),
                        Pair("X509",
                            Reference("#/components/securitySchemes/X509")
                        ),
                ))
                .parameters(mapOf(
                        Pair("parameter 1", ParameterTest().build()),
                        Pair("parameter 2",
                            Reference("#/components/parameters/parameter")
                        )
                ))
                .correlationIds(mapOf(
                        Pair("correlationId 1", CorrelationIdTest().build()),
                        Pair("correlationId 2",
                            Reference("#/correlationIds/parameters/correlationId")
                        )
                ))
                .operationTraits(mapOf(
                        Pair("operationTrait 1", OperationTraitTest().build()),
                        Pair("operationTrait 2", OperationTraitTestWithReference().build()),
                        Pair("operationTrait 3",
                            Reference("#/components/operationTraits/operationTrait")
                        )
                ))
                .messageTraits(mapOf(
                        Pair("messageTrait 1", MessageTraitTestWithSchema().build()),
                        Pair("messageTrait 2", MessageTraitTestWithMultiFormatSchema().build()),
                        Pair("messageTrait 3", MessageTraitTestWithReference().build()),
                        Pair("messageTrait 4",
                            Reference("#/components/messageTraits/messageTrait")
                        )
                ))
                .serverBindings(ServerTest.bindings())
                .channelBindings(ChannelTest.bindings())
                .operationBindings(OperationTest.bindings())
                .messageBindings(MessageTestWithSchema.bindings())
                .externalDocs(mapOf(
                        Pair("externalDoc 1", ExternalDocumentationTest().build()),
                        Pair("externalDoc 2",
                            Reference("#/components/externalDocs/externalDoc")
                        ),
                ))
                .tags(mapOf(
                        Pair("tag 1", TagTest().build()),
                        Pair("tag 2", TagTestWithReferenceToExternalDocs().build()),
                        Pair("tag 3", Reference("#/components/tags/tag")),
                ))
                .build()
    }

}
