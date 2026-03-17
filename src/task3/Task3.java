package task3;

import java.util.function.Function;

public class Task3 {
    @SafeVarargs
    public static <T extends Number & Comparable<T>> T findExtreme(Function<T[], T> extreme, T... values) {
        return extreme.apply(values);
    }

    public static void main(String[] args) {
        Integer[] nums = {5, 2, 8, 1};

        Function<Integer[], Integer> maxOfFour = arr -> {
            int max = arr[0];
            for (int num : arr) {
                if (num > max) max = num;
            }
            return max;
        };

        Function<Integer[], Integer> minOfFour = arr -> {
            int min = arr[0];
            for (int num : arr) {
                if (num < min) min = num;
            }
            return min;
        };

        System.out.println("Максимум из " + java.util.Arrays.toString(nums) + ": " + findExtreme(maxOfFour, nums));
        System.out.println("Минимум из " + java.util.Arrays.toString(nums) + ": " + findExtreme(minOfFour, nums));

    }
}
