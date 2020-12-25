package com.asyncapi.plugin.idea.extensions.icon

import com.asyncapi.plugin.idea.extensions.inspection.AsyncAPISchemaDetector
import com.intellij.ide.IconProvider
import com.intellij.json.psi.JsonFile
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import org.jetbrains.yaml.psi.YAMLFile
import javax.swing.Icon

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPIIconProvider: IconProvider() {

    private val asyncApiSchemaDetector = AsyncAPISchemaDetector()

    override fun getIcon(element: PsiElement, flags: Int): Icon? {
        if (element is JsonFile || element is YAMLFile) {
            if (asyncApiSchemaDetector.isAsyncAPISchema(element as? PsiFile) ||
                asyncApiSchemaDetector.isReferencedAsyncAPISchema(element as? PsiFile)
            ) {
                return Icons.ASYNCAPI_ICON
            }
        }

        return null
    }

}