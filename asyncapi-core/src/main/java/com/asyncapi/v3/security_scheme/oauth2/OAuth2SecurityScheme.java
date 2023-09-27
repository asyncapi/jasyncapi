package com.asyncapi.v3.security_scheme.oauth2;

import com.asyncapi.v3.security_scheme.SecurityScheme;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @version 3.0.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#securitySchemeObject">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OAuth2SecurityScheme extends SecurityScheme {

    /**
     * REQUIRED.
     * <p>
     * An object containing configuration information for the flow types supported.
     */
    @NotNull
    private OAuthFlows flows = new OAuthFlows();

    /**
     * List of the needed scope names.
     */
    @Nullable
    private List<String> scopes;

    @Builder(builderMethodName = "oauth2Builder")
    public OAuth2SecurityScheme(@Nullable String description,
                                @NotNull OAuthFlows flows,
                                @Nullable List<String> scopes) {
        super(Type.OAUTH2, description);
        this.flows = flows;
        this.scopes = scopes;
    }

}
