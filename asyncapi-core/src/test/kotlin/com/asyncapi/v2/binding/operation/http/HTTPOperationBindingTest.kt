package com.asyncapi.v2.binding.operation.http

import com.asyncapi.v2.SerDeTest

class HTTPOperationBindingTest: SerDeTest<HTTPOperationBinding>() {

    override fun objectClass() = HTTPOperationBinding::class.java

    override fun baseObjectJson() = "/json/2.6.0/binding/operation/http/httpOperationBinding.json"

    override fun extendedObjectJson() = "/json/2.6.0/binding/operation/http/httpOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/binding/operation/http/httpOperationBinding - wrongly extended.json"

    override fun build(): HTTPOperationBinding {
        return HTTPOperationBinding.builder()
                .type("request")
                .method("GET")
                .query(mapOf(
                        Pair("type", "object"),
                        Pair("required", listOf("companyId")),
                        Pair("properties", mapOf(
                                Pair("companyId", mapOf(
                                        Pair("type", "number"),
                                        Pair("minimum", 1),
                                        Pair("description", "The Id of the company.")
                                )),
                                Pair("additionalProperties", false)
                        )),
                ))
                .build()
    }

}