package com.asyncapi.schemas.security.v3;

import com.asyncapi.schemas.ExtendableObject;
import com.asyncapi.schemas.security.v3.http.HttpApiKeySecurityScheme;
import com.asyncapi.schemas.security.v3.http.HttpSecurityScheme;
import com.asyncapi.schemas.security.v3.oauth2.OAuth2SecurityScheme;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Defines a security scheme that can be used by the operations. Supported schemes are:
 * <ul>
 *     <li>User/Password.</li>
 *     <li>API key (either as user or as password).</li>
 *     <li>X.509 certificate.</li>
 *     <li>End-to-end encryption (either symmetric or asymmetric).</li>
 *     <li>HTTP authentication.</li>
 *     <li>HTTP API key.</li>
 *     <li>OAuth2’s common flows (Implicit, Resource Owner Protected Credentials, Client Credentials and Authorization Code) as defined in <a href="https://tools.ietf.org/html/rfc6749">RFC6749</a>.</li>
 *     <li><a href="https://tools.ietf.org/html/draft-ietf-oauth-discovery-06">OpenID Connect Discovery.</a></li>
 *     <li>SASL (Simple Authentication and Security Layer) as defined in <a href="https://tools.ietf.org/html/rfc4422">RFC4422</a>.</li>
 * </ul>
 *
 * This object MAY be extended with {@link ExtendableObject}.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#specificationExtensions">Specification Extensions</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#securitySchemeObject">Security Scheme</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.EXISTING_PROPERTY,
        property = "type",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SecurityScheme.class, name = "userPassword"),
        @JsonSubTypes.Type(value = ApiKeySecurityScheme.class, name = "apiKey"),
        @JsonSubTypes.Type(value = SecurityScheme.class, name = "X509"),
        @JsonSubTypes.Type(value = SecurityScheme.class, name = "symmetricEncryption"),
        @JsonSubTypes.Type(value = SecurityScheme.class, name = "asymmetricEncryption"),
        @JsonSubTypes.Type(value = HttpApiKeySecurityScheme.class, name = "httpApiKey"),
        @JsonSubTypes.Type(value = HttpSecurityScheme.class, name = "http"),
        @JsonSubTypes.Type(value = OAuth2SecurityScheme.class, name = "oauth2"),
        @JsonSubTypes.Type(value = OpenIdConnectSecurityScheme.class, name = "openIdConnect"),
        @JsonSubTypes.Type(value = SecurityScheme.class, name = "plain"),
        @JsonSubTypes.Type(value = SecurityScheme.class, name = "scramSha256"),
        @JsonSubTypes.Type(value = SecurityScheme.class, name = "scramSha512"),
        @JsonSubTypes.Type(value = SecurityScheme.class, name = "gssapi"),
})
@EqualsAndHashCode(callSuper = true)
public class SecurityScheme extends ExtendableObject {

    /**
     * <b>REQUIRED</b>.
     * <p>
     * The type of the security scheme. Valid values are:
     * <ul>
     *     <li>userPassword</li>
     *     <li>apiKey</li>
     *     <li>X509</li>
     *     <li>symmetricEncryption</li>
     *     <li>asymmetricEncryption</li>
     *     <li>httpApiKey</li>
     *     <li>http</li>
     *     <li>oauth2</li>
     *     <li>openIdConnect</li>
     * </ul>
     */
    @NotNull
    @Builder.Default
    private Type type = Type.USER_PASSWORD;

    /**
     * A short description for security scheme. <a href="http://spec.commonmark.org/">CommonMark syntax</a> MAY be used for rich text representation.
     */
    @Nullable
    private String description;

    public enum Type {

        @JsonProperty("userPassword")
        USER_PASSWORD,
        @JsonProperty("apiKey")
        API_KEY,
        @JsonProperty("X509")
        X509,
        @JsonProperty("symmetricEncryption")
        SYMMETRIC_ENCRYPTION,
        @JsonProperty("asymmetricEncryption")
        ASYMMETRIC_ENCRYPTION,
        @JsonProperty("httpApiKey")
        HTTP_API_KEY,
        @JsonProperty("http")
        HTTP,
        @JsonProperty("oauth2")
        OAUTH2,
        @JsonProperty("openIdConnect")
        OPENID_CONNECT,
        @JsonProperty("plain")
        PLAIN,
        @JsonProperty("scramSha256")
        SCRAM_SHA256,
        @JsonProperty("scramSha512")
        SCRAM_SHA512,
        @JsonProperty("gssapi")
        GSSAPI

    }

}
