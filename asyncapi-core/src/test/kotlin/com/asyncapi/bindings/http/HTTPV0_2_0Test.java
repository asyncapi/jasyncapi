package com.asyncapi.bindings.http;

import com.asyncapi.bindings.BindingTest;
import com.asyncapi.bindings.http.v0._2_0.channel.HTTPChannelBinding;
import com.asyncapi.bindings.http.v0._2_0.message.HTTPMessageBinding;
import com.asyncapi.bindings.http.v0._2_0.operation.HTTPOperationBinding;
import com.asyncapi.bindings.http.v0._2_0.operation.HTTPOperationMethod;
import com.asyncapi.bindings.http.v0._2_0.server.HTTPServerBinding;
import com.asyncapi.v3.schema.AsyncAPISchema;
import com.asyncapi.schemas.Type;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@DisplayName("0.2.0")
public class HTTPV0_2_0Test {

    public static HTTPChannelBinding channelBinding () {
        return new HTTPChannelBinding();
    }

    public static HTTPMessageBinding messageBinding () {
        return HTTPMessageBinding.builder()
                .headers(AsyncAPISchema.builder()
                        .type(Type.OBJECT)
                        .properties(Map.ofEntries(
                                Map.entry("Content-Type", AsyncAPISchema.builder()
                                        .type(Type.STRING)
                                        .enumValue(List.of("application/json"))
                                        .build())
                        ))
                        .build()
                )
                .build();
    }

    public static HTTPOperationBinding operationBinding () {
        return HTTPOperationBinding.builder()
                .method(HTTPOperationMethod.GET)
                .query(AsyncAPISchema.builder()
                        .type(Type.OBJECT)
                        .required(List.of("companyId"))
                        .properties(Map.ofEntries(
                                Map.entry("companyId", AsyncAPISchema.builder()
                                        .type(Type.NUMBER)
                                        .minimum(BigDecimal.ONE)
                                        .description("The Id of the company.")
                                        .build())
                        ))
                        .additionalProperties(false)
                        .build()
                )
                .build();
    }

    public static HTTPServerBinding serverBinding () {
        return new HTTPServerBinding();
    }

    @Nested
    @DisplayName("channel")
    class ChannelTest extends BindingTest<HTTPChannelBinding> {{
        super.binding                          = channelBinding();
        super.bindingTypeClass                 = HTTPChannelBinding.class;
        super.pathToBindingJson                = "/bindings/http/0.2.0/channel/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/http/0.2.0/channel/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/http/0.2.0/channel/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("message")
    class Message extends BindingTest<HTTPMessageBinding> {{
        super.binding                          = messageBinding();
        super.bindingTypeClass                 = HTTPMessageBinding.class;
        super.pathToBindingJson                = "/bindings/http/0.2.0/message/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/http/0.2.0/message/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/http/0.2.0/message/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("operation")
    class Operation extends BindingTest<HTTPOperationBinding> {{
        super.binding                          = operationBinding();
        super.bindingTypeClass                 = HTTPOperationBinding.class;
        super.pathToBindingJson                = "/bindings/http/0.2.0/operation/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/http/0.2.0/operation/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/http/0.2.0/operation/binding - wrongly extended.json";
    }}

    @Nested
    @DisplayName("server")
    class Server extends BindingTest<HTTPServerBinding> {{
        super.binding                          = serverBinding();
        super.bindingTypeClass                 = HTTPServerBinding.class;
        super.pathToBindingJson                = "/bindings/http/0.2.0/server/binding.json";
        super.pathToExtendedBindingJson        = "/bindings/http/0.2.0/server/binding - extended.json";
        super.pathToWronglyExtendedBindingJson = "/bindings/http/0.2.0/server/binding - wrongly extended.json";
    }}

}
