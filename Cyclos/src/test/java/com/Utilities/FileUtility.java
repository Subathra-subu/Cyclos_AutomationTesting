package com.Utilities;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtility {

    public static String getDownloadedFilePath(
            String downloadPath,
            String fileExtension) {

        File folder = new File(downloadPath);

        File[] files = folder.listFiles();

        if (files != null && files.length > 0) {

            return Arrays.stream(files)

                    .filter(file ->
                            file.getName().contains(fileExtension)
                                    && !file.getName().endsWith(".crdownload")
                                    && !file.getName().endsWith(".tmp"))

                    .max(Comparator.comparingLong(File::lastModified))

                    .map(File::getAbsolutePath)

                    .orElse(null);
        }

        return null;
    }
}