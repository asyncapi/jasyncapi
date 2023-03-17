package com.asyncapi.v2.security_scheme.http;

import com.asyncapi.v2.security_scheme.SecurityScheme;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#securitySchemeObject">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class HttpApiKeySecurityScheme extends SecurityScheme {

    /**
     * REQUIRED.
     * <p>
     * The name of the header, query or cookie parameter to be used.
     */
    @NotNull
    private String name = "";

    /**
     * REQUIRED.
     * <p>
     * The location of the API key.
     */
    @Nullable
    private ApiKeyLocation in;

    @Builder(builderMethodName = "httpApiKeySecuritySchemeBuilder")
    public HttpApiKeySecurityScheme(@NotNull Type type,
                                    @Nullable String description,
                                    @NotNull String name,
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
