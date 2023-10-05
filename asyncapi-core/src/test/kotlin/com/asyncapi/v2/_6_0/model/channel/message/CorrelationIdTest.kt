package com.asyncapi.v2._6_0.model.channel.message

import com.asyncapi.v2.SerDeTest

class CorrelationIdTest: SerDeTest<CorrelationId>() {

    override fun objectClass() = CorrelationId::class.java

    override fun baseObjectJson() = "/json/v2/2.6.0/model/channel/message/correlationId.json"

    override fun extendedObjectJson() = "/json/v2/2.6.0/model/channel/message/correlationId - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.6.0/model/channel/message/correlationId - wrongly extended.json"

    override fun build(): CorrelationId {
        return CorrelationId.builder()
                .description("Default Correlation ID")
                .location("\$message.header#/correlationId")
                .build()
    }

}