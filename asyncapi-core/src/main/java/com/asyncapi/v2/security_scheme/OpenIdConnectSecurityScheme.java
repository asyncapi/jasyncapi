package com.asyncapi.v2.security_scheme;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
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
    @Nonnull
    private String openIdConnectUrl;

    @Builder(builderMethodName = "openIdConnectSecurityScheme")
    public OpenIdConnectSecurityScheme(@Nonnull Type type,
                                       @Nullable String description,
                                       @Nonnull String openIdConnectUrl) {
        super(type, description);
        this.openIdConnectUrl = openIdConnectUrl;
    }

}
