package com.asyncapi.examples.v2._0_0

import com.asyncapi.v2.Reference
import com.asyncapi.v2._0_0.model.channel.ChannelItem
import com.asyncapi.v2._0_0.model.channel.message.Message
import com.asyncapi.v2._0_0.model.channel.operation.Operation
import com.asyncapi.v2._0_0.model.component.Components
import com.asyncapi.v2._0_0.model.info.Info
import com.asyncapi.bindings.http.v0._1_0.operation.HTTPOperationBinding
import com.asyncapi.bindings.http.v0._1_0.operation.HTTPOperationMethod
import com.asyncapi.bindings.http.v0._1_0.operation.HTTPOperationType
import com.asyncapi.v2.schema.Schema
import com.asyncapi.v2.security_scheme.oauth2.OAuthFlows
import com.asyncapi.v2.security_scheme.oauth2.OAuth2SecurityScheme
import com.asyncapi.v2.security_scheme.oauth2.flow.ClientCredentialsOAuthFlow

class OperationSecurity: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.0.0/operation-security.yml"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Notifications")
                .version("1.0.0")
                .description("This contract defines HTTP Push notification for  application authorization revocation topic"
                )
                .build()
    }

    override fun expectedServers(): Map<String, Any>? = null

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("AUTHORIZATION_REVOCATION", ChannelItem.builder()
                        .subscribe(Operation.builder()
                                .message(Reference("#/components/messages/message"))
                                .bindings(mapOf(
                                        Pair("http", HTTPOperationBinding.builder()
                                                .type(HTTPOperationType.REQUEST)
                                                .method(HTTPOperationMethod.POST)
                                                .build())
                                ))
                                .build()
                        )
                        .build()
                )
        )
    }

    override fun expectedComponents(): Components? {
        return Components.builder()
                .messages(mapOf(
                        Pair("message", Message.builder()
                                .headers(Schema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("X-SIGNATURE", Schema.builder()
                                                        .type("string")
                                                        .description("ECC message signature")
                                                        .build()
                                                )
                                        ))
                                        .build()
                                )
                                .payload(Schema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("metadata", Schema.builder()
                                                        .ref("#/components/schemas/MetaData")
                                                        .build()
                                                ),
                                                Pair("notification", Schema.builder()
                                                        .ref("#/components/schemas/Notification")
                                                        .build()
                                                )
                                        ))
                                        .build()
                                )
                                .build()
                        )
                ))
                .schemas(mapOf(
                        Pair("MetaData", Schema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("topic", Schema.builder()
                                                .type("string")
                                                .description("Topic subscribed to.")
                                                .build()
                                        ),
                                        Pair("schemaVersion", Schema.builder()
                                                .type("string")
                                                .description("The schema for this topic.")
                                                .build()
                                        ),
                                        Pair("deprecated", Schema.builder()
                                                .type("boolean")
                                                .description("If this is a deprecated schema or topic.")
                                                .defaultValue("false")
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                        Pair("Notification", Schema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("notificationId", Schema.builder()
                                                .type("string")
                                                .description("The notification Id.")
                                                .build()
                                        ),
                                        Pair("eventDate", Schema.builder()
                                                .type("string")
                                                .description("The event date associated with this notification in UTC.")
                                                .build()
                                        ),
                                        Pair("publishDate", Schema.builder()
                                                .type("string")
                                                .description("The message publish date in UTC.")
                                                .build()
                                        ),
                                        Pair("publishAttemptCount", Schema.builder()
                                                .type("integer")
                                                .description("The number of attempts made to publish this message.")
                                                .build()
                                        ),
                                        Pair("publishAttemptCount", Schema.builder()
                                                .type("integer")
                                                .description("The number of attempts made to publish this message.")
                                                .build()
                                        ),
                                        Pair("data", Schema.builder()
                                                .ref("#/components/schemas/AuthorizationRevocationData")
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                        Pair("AuthorizationRevocationData", Schema.builder()
                                .type("object")
                                .description("The Authorization Revocation payload.")
                                .properties(mapOf(
                                        Pair("username", Schema.builder()
                                                .type("string")
                                                .description("The username for the user.")
                                                .build()
                                        ),
                                        Pair("userId", Schema.builder()
                                                .type("string")
                                                .description("The immutable public userId for the user")
                                                .build()
                                        ),
                                        Pair("eiasToken", Schema.builder()
                                                .type("string")
                                                .description("The legacy eiasToken specific to the user")
                                                .build()
                                        ),
                                        Pair("revokeReason", Schema.builder()
                                                .type("string")
                                                .enumValue(listOf(
                                                        "REVOKED_BY_APP",
                                                        "REVOKED_BY_USER",
                                                        "REVOKED_BY_ADMIN",
                                                        "PASSWORD_CHANGE"
                                                ))
                                                .description("The reason for authorization revocation")
                                                .build()
                                        ),
                                        Pair("revocationDate", Schema.builder()
                                                .type("string")
                                                .description("Date and time when the authorization was revoked")
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                ))
                .securitySchemes(mapOf(
                        Pair("petstore_auth", OAuth2SecurityScheme(
                                "The oauth security descriptions",
                                OAuthFlows(
                                        null,
                                        null,
                                        ClientCredentialsOAuthFlow(
                                                "",
                                                mapOf(Pair("subscribe:auth_revocations", "Scope required for authorization revocation topic")),
                                                "https://example.com/api/oauth/dialog"
                                        ),
                                        null
                                ),
                        ))
                ))
                .build()
    }

}