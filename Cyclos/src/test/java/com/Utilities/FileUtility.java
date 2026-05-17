package com.Utilities;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtility {

	// Ai refer 
    public static String getDownloadedFilePath(
            String downloadPath,
            String fileExtension) {

        File folder = new File(downloadPath);

        if (!folder.exists()) {
            HelperClass.log.warn("Download folder does not exist: " + downloadPath);
            return null;
        }

        File[] files = folder.listFiles();

        if (files != null && files.length > 0) {
            return Arrays.stream(files)
                    .filter(file ->
                            file.getName().toLowerCase().contains(fileExtension.toLowerCase())
                                    && !file.getName().endsWith(".crdownload")
                                    && !file.getName().endsWith(".tmp"))
                    .max(Comparator.comparingLong(File::lastModified))
                    .map(File::getAbsolutePath)
                    .orElse(null);
        }

        HelperClass.log.warn("No matching files found in: " + downloadPath);
        return null;
    }
}