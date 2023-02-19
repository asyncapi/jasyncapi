package com.asyncapi.v2._6_0.model.channel.message;

import com.asyncapi.v2._6_0.jackson.model.channel.message.MessagesDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * Describes which message is acceptable.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OneOfMessages {

    /**
     * Given message MUST be one of provided messages.
     *
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.message.Message}</li>
     * </ul>
     */
    @Nonnull
    @JsonDeserialize(using = MessagesDeserializer.class)
    private List<Object> oneOf;

}
