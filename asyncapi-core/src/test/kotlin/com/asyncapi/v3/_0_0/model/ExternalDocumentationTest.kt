package com.asyncapi.v3._0_0.model

import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class ExternalDocumentationTest: SerDeTest<ExternalDocumentation>() {

    override fun objectClass() = ExternalDocumentation::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/externalDocumentation.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/externalDocumentation - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/externalDocumentation - wrongly extended.json"

    override fun build(): ExternalDocumentation {
        return ExternalDocumentation(
                "Find more info here",
                "https://example.com"
        )
    }

}
