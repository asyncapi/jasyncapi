package com.asyncapi.bindings.googlepubsub;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.googlepubsub.v0._1_0.channel.GooglePubSubChannelBinding;
import com.asyncapi.bindings.googlepubsub.v0._1_0.channel.GooglePubSubChannelMessageStoragePolicy;
import com.asyncapi.bindings.googlepubsub.v0._1_0.channel.GooglePubSubChannelSchemaSettings;
import com.asyncapi.bindings.googlepubsub.v0._1_0.message.GooglePubSubMessageBinding;
import com.asyncapi.bindings.googlepubsub.v0._1_0.message.GooglePubSubMessageSchemaDefinition;
import com.asyncapi.bindings.googlepubsub.v0._1_0.message.GooglePubSubMessageSchemaDefinitionType;
import com.asyncapi.bindings.googlepubsub.v0._1_0.operation.GooglePubSubOperationBinding;
import com.asyncapi.bindings.googlepubsub.v0._1_0.server.GooglePubSubServerBinding;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.List;

@DisplayName("0.1.0")
public class GooglePubSubV0_1_0Test {

    public static GooglePubSubChannelBinding channelBinding () {
        return GooglePubSubChannelBinding.builder()
                .topic("projects/your-project/topics/topic-proto-schema")
                .messageRetentionDuration("86400s")
                .messageStoragePolicy(new GooglePubSubChannelMessageStoragePolicy(
                        List.of(
                                "us-central1",
                                "us-central2",
                                "us-east1",
                                "us-east4",
                                "us-east5",
                                "us-east7",
                                "us-south1",
                                "us-west1",
                                "us-west2",
                                "us-west3",
                                "us-west4"
                        )
                ))
                .schemaSettings(GooglePubSubChannelSchemaSettings.builder()
                        .encoding("binary")
                        .name("projects/your-project/schemas/message-proto")
                        .build()
                )
                .build();
    }

    public static GooglePubSubMessageBinding messageBinding () {
        return GooglePubSubMessageBinding.builder()
                .schema(new GooglePubSubMessageSchemaDefinition(
                        "projects/your-project/schemas/message-avro",
                        GooglePubSubMessageSchemaDefinitionType.AVRO
                ))
                .build();
    }

    public static GooglePubSubOperationBinding operationBinding () {
        return new GooglePubSubOperationBinding();
    }

    public static GooglePubSubServerBinding serverBinding () {
        return new GooglePubSubServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<GooglePubSubChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = GooglePubSubChannelBinding.class;
        super.pathToBindingJson                = "/bindings/googlepubsub/0.1.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/googlepubsub/0.1.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/googlepubsub/0.1.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<GooglePubSubMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = GooglePubSubMessageBinding.class;
        super.pathToBindingJson                = "/bindings/googlepubsub/0.1.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/googlepubsub/0.1.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/googlepubsub/0.1.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<GooglePubSubOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = GooglePubSubOperationBinding.class;
        super.pathToBindingJson                = "/bindings/googlepubsub/0.1.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/googlepubsub/0.1.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/googlepubsub/0.1.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<GooglePubSubServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = GooglePubSubServerBinding.class;
        super.pathToBindingJson                = "/bindings/googlepubsub/0.1.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/googlepubsub/0.1.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/googlepubsub/0.1.0/server/binding - wrongly extended.json";
    }}

}
