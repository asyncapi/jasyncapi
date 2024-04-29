package com.asyncapi.bindings.sqs;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.sqs.v0._1_0.channel.SQSChannelBinding;
import com.asyncapi.bindings.sqs.v0._1_0.message.SQSMessageBinding;
import com.asyncapi.bindings.sqs.v0._1_0.operation.SQSOperationBinding;
import com.asyncapi.bindings.sqs.v0._1_0.server.SQSServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("latest")
public class SQSLatestTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<SQSChannelBinding> {{
        super.binding                          = SQSV0_1_0Test.channelBinding();
        super.bindingTypeClass                 = SQSChannelBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/latest/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/latest/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/latest/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<SQSMessageBinding> {{
        super.binding                          = SQSV0_1_0Test.messageBinding();
        super.bindingTypeClass                 = SQSMessageBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/latest/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/latest/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/latest/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<SQSOperationBinding> {{
        super.binding                          = SQSV0_1_0Test.operationBinding();
        super.bindingTypeClass                 = SQSOperationBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/latest/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/latest/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/latest/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<SQSServerBinding> {{
        super.binding                          = SQSV0_1_0Test.serverBinding();
        super.bindingTypeClass                 = SQSServerBinding.class;
        super.pathToBindingJson                = "/bindings/default implementation/latest/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/default implementation/latest/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/default implementation/latest/server/binding - wrongly extended.json";
    }}

}
