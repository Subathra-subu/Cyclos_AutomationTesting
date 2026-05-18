package com.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtility {

    public static String readPDF(String filePath) {

        if (filePath == null || filePath.isEmpty()) {
            HelperClass.log.error("PDF file path is null or empty.");
            return "";
        }

        File file = new File(filePath);

        if (!file.exists()) {
            HelperClass.log.error("PDF file not found at path: " + filePath);
            return "";
        }

        String text = "";

        try {
            PDDocument document = PDDocument.load(file);
            PDFTextStripper stripper = new PDFTextStripper();
            text = stripper.getText(document);
            document.close();
            HelperClass.log.info("Successfully read PDF: " + filePath);
        } catch (IOException e) {
            HelperClass.log.error("Failed to read PDF at: " + filePath + " | Error: " + e.getMessage());
        }

        return text;
    }
}