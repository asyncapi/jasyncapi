package com.asyncapi.plugin.gradle

import com.asyncapi.plugin.gradle.tasks.ResolveTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class AsyncAPIPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        project.tasks.create("resolve", ResolveTask::class.java)
    }
}