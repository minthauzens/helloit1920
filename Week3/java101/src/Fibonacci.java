import java.util.Scanner;

public class Fibonacci {
    private static int fibonacci1 = 0;
    private static int fibonacci2 = 1;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sum of fibonacci numbers till which N-th element: ");
        System.out.println("(enter integer, please)");
        int n = scanner.nextInt();

        System.out.println(fibonacci1);
        System.out.println(fibonacci2);
        System.out.println("sum: " + sumTillNthElement(n));
    }

    private static long sumTillNthElement(int n) {
        long sum = fibonacci1 + fibonacci2;
        long fib1 = fibonacci1;
        long fib2 = fibonacci2;
        for (int i = 2; i < n; i++) {
            long fibNext = fib1 + fib2;
            System.out.println(fibNext);
            sum += fibNext;
            fib1 = fib2;
            fib2 = fibNext;
        }

        return sum;
    }

}
