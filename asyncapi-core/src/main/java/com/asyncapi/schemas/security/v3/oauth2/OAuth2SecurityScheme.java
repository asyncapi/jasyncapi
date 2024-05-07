package com.asyncapi.schemas.security.v3.oauth2;

import com.asyncapi.schemas.security.v3.SecurityScheme;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * OAuth2 Security Scheme
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#securitySchemeObject">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OAuth2SecurityScheme extends SecurityScheme {

    /**
     * <b>REQUIRED</b>.
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
