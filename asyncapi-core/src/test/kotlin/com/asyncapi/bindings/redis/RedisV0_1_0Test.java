package com.asyncapi.bindings.redis;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.redis.v0._1_0.channel.RedisChannelBinding;
import com.asyncapi.bindings.redis.v0._1_0.message.RedisMessageBinding;
import com.asyncapi.bindings.redis.v0._1_0.operation.RedisOperationBinding;
import com.asyncapi.bindings.redis.v0._1_0.server.RedisServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("0.1.0")
public class RedisV0_1_0Test {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<RedisChannelBinding> {{
        super.binding                          = new RedisChannelBinding();
        super.bindingTypeClass                 = RedisChannelBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<RedisMessageBinding> {{
        super.binding                          = new RedisMessageBinding();
        super.bindingTypeClass                 = RedisMessageBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<RedisOperationBinding> {{
        super.binding                          = new RedisOperationBinding();
        super.bindingTypeClass                 = RedisOperationBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<RedisServerBinding> {{
        super.binding                          = new RedisServerBinding();
        super.bindingTypeClass                 = RedisServerBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/unknown version/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/unknown version/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/unknown version/server/binding - wrongly extended.json";
    }}

}
