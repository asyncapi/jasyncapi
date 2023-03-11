package com.asyncapi.v2.binding.message.http

import com.asyncapi.v2.SerDeTest

class HTTPMessageBindingTest: SerDeTest<HTTPMessageBinding>() {

    override fun objectClass() = HTTPMessageBinding::class.java

    override fun baseObjectJson() = "/json/2.6.0/binding/message/http/httpMessageBinding.json"

    override fun extendedObjectJson() = "/json/2.6.0/binding/message/http/httpMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/binding/message/http/httpMessageBinding - wrongly extended.json"

    override fun build(): HTTPMessageBinding {
        return HTTPMessageBinding.builder()
                .headers(mapOf(
                        Pair("type", "object"),
                        Pair("properties", mapOf(
                                Pair("Content-Type", mapOf(
                                        Pair("type", "string"),
                                        Pair("enum", listOf("application/json"))
                                ))
                        )),
                ))
                .build()
    }

}