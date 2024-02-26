package com.asyncapi.v2.binding.operation.http

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.schema.Schema
import com.asyncapi.v2.schema.Type
import java.math.BigDecimal

class HTTPOperationBindingTest: SerDeTest<HTTPOperationBinding>() {

    override fun objectClass() = HTTPOperationBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/operation/http/httpOperationBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/operation/http/httpOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/operation/http/httpOperationBinding - wrongly extended.json"

    override fun build(): HTTPOperationBinding {
        return HTTPOperationBinding.builder()
                .type(HTTPOperationType.REQUEST)
                .method(HTTPOperationMethod.GET)
                .query(Schema.builder()
                        .type(Type.OBJECT)
                        .required(listOf("companyId"))
                        .properties(mapOf(
                                Pair(
                                        "companyId",
                                        Schema.builder()
                                                .type(Type.NUMBER)
                                                .minimum(BigDecimal.ONE)
                                                .description("The Id of the company.")
                                                .build()
                                )
                        ))
                        .additionalProperties(false)
                        .build()
                )
                .build()
    }

}