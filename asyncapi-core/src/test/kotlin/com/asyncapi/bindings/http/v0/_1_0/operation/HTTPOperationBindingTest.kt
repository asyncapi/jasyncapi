package com.asyncapi.bindings.http.v0._1_0.operation

import com.asyncapi.v3.SerDeTest
import com.asyncapi.v3.schema.AsyncAPISchema
import com.asyncapi.v3.schema.Type
import java.math.BigDecimal

class HTTPOperationBindingTest: SerDeTest<HTTPOperationBinding>() {

    override fun objectClass() = HTTPOperationBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/operation/http/httpOperationBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/operation/http/httpOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/operation/http/httpOperationBinding - wrongly extended.json"

    override fun build(): HTTPOperationBinding {
        return HTTPOperationBinding.builder()
                .type(HTTPOperationType.REQUEST)
                .method(HTTPOperationMethod.GET)
                .query(AsyncAPISchema.builder()
                        .type(Type.OBJECT)
                        .required(listOf("companyId"))
                        .properties(mapOf(
                                Pair(
                                        "companyId",
                                        AsyncAPISchema.builder()
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