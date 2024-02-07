package com.seyed.pdfGeneration.utilities;


import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;
public class PdfToJava {
    private static final String READ_DATA = "src/main/java/com/seyed/pdfGeneration/PDF/fileName.pdf";

    public void readPDF() throws IOException {

        PdfReader reader = new PdfReader(READ_DATA);
        int pages = reader.getNumberOfPages();
        StringBuilder text = new StringBuilder();
        for (int i = 1; i <= pages; i++) {
            text.append(PdfTextExtractor.getTextFromPage(reader, i));
        }
        reader.close();
        System.err.println("\n\n________________Started________________");
        System.out.println(text);
    }
}
