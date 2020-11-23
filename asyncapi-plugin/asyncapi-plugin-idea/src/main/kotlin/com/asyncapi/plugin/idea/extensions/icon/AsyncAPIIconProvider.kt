package com.asyncapi.plugin.idea.extensions.icon

import com.intellij.ide.IconProvider
import com.intellij.json.psi.JsonFile
import com.intellij.psi.PsiElement
import org.jetbrains.yaml.psi.YAMLFile
import javax.swing.Icon

/**
 * @author Pavel Bodiachevskii
 */
class AsyncAPIIconProvider: IconProvider() {

    override fun getIcon(element: PsiElement, flags: Int): Icon? {
        if (element is JsonFile || element is YAMLFile) {

            // TODO: Use IDEA indexes instead of cheap substring search.
            if (element.text.contains("asyncapi")) {
                return Icons.ASYNCAPI_ICON
            }
        }

        return null
    }

}