import java.io.*;
import java.util.Scanner;

public class FileExample {
    private static final String FILE_GUEST_BOOK_NAME = "guestBook";

    public static void main(String[] args) {
        int num = 5;
        System.out.printf("Hello World %d", num);
        /* PRINT F:
            ! % + letter will be replaced with variable
            %d - digit (ints and the like)
            %f - float
            %s - string
            %S - string transform(UPPERCASE)
            %t - time (we will see more about this in the future)
            %b - boolean (lower case)
            %B - also boolean (UPPER CASE)
            %10.2f
        */
    }

    public static void readGuests() throws IOException {
//        File fileGuests = new File (FILE_GUEST_BOOK_NAME);

        FileReader fileReader = new FileReader(FILE_GUEST_BOOK_NAME);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        // fileReader.read -> reads into buffer

        String visitorName;
        do {
            visitorName = bufferedReader.readLine();
            System.out.println(visitorName);
        } while (visitorName != null);

        bufferedReader.close();
        fileReader.close();

    }

    public static void writeInGuestBook() throws IOException {
//        File fileGuests = new File(FILE_GUEST_BOOK_NAME);
        // this line is not a must fileWriter can take files and file paths
//        FileWriter fileWriter = new FileWriter(fileGuests, true);
        FileWriter fileWriter = new FileWriter(FILE_GUEST_BOOK_NAME, true);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, type in your name: ");
        String guestName = scanner.nextLine();

        if (!guestName.equals("")) {
            fileWriter.write(guestName + "\n");

        }
        fileWriter.close();

    }

    public static void firstHalfOfLessonMain() throws IOException {
        File testFile = new File("testFile");
//        System.out.println(testFile.createNewFile());

        // can choose in what way we open the program:
        // either we open in WRITE mode or APPEND mode

        FileWriter fileWriter = new FileWriter(testFile, true);
        // write deletes content that was in the file -> WRITES OVER
        // first write overwrites all other from the same action adds
        // write also creates file if it doesn't exist
        fileWriter.write("Hello");

        // this append adds to the file
        // fileWriter.append("test");

        // to economise how many times we go and write to HDD (its slower than RAM) we write things into buffer
        // that is on RAM, when buffer is full it is written/saved on HDD or when file is closed.

        // this makes the buffer saved into HDD right now
        fileWriter.flush();
        // always when open files DON'T FORGET TO CLOSE THEM
        fileWriter.close();
    }
}
