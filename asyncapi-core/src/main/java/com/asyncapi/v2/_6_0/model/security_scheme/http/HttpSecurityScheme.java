package com.asyncapi.v2._6_0.model.security_scheme.http;

import com.asyncapi.v2._6_0.model.security_scheme.SecurityScheme;
import lombok.*;

import javax.annotation.CheckForNull;
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
@EqualsAndHashCode(callSuper = false)
public class HttpSecurityScheme extends SecurityScheme {

    /**
     * REQUIRED.
     * <p>
     * The name of the HTTP Authorization scheme to be used in the <a href="https://tools.ietf.org/html/rfc7235#section-5.1">Authorization header as defined in RFC7235</a>.
     */
    @Nonnull
    private String scheme;

    /**
     * A hint to the client to identify how the bearer token is formatted. Bearer tokens are usually generated
     * by an authorization server, so this information is primarily for documentation purposes.
     */
    @CheckForNull
    private String bearerFormat;

    @Builder(builderMethodName = "httpSecuritySchemeBuilder")
    public HttpSecurityScheme(@Nonnull Type type,
                              @Nullable String description,
                              @Nonnull String scheme,
                              @Nullable String bearerFormat) {
        super(type, description);
        this.scheme = scheme;
        this.bearerFormat = bearerFormat;
    }

}
