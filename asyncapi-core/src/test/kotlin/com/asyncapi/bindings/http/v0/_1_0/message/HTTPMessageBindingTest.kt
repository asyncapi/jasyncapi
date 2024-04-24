package com.asyncapi.bindings.http.v0._1_0.message

import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.Type

class HTTPMessageBindingTest: SerDeTest<HTTPMessageBinding>() {

    override fun objectClass() = HTTPMessageBinding::class.java

    override fun baseObjectJson() = "/bindings/http/message/httpMessageBinding.json"

    override fun extendedObjectJson() = "/bindings/http/message/httpMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/http/message/httpMessageBinding - wrongly extended.json"

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