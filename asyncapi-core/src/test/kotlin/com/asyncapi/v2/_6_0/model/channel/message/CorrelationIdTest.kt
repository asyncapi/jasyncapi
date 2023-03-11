package com.asyncapi.v2._6_0.model.channel.message

import com.asyncapi.v2.SerDeTest

class CorrelationIdTest: SerDeTest<CorrelationId>() {

    override fun objectClass() = CorrelationId::class.java

    override fun baseObjectJson() = "/json/2.6.0/model/channel/message/correlationId.json"

    override fun extendedObjectJson() = "/json/2.6.0/model/channel/message/correlationId - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/model/channel/message/correlationId - wrongly extended.json"

    override fun build(): CorrelationId {
        return CorrelationId.builder()
                .description("Default Correlation ID")
                .location("\$message.header#/correlationId")
                .build()
    }

}