package com.asyncapi.v2.model.security_scheme.http;

import com.asyncapi.v2.model.security_scheme.SecurityScheme;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 *  * @version 2.0.0
 *  * <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#a-name-securityschemeobject-a-security-scheme-object">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class HttpApiKeySecurityScheme extends SecurityScheme {

    /**
     * REQUIRED.
     *
     * The name of the header, query or cookie parameter to be used.
     */
    @Nonnull
    @NonNull
    private String name;

    /**
     * REQUIRED.
     *
     * The location of the API key.
     */
    @CheckForNull
    private ApiKeyLocation in;

    @Builder(builderMethodName = "httpApiKeySecuritySchemeBuilder")
    public HttpApiKeySecurityScheme(@Nonnull @NonNull Type type,
                                    @Nullable String description,
                                    @NonNull @Nonnull String name,
                                    @Nullable ApiKeyLocation in) {
        super(type, description);
        this.name = name;
        this.in = in;
    }

    public enum ApiKeyLocation {

        @JsonProperty("query")
        QUERY,
        @JsonProperty("header")
        HEADER,
        @JsonProperty("cookie")
        COOKIE

    }

}
