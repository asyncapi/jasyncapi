package com.asyncapi.v2.binding.operation.solace

import com.asyncapi.v2.SerDeTest
import com.asyncapi.v2.binding.operation.solace.queue.SolaceOperationQueue
import com.asyncapi.v2.binding.operation.solace.topic.SolaceOperationTopic

class SolaceOperationBindingTest: SerDeTest<SolaceOperationBinding>() {

    override fun objectClass() = SolaceOperationBinding::class.java

    override fun baseObjectJson() = "/json/binding/operation/solace/solaceOperationBinding.json"

    override fun extendedObjectJson() = "/json/binding/operation/solace/solaceOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/binding/operation/solace/solaceOperationBinding - wrongly extended.json"

    override fun build(): SolaceOperationBinding {
        return SolaceOperationBinding.builder()
                .destinations(listOf(
                        SolaceOperationDestination.builder()
                                .destinationType(SolaceOperationDestination.Type.QUEUE)
                                .queue(SolaceOperationQueue.builder()
                                        .name("CreatedHREvents")
                                        .topicSubscriptions(listOf("person/*/created"))
                                        .accessType(SolaceOperationQueue.AccessType.EXCLUSIVE)
                                        .maxMsgSpoolSize("1,500")
                                        .maxTtl("60")
                                        .build()
                                )
                                .build(),
                        SolaceOperationDestination.builder()
                                .destinationType(SolaceOperationDestination.Type.QUEUE)
                                .queue(SolaceOperationQueue.builder()
                                        .name("UpdatedHREvents")
                                        .topicSubscriptions(listOf("person/*/updated"))
                                        .build()
                                )
                                .topic(SolaceOperationTopic.builder()
                                        .topicSubscriptions(listOf("person/*/updated"))
                                        .build()
                                )
                                .build()
                ))
                .build()
    }

}