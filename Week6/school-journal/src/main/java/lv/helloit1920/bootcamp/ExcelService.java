package lv.helloit1920.bootcamp;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;

public class ExcelService {

    private static final String JOURNAL_FILE_NAME = "journal.xlsx";
    private static final File JOURNAL_FILE = new File(JOURNAL_FILE_NAME);


    public static void exportJournalToXSSF(Journal journal) throws IOException {
        // TODO: implement subject

        // test if journal is defined, maybe need to be try catch
        if (journal != null) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            // TODO: loop trough subjects and make a new subject with name matching sheet title;
            // TODO: insert cell titles
            XSSFSheet sheet = workbook.createSheet("Subject-name");
            int i = 0;
            for (Student student : journal.students.values()) {
                XSSFRow row = sheet.createRow(i);
                XSSFCell cellName = row.createCell(0); // first cell are names
                cellName.setCellType(CellType.STRING);
                cellName.setCellValue(student.getName());

                if (student.getGrades().size() != 0) {
                    int j = 1; // first cell are names
                    for (Integer grade : student.getGrades()) {
                        XSSFCell cellGrade = row.createCell(j);
                        cellGrade.setCellType(CellType.NUMERIC);
                        cellGrade.setCellValue(grade); // set cell want doubles (and probably on import will return them)
                        j++;
                    }
                }
                i++;
            }

            FileOutputStream out = new FileOutputStream(JOURNAL_FILE);
            workbook.write(out);
            out.close();
            System.out.println(JOURNAL_FILE_NAME + " written successfully.");
        }
    }

    public static Journal importJournalFromXLSX() throws IOException {
        Journal journal = new Journal();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(JOURNAL_FILE));

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            XSSFSheet sheet = workbook.getSheetAt(i);
            // TODO: get sheet name as subject name!

            for (Row row : sheet) {
                int j = 0;
                String studentName = null;  // this should always be something else
                ArrayList<Integer> grades = new ArrayList<>();
                for (Cell cell : row) {
                    if (j == 0) {
                        studentName = cell.getStringCellValue();
                    } else {
                        int number = (int) cell.getNumericCellValue();
                        grades.add(number);
                    }
                    j++;
                }
                if(studentName != null) {
                    Student student = new Student(studentName, grades);
                    journal.addStudent(student);
                }
            }
        }

        return journal;
    }
}
