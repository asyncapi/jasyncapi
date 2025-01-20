package com.asyncapi.bindings.googlepubsub;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.googlepubsub.v0._2_0.channel.GooglePubSubChannelBinding;
import com.asyncapi.bindings.googlepubsub.v0._2_0.message.GooglePubSubMessageBinding;
import com.asyncapi.bindings.googlepubsub.v0._2_0.operation.GooglePubSubOperationBinding;
import com.asyncapi.bindings.googlepubsub.v0._2_0.server.GooglePubSubServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("latest")
public class GooglePubSubLatestTest {

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<GooglePubSubChannelBinding> {{
        super.binding                          = GooglePubSubV0_2_0Test.channelBinding();
        super.bindingTypeClass                 = GooglePubSubChannelBinding.class;
        super.pathToBindingJson                = "/bindings/googlepubsub/latest/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/googlepubsub/latest/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/googlepubsub/latest/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<GooglePubSubMessageBinding> {{
        super.binding                          = GooglePubSubV0_2_0Test.messageBinding();
        super.bindingTypeClass                 = GooglePubSubMessageBinding.class;
        super.pathToBindingJson                = "/bindings/googlepubsub/latest/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/googlepubsub/latest/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/googlepubsub/latest/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<GooglePubSubOperationBinding> {{
        super.binding                          = GooglePubSubV0_2_0Test.operationBinding();
        super.bindingTypeClass                 = GooglePubSubOperationBinding.class;
        super.pathToBindingJson                = "/bindings/googlepubsub/latest/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/googlepubsub/latest/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/googlepubsub/latest/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<GooglePubSubServerBinding> {{
        super.binding                          = GooglePubSubV0_2_0Test.serverBinding();
        super.bindingTypeClass                 = GooglePubSubServerBinding.class;
        super.pathToBindingJson                = "/bindings/googlepubsub/latest/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/googlepubsub/latest/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/googlepubsub/latest/server/binding - wrongly extended.json";
    }}

}
