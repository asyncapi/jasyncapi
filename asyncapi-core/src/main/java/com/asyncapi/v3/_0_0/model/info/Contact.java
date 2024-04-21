package com.asyncapi.v3._0_0.model.info;

import com.asyncapi.ExtendableObject;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Contact information for the exposed API.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#contactObject">Contact</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
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
     * The URL pointing to the contact information. This MUST be in the form of an absolute URL.
     */
    @Nullable
    private String url;

    /**
     * The email address of the contact person/organization. MUST be in the format of an email address.
     */
    @Nullable
    private String email;

}
