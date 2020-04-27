package com.asyncapi.v2.binding.redis;

import com.asyncapi.v2.binding.OperationBinding;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * This class defines how to describe Redis operation binding.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RedisOperationBinding extends OperationBinding {
}
