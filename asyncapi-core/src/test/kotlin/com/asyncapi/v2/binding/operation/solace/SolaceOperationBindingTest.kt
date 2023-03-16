package com.asyncapi.v2.binding.operation.solace

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.binding.operation.solace.queue.SolaceQueue
import com.asyncapi.v2.binding.operation.solace.topic.SolaceTopic

class SolaceOperationBindingTest: SerDeTest<SolaceOperationBinding>() {

    override fun objectClass() = SolaceOperationBinding::class.java

    override fun baseObjectJson() = "/json/binding/operation/solace/solaceOperationBinding.json"

    override fun extendedObjectJson() = "/json/binding/operation/solace/solaceOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/binding/operation/solace/solaceOperationBinding - wrongly extended.json"

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