package com.seyed.pdfGeneration.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class JavaDataToExcel {
    private static final String WRITE_DATA = "src/main/java/com/seyed/pdfGeneration/Excel/sample.xlsx";

    public void writeTextToExcel() throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();

        // spreadsheet object
        XSSFSheet spreadsheet = workbook.createSheet(" Student Data ");

        // creating a row object
        XSSFRow row;

        // This data needs to be written (Object[])
        Map<String, Object[]> studentData = new TreeMap<String, Object[]>();

        studentData.put(
                "1",
                new Object[] { "Roll No", "NAME", "Year" });

        studentData.put("2", new Object[] { "111", "abc1",
                "2nd year" });

        studentData.put(
                "3",
                new Object[] { "121", "abc2", "2nd year" });

        studentData.put("4", new Object[] { "130", "abc3",
                "2nd year" });

        studentData.put("5", new Object[] { "131", "abc4",
                "2nd year" });

        studentData.put("6", new Object[] { "132", "abc5",
                "2nd year" });

        Set<String> keyId = studentData.keySet();

        int rowid = 0;

        // writing the data into the sheets...

        for (String key : keyId) {

            row = spreadsheet.createRow(rowid++);
            Object[] objectArr = studentData.get(key);
            int cellid = 0;

            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
        }

        // .xlsx is the format for Excel Sheets...
        // writing the workbook into the file...
        FileOutputStream out = new FileOutputStream(
                new File(WRITE_DATA));

        workbook.write(out);
        out.close();
    }
}