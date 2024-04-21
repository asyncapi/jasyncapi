package com.asyncapi.v3.binding.operation.solace

import com.asyncapi.v3.SerDeTest
import com.asyncapi.bindings.solace.v0._3_0.operation.SolaceOperationBinding
import com.asyncapi.bindings.solace.v0._3_0.operation.SolaceOperationDestination
import com.asyncapi.bindings.solace.v0._3_0.operation.queue.SolaceOperationQueue
import com.asyncapi.bindings.solace.v0._3_0.operation.topic.SolaceOperationTopic

class SolaceOperationBindingTest: SerDeTest<SolaceOperationBinding>() {

    override fun objectClass() = SolaceOperationBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/operation/solace/solaceOperationBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/operation/solace/solaceOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/operation/solace/solaceOperationBinding - wrongly extended.json"

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