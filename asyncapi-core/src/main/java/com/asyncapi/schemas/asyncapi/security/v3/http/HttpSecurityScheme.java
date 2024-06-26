package com.asyncapi.schemas.asyncapi.security.v3.http;

import com.asyncapi.schemas.asyncapi.security.v3.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * HTTP Security Scheme
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#securitySchemeObject">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HttpSecurityScheme extends SecurityScheme {

    /**
     * <b>REQUIRED</b>.
     * <p>
     * The name of the HTTP Authorization scheme to be used in the <a href="https://tools.ietf.org/html/rfc7235#section-5.1">Authorization header as defined in RFC7235</a>.
     */
    @NotNull
    private String scheme = "";

    /**
     * A hint to the client to identify how the bearer token is formatted. Bearer tokens are usually generated
     * by an authorization server, so this information is primarily for documentation purposes.
     */
    @Nullable
    private String bearerFormat;

    @Builder(builderMethodName = "httpBuilder")
    public HttpSecurityScheme(@Nullable String description,
                              @NotNull String scheme,
                              @Nullable String bearerFormat) {
        super(Type.HTTP, description);
        this.scheme = scheme;
        this.bearerFormat = bearerFormat;
    }

}
