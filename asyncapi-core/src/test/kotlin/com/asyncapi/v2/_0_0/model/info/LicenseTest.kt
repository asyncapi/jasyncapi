package com.asyncapi.v2._0_0.model.info

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class LicenseTest: SerDeTest<License>() {

    override fun objectClass() = License::class.java

    override fun baseObjectJson() = "/json/2.0.0/model/info/license.json"

    override fun extendedObjectJson() = "/json/2.0.0/model/info/license - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.0.0/model/info/license - wrongly extended.json"

    override fun build(): License {
        return License(
                "Apache License 2.0",
                "http://www.apache.org/licenses/"
        )
    }

}
