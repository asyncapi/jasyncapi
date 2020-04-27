package com.asyncapi.v2.binding.stomp;

import com.asyncapi.v2.binding.MessageBinding;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * This class defines how to describe STOMP message binding.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class STOMPMessageBinding extends MessageBinding {
}
