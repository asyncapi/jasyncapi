package com.asyncapi.v3

/**
 * @author Pavel Bodiachevskii
 */
object ClasspathUtils {

    fun readAsString(resourceName: String): String {
        return ClasspathUtils::class.java
                .getResource(resourceName)
                .readText(charset = Charsets.UTF_8)
    }

}
