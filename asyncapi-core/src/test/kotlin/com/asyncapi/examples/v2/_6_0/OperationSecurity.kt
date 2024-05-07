package com.asyncapi.examples.v2._6_0

import com.asyncapi.schemas.Reference
import com.asyncapi.v2._6_0.model.channel.ChannelItem
import com.asyncapi.v2._6_0.model.channel.message.Message
import com.asyncapi.v2._6_0.model.channel.operation.Operation
import com.asyncapi.v2._6_0.model.component.Components
import com.asyncapi.v2._6_0.model.info.Info
import com.asyncapi.bindings.http.v0._3_0.operation.HTTPOperationBinding
import com.asyncapi.bindings.http.v0._3_0.operation.HTTPOperationMethod
import com.asyncapi.schemas.AsyncAPISchema
import com.asyncapi.schemas.security.v2.oauth2.OAuthFlows
import com.asyncapi.schemas.security.v2.oauth2.OAuth2SecurityScheme
import com.asyncapi.schemas.security.v2.oauth2.flow.ClientCredentialsOAuthFlow

class OperationSecurity: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v2.6.0/operation-security.yml"

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
                                                .method(HTTPOperationMethod.POST)
                                                .build())
                                ))
                                .security(listOf(
                                        mapOf(
                                                Pair("petstore_auth", listOf("subscribe:auth_revocations"))
                                        )
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
                                .headers(AsyncAPISchema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("X-SIGNATURE", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("ECC message signature")
                                                        .build()
                                                )
                                        ))
                                        .build()
                                )
                                .payload(AsyncAPISchema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("metadata", AsyncAPISchema.builder()
                                                        .ref("#/components/schemas/MetaData")
                                                        .build()
                                                ),
                                                Pair("notification", AsyncAPISchema.builder()
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
                        Pair("MetaData", AsyncAPISchema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("topic", AsyncAPISchema.builder()
                                                .type("string")
                                                .description("Topic subscribed to.")
                                                .build()
                                        ),
                                        Pair("schemaVersion", AsyncAPISchema.builder()
                                                .type("string")
                                                .description("The schema for this topic.")
                                                .build()
                                        ),
                                        Pair("deprecated", AsyncAPISchema.builder()
                                                .type("boolean")
                                                .description("If this is a deprecated schema or topic.")
                                                .defaultValue("false")
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                        Pair("Notification", AsyncAPISchema.builder()
                                .type("object")
                                .properties(mapOf(
                                        Pair("notificationId", AsyncAPISchema.builder()
                                                .type("string")
                                                .description("The notification Id.")
                                                .build()
                                        ),
                                        Pair("eventDate", AsyncAPISchema.builder()
                                                .type("string")
                                                .description("The event date associated with this notification in UTC.")
                                                .build()
                                        ),
                                        Pair("publishDate", AsyncAPISchema.builder()
                                                .type("string")
                                                .description("The message publish date in UTC.")
                                                .build()
                                        ),
                                        Pair("publishAttemptCount", AsyncAPISchema.builder()
                                                .type("integer")
                                                .description("The number of attempts made to publish this message.")
                                                .build()
                                        ),
                                        Pair("publishAttemptCount", AsyncAPISchema.builder()
                                                .type("integer")
                                                .description("The number of attempts made to publish this message.")
                                                .build()
                                        ),
                                        Pair("data", AsyncAPISchema.builder()
                                                .ref("#/components/schemas/AuthorizationRevocationData")
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                        Pair("AuthorizationRevocationData", AsyncAPISchema.builder()
                                .type("object")
                                .description("The Authorization Revocation payload.")
                                .properties(mapOf(
                                        Pair("username", AsyncAPISchema.builder()
                                                .type("string")
                                                .description("The username for the user.")
                                                .build()
                                        ),
                                        Pair("userId", AsyncAPISchema.builder()
                                                .type("string")
                                                .description("The immutable public userId for the user")
                                                .build()
                                        ),
                                        Pair("eiasToken", AsyncAPISchema.builder()
                                                .type("string")
                                                .description("The legacy eiasToken specific to the user")
                                                .build()
                                        ),
                                        Pair("revokeReason", AsyncAPISchema.builder()
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
                                        Pair("revocationDate", AsyncAPISchema.builder()
                                                .type("string")
                                                .description("Date and time when the authorization was revoked")
                                                .build()
                                        )
                                ))
                                .build()
                        ),
                ))
                .securitySchemes(mapOf(
                        Pair("petstore_auth",
                            OAuth2SecurityScheme(
                                "The oauth security descriptions",
                                OAuthFlows(
                                    null,
                                    null,
                                    ClientCredentialsOAuthFlow(
                                        "",
                                        mapOf(
                                            Pair(
                                                "subscribe:auth_revocations",
                                                "Scope required for authorization revocation topic"
                                            )
                                        ),
                                        "https://example.com/api/oauth/dialog"
                                    ),
                                    null
                                ),
                            )
                        )
                ))
                .build()
    }

}