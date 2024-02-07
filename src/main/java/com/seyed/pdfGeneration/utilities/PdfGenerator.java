package com.seyed.pdfGeneration.utilities;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

public class PdfGenerator {
    private static final String WRITE_DATA = "src/main/java/com/seyed/pdfGeneration/PDF/sample.pdf";

    public void writeUsingIText() throws Exception {
            PdfWriter writer = new
                    PdfWriter(WRITE_DATA);

            // Creating a PdfDocument object
            PdfDocument pdfDoc = new PdfDocument(writer);

            // Creating a Document object
            Document doc = new Document(pdfDoc);

            String para1 = """
                             this is some text to appear in pdf as a paragraph.....
                             this is some text to appear in pdf as a paragraph.....
                             this is some text to appear in pdf as a paragraph.....
                             this is some text to appear in pdf as a paragraph.....
                             this is some text to appear in pdf as a paragraph.....
                            """;
            String para2 = """
                             This is again some text to appear on a pdf file as a paragraph....
                             This is again some text to appear on a pdf file as a paragraph....
                             This is again some text to appear on a pdf file as a paragraph....
                             This is again some text to appear on a pdf file as a paragraph....
                            """;

            // Creating Paragraphs
            Paragraph paragraph1 = new Paragraph(para1);
            Paragraph paragraph2 = new Paragraph(para2);

            // Adding paragraphs to document
            doc.add(paragraph1);
            doc.add(paragraph2);

            // Creating a table
            float [] pointColumnWidths = {200F, 200F};
            Table table = new Table(pointColumnWidths);

            // Adding row 1 to the table
            Cell c1 = new Cell();

            // Adding the contents of the cell
            c1.add("Name");

            // Setting the text alignment
            c1.setTextAlignment(TextAlignment.CENTER);

            // Adding the cell to the table
            table.addCell(c1);
            Cell c2 = new Cell();
            c2.add("Raju");
            c2.setTextAlignment(TextAlignment.CENTER);
            table.addCell(c2);

            // Adding row 2 to the table
            Cell c3 = new Cell();
            c3.add("Id");
            c3.setTextAlignment(TextAlignment.CENTER);
            table.addCell(c3);

            Cell c4 = new Cell();
            c4.add("001");
            c4.setTextAlignment(TextAlignment.CENTER);
            table.addCell(c4);

            // Adding row 3 to the table
            Cell c5 = new Cell();
            c5.add("Designation");
            c5.setTextAlignment(TextAlignment.CENTER);
            table.addCell(c5);

            Cell c6 = new Cell();
            c6.add("Programmer");
            c6.setTextAlignment(TextAlignment.CENTER);
            table.addCell(c6);

            // Adding Table to document
            doc.add(table);

            // Closing the document
            doc.close();
    }
}