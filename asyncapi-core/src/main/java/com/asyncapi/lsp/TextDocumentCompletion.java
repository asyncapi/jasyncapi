package com.asyncapi.lsp;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import org.jetbrains.annotations.NotNull;

import java.lang.annotation.*;

/**
 * Provides necessary information for <a href="https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/#textDocument_completion">textDocument_completion</a> request
 *
 * @see <a href="https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/">LSP specification</a>
 * @since 1.0.0-RC5
 * @author Pavel Bodiachevskii
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@JacksonAnnotation
public @interface TextDocumentCompletion {

    /**
     * A human-readable string with additional information about this item, like type or symbol information.
     *
     * @return string
     */
    @NotNull String detail();

    /**
     * Extended description of selected field
     *
     * @return string
     */
    @NotNull String documentation() default "";

    /**
     * Classes to extract fields from for preparation of completion variants
     *
     * @return array of classes
     */
    @NotNull Class<?>[] variants() default {};

}
