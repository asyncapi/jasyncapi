package com.asyncapi.v2.binding.message.http

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.schema.Schema
import com.asyncapi.v2.schema.Type

class HTTPMessageBindingTest: SerDeTest<HTTPMessageBinding>() {

    override fun objectClass() = HTTPMessageBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/message/http/httpMessageBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/message/http/httpMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/message/http/httpMessageBinding - wrongly extended.json"

    override fun build(): HTTPMessageBinding {
        return HTTPMessageBinding.builder()
                .headers(Schema.builder()
                        .type(Type.OBJECT)
                        .properties(mapOf(
                                Pair(
                                        "Content-Type",
                                        Schema.builder()
                                                .type(Type.STRING)
                                                .enumValue(listOf("application/json"))
                                                .build()
                                )
                        ))
                        .build())
                .build()
    }

}