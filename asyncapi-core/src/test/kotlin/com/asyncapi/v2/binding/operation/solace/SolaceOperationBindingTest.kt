package com.asyncapi.v2.binding.operation.solace

import com.asyncapi.v2.ClasspathUtils
import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.binding.operation.nats.NATSOperationBinding
import com.asyncapi.v2.binding.operation.solace.queue.SolaceQueue
import com.asyncapi.v2.binding.operation.solace.topic.SolaceTopic
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SolaceOperationBindingTest: SerDeTest<SolaceOperationBinding>() {

    override fun objectClass() = SolaceOperationBinding::class.java

    override fun baseObjectJson() = "/json/2.6.0/binding/operation/solace/solaceOperationBinding.json"

    override fun extendedObjectJson() = "/json/2.6.0/binding/operation/solace/solaceOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/binding/operation/solace/solaceOperationBinding - wrongly extended.json"

    override fun build(): SolaceOperationBinding {
        return SolaceOperationBinding.builder()
                .destinations(listOf(
                        SolaceDestination.builder()
                                .destinationType(SolaceDestination.Type.QUEUE)
                                .queue(SolaceQueue.builder()
                                        .name("CreatedHREvents")
                                        .topicSubscriptions(listOf("person/*/created"))
                                        .accessType(SolaceQueue.AccessType.EXCLUSIVE)
                                        .maxMsgSpoolSize("1,500")
                                        .maxTtl("60")
                                        .build()
                                )
                                .build(),
                        SolaceDestination.builder()
                                .destinationType(SolaceDestination.Type.QUEUE)
                                .queue(SolaceQueue.builder()
                                        .name("UpdatedHREvents")
                                        .topicSubscriptions(listOf("person/*/updated"))
                                        .build()
                                )
                                .topic(SolaceTopic.builder()
                                        .topicSubscriptions(listOf("person/*/updated"))
                                        .build()
                                )
                                .build()
                ))
                .build()
    }

}