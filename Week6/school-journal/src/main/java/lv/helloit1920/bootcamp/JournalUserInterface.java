package lv.helloit1920.bootcamp;


import java.io.IOException;
import java.util.Scanner;

public class JournalUserInterface {
    private Scanner scanner;
    private Journal journal;

    public JournalUserInterface(Scanner scanner) {
        this.scanner = scanner;
        this.journal = new Journal();
    }

    public void run() {
        System.out.println("WELCOME TO YOUR AUTOMATED SCHOOL JOURNAL SYSTEM");
        System.out.println("===============================================");

        // get and parse userInput
        while (true) {
            printInstructions();
            String input = getUserInput();
            if ("1".equals(input)) {
                addStudent();
            } else if ("2".equals(input)) {
                addGrade();
            } else if ("3".equals(input)) {
                printStudent();
            } else if ("4".equals(input)) {
                printAllStudents();
            } else if ("5".equals(input)) {
                exportJournal();
            } else if ("6".equals(input)) {
                importJournal();
            } else if ("x".equalsIgnoreCase(input)) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Invalid input");
                System.out.println();
            }

        }
    }


    private void addStudent() {
        System.out.println("Student name: ");
        String name = getUserInput();
        if (!this.journal.students.containsKey(name)) {
            Student student = new Student(name);
            this.journal.addStudent(student);
            System.out.println("Student " + name + " added.");
            System.out.println("Do you want to add a grade to this student? (y/n)");
            String input = getUserInput();
            if ("y".equalsIgnoreCase(input)) {
                addGradeToStudent(student);
            }
        } else {
            System.out.println("Student already exists!");
        }
    }

    private void addGrade() {
        if (this.journal.isEmpty()) {
            System.out.println("Journal has no students!");
        } else {
            System.out.println("Student name: ");
            String name = getUserInput();
            if (this.journal.students.containsKey(name)) {
                addGradeToStudent(this.journal.getStudent(name));
            } else {
                System.out.println("Student doesn't exist!");
            }
        }
    }

    private void addGradeToStudent(Student student) {
        while (true) {
            try {
                System.out.println("Add grade: ");
                System.out.println("(input till your next not number input)");
                int grade = Integer.parseInt(getUserInput());
                student.addGrade(grade);
            } catch (NumberFormatException e) {
//                scanner.next();
                // https://stackoverflow.com/questions/32042391/confusion-with-an-infinite-while-loop-concerning-scanner-nextinte
                // they wrote so i could ignore next input (don't know if needed, haven't tested)
                System.out.println("Done adding grades");
                break;
            }
        }

    }

    private void printStudent() {
        System.out.println("Student name: ");
        String name = getUserInput();
        if (this.journal.students.containsKey(name)) {
            Student student = this.journal.getStudent(name);
            System.out.println(student);
            System.out.print("\tAll grades: ");
            student.printGrades();
        } else {
            System.out.println("Student doesn't exist!");
        }
    }

    private void printAllStudents() {
        if (this.journal.isEmpty()) {
            System.out.println("Journal doesn't have any students added");
        } else this.journal.printStudents();
    }

    private void exportJournal() {
        try {
            ExcelService.exportJournalToXSSF(this.journal);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void importJournal() {
        try {
            this.journal = ExcelService.importJournalFromXLSX();
            System.out.println("Journal imported successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printInstructions() {
        System.out.println("Choose action:");
        System.out.println("[1] Add Student");
        System.out.println("[2] Add Grade to existing student");
        System.out.println("[3] Print student");
        System.out.println("[4] Print all students"); // sorted by highest grade
        System.out.println("[5] Export journal to excel");
        System.out.println("[6] Import journal from excel");
        System.out.println("[x] Quit");

    }

    private String getUserInput() {
        return scanner.nextLine();
    }
    /*
    getStudent
    addStudent
    if student exists say so, but allow to add grade
    add grade to existing student
    print out list of students
    get overall average grade
    export journal to XSLX
    import journal from XSLX

    */
}
