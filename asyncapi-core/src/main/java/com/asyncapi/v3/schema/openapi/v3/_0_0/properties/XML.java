package com.asyncapi.v3.schema.openapi.v3._0_0.properties;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * XML
 *
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.0.3.md#xml-object">XML Object</a>
 * @see <a href="https://github.com/swagger-api/swagger-core/blob/v2.1.13/modules/swagger-models/src/main/java/io/swagger/v3/oas/models/media/XML.java">XML</a>
 *
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class XML extends Extensions {

    /**
     * Replaces the name of the element/attribute used for the described schema property.
     * <p>
     * When defined within items, it will affect the name of the individual XML elements within the list.
     * <p>
     * When defined alongside type being array (outside the items), it will affect the wrapping element and only if wrapped is true.
     * If wrapped is false, it will be ignored.
     *
     * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.0.3.md#fixed-fields-22">XML Fixed Fields: name</a>
     */
    @Nullable
    @JsonProperty("name")
    @JsonPropertyDescription("Replaces the name of the element/attribute used for the described schema property.")
    public String name;

    /**
     * The URI of the namespace definition.
     * <p>
     * Value <b>MUST</b> be in the form of an absolute URI.
     *
     * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.0.3.md#fixed-fields-22">XML Fixed Fields: namespace</a>
     */
    public String namespace;

    /**
     * The prefix to be used for the {@link #name}.
     *
     * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.0.3.md#fixed-fields-22">XML Fixed Fields: prefix</a>
     */
    public String prefix;

    /**
     * Declares whether the property definition translates to an attribute instead of an element.
     * <p>
     * Default value is false.
     *
     * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.0.3.md#fixed-fields-22">XML Fixed Fields: attribute</a>
     */
    public Boolean attribute;

    /**
     * <b>MAY</b> be used only for an array definition.
     * <p>
     * Signifies whether the array is wrapped:
     * <pre>{@code
     * <books>
     *     <book/><book/>
     * </books>
     * }</pre>
     *
     * or unwrapped:
     * <pre>{@code
     * <book/><book/>
     * }</pre>
     *
     * <p>
     * Default value is false.
     * <p>
     * The definition takes effect only when defined alongside type being array (outside the items).
     *
     * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/main/versions/3.0.3.md#fixed-fields-22">XML Fixed Fields: wrapped</a>
     */
    public Boolean wrapped;

}
