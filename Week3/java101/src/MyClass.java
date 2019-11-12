import java.sql.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MyClass {
    // executable class because of main method
    public static void main(String[] args) {
        var array = new int[]{6, 3, 2, 7, 23, 5, 7};

        int sumOfArrayElements = sum(array);
        System.out.println("sum: " + sumOfArrayElements);

        double averageOfArrayElements = average(array);
        System.out.println("average: " + averageOfArrayElements);

        int maxOfArrayElements = max(array);
        System.out.println("max: " + maxOfArrayElements);

        int minOfArrayElements = min(array);
        System.out.println("min: " + minOfArrayElements);

    }

    private static int sum(int[] array) {
        int sumElements = 0;
        for (int el : array) {
            sumElements += el;
        }
        return sumElements;
    }

    private static double average(int[] array) {
        int sumOfArrayElements = sum(array);
        return (double) sumOfArrayElements / array.length;
    }

    private static int min(int[] array) {
        int minElement = array[0];
        for (int el : array) {
            if (el < minElement) {
                minElement = el;
            }
        }
        return minElement;
    }

    private static int max(int[] array) {
        int maxElement = array[0];
        for (int el : array) {
            if (el > maxElement) {
                maxElement = el;
            }
        }
        return maxElement;
    }

    /**
     * @return most common element of array
     */
    private static Integer findMode(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // map prepared;
        for (int el : array) {
            if (map.containsKey(el)) {
                map.put(el, map.get(el) + 1);
            } else {
                map.put(el, 1);
            }
        }

        // find max value:
        int max = 0;
        Integer mode = 0;
        for (Integer el : map.keySet()) {
            if (map.get(el) > max) {
                max = map.get(el);
                mode = el;
            }
        }

        return mode;
    }

    public static double findMedian(int[] array) {
        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
        if (array.length % 2 == 1) {
            return array[array.length / 2 ];
        } else {
            return (array[array.length / 2] + array[array.length / 2 - 1]) / 2.0;
        }
    }
    // Sout -> System.out.println();
    // psvm -> public static void main(String[] args)


}
