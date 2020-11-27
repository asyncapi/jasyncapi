package com.asyncapi.plugin.idea.extensions.inspection

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.LocalInspectionToolSession
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.json.psi.JsonElementVisitor
import com.intellij.openapi.vfs.VfsUtil
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.util.ResourceUtil
import com.jetbrains.jsonSchema.extension.JsonLikePsiWalker
import com.jetbrains.jsonSchema.ide.JsonSchemaService
import com.jetbrains.jsonSchema.impl.JsonComplianceCheckerOptions
import com.jetbrains.jsonSchema.impl.JsonSchemaComplianceChecker

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPIJsonSchemaInspection: LocalInspectionTool() {

    private val asyncAPISchemaDetector = AsyncAPISchemaDetector()

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean, session: LocalInspectionToolSession): PsiElementVisitor {
        if (!asyncAPISchemaDetector.isAsyncAPIJsonSchema(holder.file)) {
            return PsiElementVisitor.EMPTY_VISITOR
        }

        return createVisitor(holder, isOnTheFly, session)
    }

    private fun createVisitor(holder: ProblemsHolder, isOnTheFly: Boolean, session: LocalInspectionToolSession): PsiElementVisitor {
        val asyncAPIJsonSchemaURL = ResourceUtil.getResource(javaClass, "schema", "asyncapi.schema.json")
        val asyncAPIJsonSchemaFile = VfsUtil.findFileByURL(asyncAPIJsonSchemaURL)
        asyncAPIJsonSchemaFile ?: return PsiElementVisitor.EMPTY_VISITOR

        val jsonSchemaService = JsonSchemaService.Impl.get(holder.project)
        val asyncAPIJsonSchemaObject = jsonSchemaService.getSchemaObjectForSchemaFile(asyncAPIJsonSchemaFile)
        asyncAPIJsonSchemaObject ?: return PsiElementVisitor.EMPTY_VISITOR

        return object: JsonElementVisitor() {
            override fun visitElement(element: PsiElement) {
                val jsonWalker = JsonLikePsiWalker.getWalker(element, asyncAPIJsonSchemaObject)
                jsonWalker ?: return

                JsonSchemaComplianceChecker(asyncAPIJsonSchemaObject, holder, jsonWalker, session, JsonComplianceCheckerOptions(false))
                        .annotate(element)
            }
        }
    }

}