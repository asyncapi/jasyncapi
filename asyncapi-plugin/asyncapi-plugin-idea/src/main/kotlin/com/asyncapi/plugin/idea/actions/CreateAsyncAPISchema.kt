package com.asyncapi.plugin.idea.actions

import com.asyncapi.plugin.idea.extensions.icon.Icons
import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory

/**
 * @author Pavel Bodiachevskii
 */
class CreateAsyncAPISchema: CreateFileFromTemplateAction(
        "AsyncAPI schema",
        "Create a AsyncAPI schema from the specified template",
        Icons.ASYNCAPI_ICON
), DumbAware {

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder
                .setTitle("New API Specification")
                .addKind("AsyncAPI schema (yaml)", Icons.ASYNCAPI_ICON, "AsyncAPI schema (yaml).yaml")
                .addKind("AsyncAPI schema (json)", Icons.ASYNCAPI_ICON, "AsyncAPI schema (json).json")
    }

    override fun getActionName(directory: PsiDirectory?, newName: String, templateName: String?): String {
        return "Create API Specification $newName"
    }

}