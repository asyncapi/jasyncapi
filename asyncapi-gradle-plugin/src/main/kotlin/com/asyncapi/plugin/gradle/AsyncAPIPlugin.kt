package com.asyncapi.plugin.gradle

import com.asyncapi.plugin.gradle.tasks.ResolveTask
import org.gradle.api.Plugin
import org.gradle.api.Project

class AsyncAPIPlugin: Plugin<Project> {

    override fun apply(project: Project) {
        val configuration = project.configurations.create("asyncApiDeps").setVisible(false)

        configuration.defaultDependencies {
            it.add(project.dependencies.create("com.asyncapi:asyncapi-core:1.0.0-SNAPSHOT"))
        }

        val task = project.tasks.create("resolve", ResolveTask::class.java)
        (task as ResolveTask).buildClasspath = configuration

        try {
            project.tasks.findByPath("classes").let {task.dependsOn("classes")}
            project.tasks.findByPath("compileJava").let {task.dependsOn("compileJava")}
            project.tasks.findByPath("compileTestJava").let {task.dependsOn("compileTestJava")}
            project.tasks.findByPath("compileKotlin").let {task.dependsOn("compileKotlin")}
            project.tasks.findByPath("compileTestKotlin").let {task.dependsOn("compileTestKotlin")}
            project.tasks.findByPath("testClasses").let {task.dependsOn("testClasses")}
        } catch (exception: Exception) {
            project.logger.warn("Task dependencies exception: ${exception.message}")
        }
    }
}