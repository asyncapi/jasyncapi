package com.asyncapi.bindings.sqs;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.sqs.v0._1_0.channel.SQSChannelBinding;
import com.asyncapi.bindings.sqs.v0._1_0.message.SQSMessageBinding;
import com.asyncapi.bindings.sqs.v0._1_0.operation.SQSOperationBinding;
import com.asyncapi.bindings.sqs.v0._1_0.server.SQSServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("0.1.0")
public class SQSV0_1_0Test {

    public static SQSChannelBinding channelBinding () {
        return new SQSChannelBinding();
    }

    public static SQSMessageBinding messageBinding () {
        return new SQSMessageBinding();
    }

    public static SQSOperationBinding operationBinding () {
        return new SQSOperationBinding();
    }

    public static SQSServerBinding serverBinding () {
        return new SQSServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<SQSChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = SQSChannelBinding.class;
        super.pathToBindingJson                = "/bindings/sqs/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/sqs/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/sqs/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<SQSMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = SQSMessageBinding.class;
        super.pathToBindingJson                = "/bindings/sqs/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/sqs/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/sqs/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<SQSOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = SQSOperationBinding.class;
        super.pathToBindingJson                = "/bindings/sqs/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/sqs/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/sqs/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<SQSServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = SQSServerBinding.class;
        super.pathToBindingJson                = "/bindings/sqs/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/sqs/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/sqs/0.1.0/server/binding - wrongly extended.json";
    }}

}
