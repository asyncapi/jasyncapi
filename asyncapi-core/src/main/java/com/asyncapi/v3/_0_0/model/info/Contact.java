package com.asyncapi.v3._0_0.model.info;

import com.asyncapi.v3.ExtendableObject;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Contact information for the exposed API.
 *
 * @version 3.0.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0-next-major-spec.14#contactObject">Contact</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Contact extends ExtendableObject {

    /**
     * The identifying name of the contact person/organization.
     */
    @Nullable
    private String name;

    /**
     * The URL pointing to the contact information. MUST be in the format of a URL.
     */
    @Nullable
    private String url;

    /**
     * The email address of the contact person/organization. MUST be in the format of an email address.
     */
    @Nullable
    private String email;

}
