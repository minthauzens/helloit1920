import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class SchoolManagement {
    // should address be with / or with \\
    // ".\\schoolManagement\\"
    private final static String SCHOOL_FOLDER = "./schoolManagement/";
    private static boolean isRunning = true;

    public static void main(String[] args) throws IOException {
        while (isRunning) {
            System.out.println();
            System.out.println("Please select option (type a number): ");
            System.out.println("\t1 - add student");
            System.out.println("\t2 - add grade to a student");
            System.out.println("\t3 - get report about students (sorted by average grade)");
            System.out.println("\t0 - quit");

            Scanner scanner = new Scanner(System.in);
            // https://stackoverflow.com/questions/3780524/scanner-doesnt-stop-to-get-input
            // int input = scanner.nextInt();
            int input = Integer.parseInt(scanner.nextLine());
            System.out.println();
            switch (input) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    addGradeToAStudent(scanner);
                    break;
                case 3:
                    getReportByAverageGrade();
                    break;
                case 0:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid input! ");
                    System.out.println();
                    break;
            }
        }
    }

    private static void addStudent(Scanner scanner) throws IOException {
        System.out.println("Student name and surname: ");
        String student = scanner.nextLine();
        File studentFile = new File(SCHOOL_FOLDER + student);
        if (studentFile.exists()) {
            System.out.println("Student already exists");
        } else {
            FileWriter writer = new FileWriter(studentFile);
            writer.close();
            System.out.println("Student " + student + " entry created!");
            // TODO: ask to add grade y - n in a while loop to this student
        }
    }

    private static void addGradeToAStudent(Scanner scanner) throws IOException {
        System.out.println("Which student to add grade to? ");
        String student = scanner.nextLine();
        File studentFile = new File(SCHOOL_FOLDER + student);
        if (!studentFile.exists()) {
            System.out.println("Student doesn't exist!");
        } else {
            FileWriter writer = new FileWriter(studentFile, true);
            boolean input = true;
            System.out.println("Add grade: \n(if input is not a number will exit)");
            do {
                String gradeInput = scanner.nextLine();
                // TODO: test grade if between [1-10]
                // grade is an integer that is stored in a line after a grade a line break is added
                if (!gradeInput.matches("-?\\d+")) {
                    input = false;
                } else {
                    int grade = Integer.parseInt(gradeInput);
                    writer.write(grade + "\n");
                    System.out.println("Add more grades? \n(if input is not a number will exit)");
                }
//                }
            } while (input);
            writer.close();
        }
    }

    private static void getReportByAverageGrade() throws IOException {
        // read a file from folder:
        File schoolFolder = new File(SCHOOL_FOLDER);
        File[] students = schoolFolder.listFiles();

        HashMap<String, Double> studentsMap = new HashMap<>();
        if (students == null) {
            System.out.println("No students into the school system!");
        } else {
            for (File student : students) {
                if (!student.isDirectory()) {
                    // calculate average grade
                    double average = calculateAverageGrade(student);
                    // TODO: GET key name;
                    // get student name
                    String key = student.getName();
                    studentsMap.put(key, average);
                }
            }
            int counter = 0;
            while (studentsMap.size() > 0) {


                // sort map
                double max = -1 * Double.MAX_VALUE;
                // maxKey - student name with max value
                String maxKey = null;
                counter++;
                for (String el : studentsMap.keySet()) {
                    if (studentsMap.get(el) > max) {
                        max = studentsMap.get(el);
                        maxKey = el;
                    }
                }
                // print out the map
                // max == -1 when student has no grades
                if (max == -1) {
                    System.out.println(counter + ". " + maxKey + ": NaN");
                } else {
                    System.out.println(counter + ". " + maxKey + ": " + max);
                }
                // we remove student so next one could be found
                studentsMap.remove(maxKey);
            }
        }
    }

    private static double calculateAverageGrade(File studentFile) throws IOException {
        FileReader fileReader = new FileReader(studentFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String nextLine;
        int sum = 0;
        int count = 0;
        do {
            nextLine = bufferedReader.readLine();
            if (nextLine != null) {
                int grade = Integer.parseInt(nextLine);
                sum += grade;
                count++;
            }
            // check for end of file
        } while (nextLine != null);

        bufferedReader.close();
        fileReader.close();
        // this is possible if student is created but no grades are added
        if (count == 0) {
            return -1;
        } else {
            return (double) sum / count;
        }
    }
}
