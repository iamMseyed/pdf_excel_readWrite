package com.seyed.pdfGeneration.utilities;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.Iterator;

public class ExcelToJava {

    private static final String READ_DATA = "src/main/java/com/seyed/pdfGeneration/Excel/sample.xlsx";

    public void readExcel(){
        try
        {
            FileInputStream file = new FileInputStream(READ_DATA);

            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook wb = new XSSFWorkbook(file);

            //Get first/desired sheet from the workbook
            XSSFSheet ws = wb.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = ws.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    switch (cell.getCellType())
                    {
                        case NUMERIC:
                            System.err.print(cell.getNumericCellValue()+"\n");
                            break;
                        case STRING:
                            System.err.print(cell.getStringCellValue()+"\n");
                            break;
                    }
                }
                System.out.println("Reading File Completed.");
            }
            file.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }
}