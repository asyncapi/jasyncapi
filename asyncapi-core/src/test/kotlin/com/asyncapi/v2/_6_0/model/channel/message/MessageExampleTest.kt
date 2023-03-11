package com.asyncapi.v2._6_0.model.channel.message

import com.asyncapi.v2.SerDeTest

class MessageExampleTest: SerDeTest<MessageExample>() {

    override fun objectClass() = MessageExample::class.java

    override fun baseObjectJson() = "/json/2.6.0/model/channel/message/messageExample.json"

    override fun extendedObjectJson() = "/json/2.6.0/model/channel/message/messageExample - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/model/channel/message/messageExample - wrongly extended.json"

    override fun build(): MessageExample {
        return MessageExample.builder()
                .name("SimpleSignup")
                .summary("A simple UserSignup example message")
                .headers(mapOf(
                        Pair("correlationId", "my-correlation-id"),
                        Pair("applicationInstanceId", "myInstanceId")
                ))
                .payload(mapOf(
                        Pair("user", mapOf(
                                Pair("someUserKey", "someUserValue")
                        )),
                        Pair("signup", mapOf(
                                Pair("someSignupKey", "someSignupValue")
                        ))
                ))
                .build()
    }

}