package com.asyncapi.schemas.security.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * OpenID Connect Security Scheme
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#securitySchemeObject">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OpenIdConnectSecurityScheme extends SecurityScheme {

    /**
     * REQUIRED.
     * <p>
     * OpenId Connect URL to discover OAuth2 configuration values. This MUST be in the form of a URL.
     */
    @NotNull
    private String openIdConnectUrl = "";

    @Builder(builderMethodName = "openIdBuilder")
    public OpenIdConnectSecurityScheme(@Nullable String description,
                                       @NotNull String openIdConnectUrl) {
        super(Type.OPENID_CONNECT, description);
        this.openIdConnectUrl = openIdConnectUrl;
    }

}
