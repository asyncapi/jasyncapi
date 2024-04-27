package com.asyncapi.bindings.jms;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.jms.v0._0_1.channel.JMSChannelBinding;
import com.asyncapi.bindings.jms.v0._0_1.channel.JMSChannelDestinationType;
import com.asyncapi.bindings.jms.v0._0_1.message.JMSMessageBinding;
import com.asyncapi.bindings.jms.v0._0_1.operation.JMSOperationBinding;
import com.asyncapi.bindings.jms.v0._0_1.server.JMSServerBinding;
import com.asyncapi.bindings.jms.v0._0_1.server.JMSServerProperty;
import com.asyncapi.v3.schema.AsyncAPISchema;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@DisplayName("0.0.1")
public class JMSV0_1_0Test {

    public static JMSChannelBinding channelBinding () {
        return JMSChannelBinding.builder()
                .destination("user-signed-up")
                .destinationType(JMSChannelDestinationType.FIFO_QUEUE)
                .build();
    }

    public static JMSMessageBinding messageBinding () {
        var properties = new LinkedHashMap<String, Object>();
        properties.put("JMSMessageID", AsyncAPISchema.builder()
                .type(List.of("string", "null"))
                .description("A unique message identifier. This may be set by your JMS Provider on your behalf.")
                .build()
        );
        properties.put("JMSTimestamp", AsyncAPISchema.builder()
                .type("integer")
                .description("The time the message was sent. This may be set by your JMS Provider on your behalf. The time the message was sent. The value of the timestamp is the amount of time, measured in milliseconds, that has elapsed since midnight, January 1, 1970, UTC.")
                .build()
        );
        properties.put("JMSDeliveryMode", AsyncAPISchema.builder()
                .type("string")
                .enumValue(List.of("PERSISTENT", "NON_PERSISTENT"))
                .defaultValue("PERSISTENT")
                .description("Denotes the delivery mode for the message. This may be set by your JMS Provider on your behalf.")
                .build()
        );
        properties.put("JMSPriority", AsyncAPISchema.builder()
                .type("integer")
                .defaultValue(4)
                .description("The priority of the message. This may be set by your JMS Provider on your behalf.")
                .build()
        );
        properties.put("JMSExpires", AsyncAPISchema.builder()
                .type("integer")
                .description("The time at which the message expires. This may be set by your JMS Provider on your behalf. A value of zero means that the message does not expire. Any non-zero value is the amount of time, measured in milliseconds, that has elapsed since midnight, January 1, 1970, UTC, at which the message will expire.")
                .build()
        );
        properties.put("JMSType", AsyncAPISchema.builder()
                .type(List.of("string", "null"))
                .description("The type of message. Some JMS providers use a message repository that contains the definitions of messages sent by applications. The 'JMSType' header field may reference a message's definition in the provider's repository. The JMS API does not define a standard message definition repository, nor does it define a naming policy for the definitions it contains. Some messaging systems require that a message type definition for each application message be created and that each message specify its type. In order to work with such JMS providers, JMS clients should assign a value to 'JMSType', whether the application makes use of it or not. This ensures that the field is properly set for those providers that require it.")
                .build()
        );
        properties.put("JMSCorrelationID", AsyncAPISchema.builder()
                .type(List.of("string", "null"))
                .description("The correlation identifier of the message. A client can use the 'JMSCorrelationID' header field to link one message with another. A typical use is to link a response message with its request message. Since each message sent by a JMS provider is assigned a message ID value, it is convenient to link messages via message ID, such message ID values must start with the 'ID:' prefix. Conversely, application-specified values must not start with the 'ID:' prefix; this is reserved for provider-generated message ID values.")
                .build()
        );
        properties.put("JMSReplyTo", AsyncAPISchema.builder()
                .type("string")
                .description("The queue or topic that the message sender expects replies to.")
                .build()
        );

        return JMSMessageBinding.builder()
                .headers(AsyncAPISchema.builder()
                        .type("object")
                        .required(List.of("JMSMessageID"))
                        .properties(properties)
                        .build()
                )
                .build();
    }

    public static JMSOperationBinding operationBinding () {
        return new JMSOperationBinding();
    }

    public static JMSServerBinding serverBinding () {
        return JMSServerBinding.builder()
                .jmsConnectionFactory("org.apache.activemq.ActiveMQConnectionFactory")
                .clientID("my-application-1")
                .properties(List.of(new JMSServerProperty("disableTimeStampsByDefault", false)))
                .build();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<JMSChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = JMSChannelBinding.class;
        super.pathToBindingJson                = "/bindings/jms/0.0.1/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/jms/0.0.1/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/jms/0.0.1/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<JMSMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = JMSMessageBinding.class;
        super.pathToBindingJson                = "/bindings/jms/0.0.1/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/jms/0.0.1/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/jms/0.0.1/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<JMSOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = JMSOperationBinding.class;
        super.pathToBindingJson                = "/bindings/jms/0.0.1/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/jms/0.0.1/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/jms/0.0.1/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<JMSServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = JMSServerBinding.class;
        super.pathToBindingJson                = "/bindings/jms/0.0.1/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/jms/0.0.1/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/jms/0.0.1/server/binding - wrongly extended.json";
    }}

}
