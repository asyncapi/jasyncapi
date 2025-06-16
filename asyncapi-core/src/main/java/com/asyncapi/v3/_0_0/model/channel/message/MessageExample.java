package com.asyncapi.v3._0_0.model.channel.message;

import com.asyncapi.lsp.TextDocumentCompletion;
import com.asyncapi.schemas.asyncapi.ExtendableObject;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Message Example Object represents an example of a {@link Message} Object and MUST contain either {@link Message} headers and/or {@link Message} fields.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#messageExampleObject">Message Example</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MessageExample extends ExtendableObject {

    /**
     * The value of this field MUST validate against the {@link Message} headers field.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "Map<String, Object>",
            documentation = "Headers for the message example\n\n" +
                    "The value of this field MUST validate against the Message headers field."
    )
    public Map<String, Object> headers;

    /**
     * The value of this field MUST validate against the Message {@link Message} payload field.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "Object",
            documentation = "Payload for the message example\n\n" +
                    "The value of this field MUST validate against the Message payload field."
    )
    public Object payload;

    /**
     * A machine-friendly name.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Name of the message example\n\n" +
                    "A machine-friendly name."
    )
    private String name;

    /**
     * A short summary of what the example is about.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Summary of the message example\n\n" +
                    "A short summary of what the example is about."
    )
    private String summary;

}
