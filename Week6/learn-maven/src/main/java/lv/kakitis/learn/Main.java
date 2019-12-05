package lv.kakitis.learn;

import java.io.*;

import org.apache.poi.xssf.usermodel.*;

public class Main {
    static final String FILE_NAME = "createworkbook.xlsx";

    public static void main(String[] args) throws IOException {
        writeExcel();
        readExcel();
    }

    private static void readExcel() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(FILE_NAME)));
        XSSFSheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < 10; i++) {
            var row = sheet.getRow(i);
            var cell = row.getCell(0);
            System.out.println(cell.getRawValue());
        }
    }

    private static void writeExcel() throws IOException {
        // Create Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("My Sheet");

        for (int i = 1; i < 10; i++) {

            XSSFRow row = sheet.createRow(i - 1);
            XSSFCell cell = row.createCell(0);
            // coords of first cell and column are 0!
            cell.setCellValue(i);
        }


        //Create file system using specific name
        FileOutputStream out = new FileOutputStream(new File(FILE_NAME));

        //write operation workbook using file out object
        workbook.write(out);
        out.close();
        System.out.println(FILE_NAME + " written successfully");
    }
}
