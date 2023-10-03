package com.asyncapi.v3._0_0.model.operation.reply

import com.asyncapi.v3.Reference
import com.asyncapi.v3.SerDeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class OperationReplyTest: SerDeTest<OperationReply>() {

    override fun objectClass() = OperationReply::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/operation/reply/operationReply.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/operation/reply/operationReply - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/operation/reply/operationReply - wrongly extended.json"

    override fun build(): OperationReply {
        return OperationReply.builder()
                .address(OperationReplyAddressTest().build())
                .channel(Reference("#/components/channels/channel"))
                .messages(listOf(
                        Reference("#/components/messages/message 1"),
                        Reference("#/components/messages/message 2"),
                        Reference("#/components/messages/message 3"),
                ))
                .build()
    }

}

class OperationReplyTestWithReference: SerDeTest<OperationReply>() {

    override fun objectClass() = OperationReply::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/operation/reply/operationReply with reference.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/operation/reply/operationReply with reference - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/operation/reply/operationReply with reference - wrongly extended.json"

    override fun build(): OperationReply {
        return OperationReply.builder()
                .address(Reference("#/components/addresses/address"))
                .channel(Reference("#/components/channels/channel"))
                .messages(listOf(
                        Reference("#/components/messages/message 1"),
                        Reference("#/components/messages/message 2"),
                        Reference("#/components/messages/message 3"),
                ))
                .build()
    }

}
