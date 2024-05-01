package com.asyncapi.v3._0_0.model.channel.message;

import com.asyncapi.schemas.ExtendableObject;
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
    public Map<String, Object> headers;

    /**
     * The value of this field MUST validate against the Message {@link Message} payload field.
     */
    @Nullable
    public Map<String, Object> payload;

    /**
     * A machine-friendly name.
     */
    @Nullable
    private String name;

    /**
     * A short summary of what the example is about.
     */
    @Nullable
    private String summary;

}
