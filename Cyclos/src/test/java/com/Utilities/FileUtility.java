package com.Utilities;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class FileUtility {

    // CHECK IF FILE EXISTS IN FOLDER
    public static boolean isFileDownloaded(String downloadPath, String fileExtension) {
        File folder = new File(downloadPath);
        File[] files = folder.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.getName().contains(fileExtension)
                        && !file.getName().endsWith(".crdownload")
                        && !file.getName().endsWith(".tmp")) {
                    return true;
                }
            }
        }
        return false;
    }

    // FIX: Returns the full path of the most recently downloaded file matching the extension.
    // This avoids hardcoding "transaction.pdf" since Chrome may name it differently.
    public static String getDownloadedFilePath(String downloadPath, String fileExtension) {
        File folder = new File(downloadPath);
        File[] files = folder.listFiles();

        if (files != null && files.length > 0) {
            // Filter for matching extension, ignore temp files, sort by newest first
            return Arrays.stream(files)
                    .filter(f -> f.getName().contains(fileExtension)
                            && !f.getName().endsWith(".crdownload")
                            && !f.getName().endsWith(".tmp"))
                    .max(Comparator.comparingLong(File::lastModified))
                    .map(File::getAbsolutePath)
                    .orElse(null);
        }
        return null;
    }
}