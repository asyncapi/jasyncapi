package com.asyncapi.v3.security_scheme.http;

import com.asyncapi.v3.security_scheme.SecurityScheme;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * HTTP API Key Security Scheme
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#securitySchemeObject">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class HttpApiKeySecurityScheme extends SecurityScheme {

    /**
     * <b>REQUIRED</b>.
     * <p>
     * The name of the header, query or cookie parameter to be used.
     */
    @NotNull
    private String name = "";

    /**
     * <b>REQUIRED</b>.
     * <p>
     * The location of the API key.
     */
    @Nullable
    private ApiKeyLocation in;

    @Builder(builderMethodName = "httpApiKeyBuilder")
    public HttpApiKeySecurityScheme(@Nullable String description,
                                    @NotNull String name,
                                    @Nullable ApiKeyLocation in) {
        super(Type.HTTP_API_KEY, description);
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
