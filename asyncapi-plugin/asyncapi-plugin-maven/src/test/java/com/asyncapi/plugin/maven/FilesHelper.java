package com.asyncapi.plugin.maven;

import java.io.File;
import java.util.Objects;

/**
 * @author Pavel Bodiachevskii
 */
public class FilesHelper {

    public static File readResource(String path) {
        return new File(Objects.requireNonNull(
                FilesHelper.class.getClassLoader().getResource(path)
        ).getFile());
    }

    /**
     * Opens file check does it exists end returns it.
     * @param path file location
     * @return opened file.
     */
    public static File open(String path) {
        File file = new File(path);
        file.deleteOnExit();

        return file;
    }

}
