package com.asyncapi.v2

import com.asyncapi.schemas.ExtendableObject
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

abstract class SerDeTest<ObjectType> {

    protected val objectMapper = ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL)

    protected abstract fun objectClass(): Class<ObjectType>

    protected abstract fun baseObjectJson(): String

    protected abstract fun extendedObjectJson(): String

    protected abstract fun wronglyExtendedObjectJson(): String

    @Test
    @DisplayName("Compare hand crafted object with parsed json")
    fun compareObjectWithParsedJson() {
        val model = ClasspathUtils.readAsString(baseObjectJson())

        Assertions.assertEquals(
                objectMapper.readValue(model, objectClass()),
                build()
        )
    }

    @Test
    @DisplayName("Compare hand crafted extended object with parsed json")
    fun compareExtendedObjectWithParsedJson() {
        val model = objectMapper.readValue(ClasspathUtils.readAsString(extendedObjectJson()), objectClass())

        Assertions.assertEquals(0, (model as ExtendableObject).extensionFields!!["x-number"])
        Assertions.assertEquals("", (model as ExtendableObject).extensionFields!!["x-string"])
        Assertions.assertEquals(
                mapOf<String, Any>(Pair("property", emptyMap<Any, Any>())),
                (model as ExtendableObject).extensionFields!!["x-object"]
        )
        Assertions.assertEquals(model, buildExtended())
    }

    @Test
    @DisplayName("Compare hand crafted extended object with json")
    fun compareExtendedObjectWithJson() {
        val model = ClasspathUtils.readAsString(extendedObjectJson())

        Assertions.assertEquals(
                model,
                objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(buildExtended())
        )
    }

    @Test
    @DisplayName("Read wrongly extended object")
    fun readWronglyExtendedObject() {
        val model = ClasspathUtils.readAsString(wronglyExtendedObjectJson())

        val exception = Assertions.assertThrows(JsonMappingException::class.java) {
            objectMapper.readValue(model, objectClass())
        }
        Assertions.assertEquals(
                "\"ext-number\" is not valid extension property (through reference chain: ${objectClass().name}[\"ext-number\"])",
                exception.message
        )
    }

    abstract fun build(): ExtendableObject

    fun buildExtended(): ExtendableObject {
        val `object` = build()
        `object`.extensionFields = mapOf(
                Pair("x-number", 0),
                Pair("x-string", ""),
                Pair("x-object", mapOf<String, Any>(Pair("property", emptyMap<Any, Any>()))),
        )

        return `object`
    }

}