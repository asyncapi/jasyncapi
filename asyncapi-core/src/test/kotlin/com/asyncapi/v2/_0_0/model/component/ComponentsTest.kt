package com.asyncapi.v2._0_0.model.component

import com.asyncapi.v2.SerDeTest
import com.asyncapi.schemas.asyncapi.Reference
import com.asyncapi.v2._0_0.model.channel.ChannelItemTest
import com.asyncapi.v2._0_0.model.channel.ParameterTest
import com.asyncapi.v2._0_0.model.channel.message.CorrelationIdTest
import com.asyncapi.v2._0_0.model.channel.message.MessageTest
import com.asyncapi.v2._0_0.model.channel.message.MessageTraitTest
import com.asyncapi.v2._0_0.model.channel.operation.OperationTest
import com.asyncapi.v2._0_0.model.channel.operation.OperationTraitTest
import com.asyncapi.schemas.asyncapi.AsyncAPISchema
import com.asyncapi.schemas.Type
import com.asyncapi.v2._0_0.model.server.ServerTest
import com.asyncapi.schemas.security.v2.ApiKeySecuritySchemeTest
import com.asyncapi.schemas.security.v2.OpenIdConnectSecuritySchemeTest
import com.asyncapi.schemas.security.v2.http.HttpApiKeySecuritySchemeTest
import com.asyncapi.schemas.security.v2.http.HttpSecuritySchemeBasicTest
import com.asyncapi.schemas.security.v2.http.HttpSecuritySchemeBearerTest
import com.asyncapi.schemas.security.v2.oauth2.OAuth2SecuritySchemeTest

/**
 * @author Pavel Bodiachevskii
 */
class ComponentsTest: SerDeTest<Components>() {

    override fun objectClass() = Components::class.java

    override fun baseObjectJson() = "/json/v2/2.0.0/model/components/components.json"

    override fun extendedObjectJson() = "/json/v2/2.0.0/model/components/components - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.0.0/model/components/components - wrongly extended.json"

    override fun build(): Components {
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
                        Pair("Tag", AsyncAPISchema.builder()
                                .type(Type.OBJECT)
                                .properties(mapOf(
                                        Pair("id", AsyncAPISchema.builder().type(Type.INTEGER).format("int64").build()),
                                        Pair("name", AsyncAPISchema.builder().type(Type.STRING).build())
                                ))
                                .build()
                        ),
                        Pair("User",
                            Reference("#/components/schemas/user")
                        )
                ))
                .messages(mapOf(
                        Pair("userSignup", MessageTest().build()),
                        Pair("userSignout",
                            Reference("#/components/messages/userSignout")
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
                        Pair("parameter", ParameterTest().build()),
                        Pair("parameterRef",
                            Reference("#/components/parameters/parameter")
                        )
                ))
                .correlationIds(mapOf(
                        Pair("userSignupCorrelationId", CorrelationIdTest().build()),
                ))
                .operationTraits(mapOf(
                        Pair("sendMessage", OperationTraitTest().build()),
                ))
                .messageTraits(mapOf(
                        Pair("userSignup", MessageTraitTest().build()),
                ))
                .serverBindings(ServerTest.bindings())
                .channelBindings(ChannelItemTest.bindings())
                .operationBindings(OperationTest.bindings())
                .messageBindings(MessageTest.bindings())
                .build()
    }

}
