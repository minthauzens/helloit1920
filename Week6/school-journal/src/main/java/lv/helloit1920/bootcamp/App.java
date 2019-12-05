package lv.helloit1920.bootcamp;


import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        JournalUserInterface ui = new JournalUserInterface(new Scanner(System.in));
        ui.run();
    }

}
