package com.asyncapi.v3._0_0.model.info

import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class ContactTest: SerDeTest<Contact>() {

    override fun objectClass() = Contact::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/info/contact.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/info/contact - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/info/contact - wrongly extended.json"

    override fun build(): Contact {
        return Contact(
                "AsyncApi",
                "https://www.asyncapi.com",
                "java@asyncapi.com"
        )
    }

}
