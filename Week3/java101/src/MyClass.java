import java.util.Scanner;

public class MyClass {
    // executable class because of main method
    public static void main(String[] args) {
        MyClass test = new MyClass();
        int c = test.sum(123, 321);
    }

    /**
     *
     * @param num1
     * @param num2
     * @return SUM num1 + num2
     */
    private static int sum(int num1, int num2) {
        return num1 + num2;
    }

    public static void printArray(int[] intArray) {
        for (int i : intArray) {
            System.out.println(i + " ");
        }
    }

    // Sout -> System.out.println();
    // psvm -> public static void main(String[] args)


}
