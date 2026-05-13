package com.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtility {

    public static String readPDF(String filePath) {

        String text = "";

        try {

            File file = new File(filePath);

            PDDocument document = Loader.loadPDF(file);

            PDFTextStripper stripper =
                    new PDFTextStripper();

            text = stripper.getText(document);

            document.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return text;
    }
}