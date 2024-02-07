package com.seyed.pdfGeneration.project;

import com.seyed.pdfGeneration.utilities.ExcelToJava;
import com.seyed.pdfGeneration.utilities.JavaDataToExcel;
import com.seyed.pdfGeneration.utilities.PdfGenerator;
import com.seyed.pdfGeneration.utilities.PdfToJava;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PdfGenerationApplicationTests {

    @Test
    void contextLoads() throws Exception {
        // new PdfGenerator().writeUsingIText();

       // new JavaDataToExcel().writeTextToExcel();

        // new ExcelToJava().readExcel();
        new PdfToJava().readPDF();
    }

}
