package com.asyncapi.v3.binding.message.http

import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.Type
import com.asyncapi.bindings.http.v0._1_0.message.HTTPMessageBinding

class HTTPMessageBindingTest: SerDeTest<HTTPMessageBinding>() {

    override fun objectClass() = HTTPMessageBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/message/http/httpMessageBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/message/http/httpMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/message/http/httpMessageBinding - wrongly extended.json"

    override fun build(): HTTPMessageBinding {
        return HTTPMessageBinding.builder()
                .headers(AsyncAPISchema.builder()
                        .type(Type.OBJECT)
                        .properties(mapOf(
                                Pair(
                                        "Content-Type",
                                        AsyncAPISchema.builder()
                                                .type(Type.STRING)
                                                .enumValue(listOf("application/json"))
                                                .build()
                                )
                        ))
                        .build())
                .build()
    }

}