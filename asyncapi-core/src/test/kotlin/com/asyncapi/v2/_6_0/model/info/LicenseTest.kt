package com.asyncapi.v2._6_0.model.info

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class LicenseTest: SerDeTest<License>() {

    override fun objectClass() = License::class.java

    override fun baseObjectJson() = "/json/v2/2.6.0/model/info/license.json"

    override fun extendedObjectJson() = "/json/v2/2.6.0/model/info/license - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/2.6.0/model/info/license - wrongly extended.json"

    override fun build(): License {
        return License(
                "Apache License 2.0",
                "http://www.apache.org/licenses/"
        )
    }

}
