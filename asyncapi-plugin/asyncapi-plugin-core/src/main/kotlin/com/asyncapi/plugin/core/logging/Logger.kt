package com.asyncapi.plugin.core.logging

/**
 * @author Pavel Bodiachevskii
 */
interface Logger {

    fun info(message: String)

    fun error(message: String)

}