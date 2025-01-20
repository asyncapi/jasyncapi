package com.asyncapi.v3._0_0.model.operation.reply

import com.asyncapi.v3.SerDeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class OperationReplyAddressTest: SerDeTest<OperationReplyAddress>() {

    override fun objectClass() = OperationReplyAddress::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/operation/reply/operationReplyAddress.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/operation/reply/operationReplyAddress - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/operation/reply/operationReplyAddress - wrongly extended.json"

    override fun build(): OperationReplyAddress {
        return OperationReplyAddress.builder()
                .description("Consumer inbox")
                .location("\$message.header#/replyTo")
                .build()
    }

}
