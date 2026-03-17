package task4;

import java.util.function.Predicate;

public class Task4 {
    public static int sumByCondition(int[] arr, Predicate<Integer> condition) {
        int sum = 0;
        for (int num : arr) {
            if (condition.test(num)) {
                sum += num;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] numbers = {5, -3, 10, 7, -1, 12, 0, 4};

        Predicate<Integer> equalsTo5 = n -> n == 5;
        System.out.println("Сумма равных 5: " + sumByCondition(numbers, equalsTo5));

        Predicate<Integer> notInRange2to8 = n -> n < 2 || n > 8;
        System.out.println("Сумма не в [2,8]: " + sumByCondition(numbers, notInRange2to8));

        Predicate<Integer> positive = n -> n > 0;
        System.out.println("Сумма положительных: " + sumByCondition(numbers, positive));

        Predicate<Integer> negative = n -> n < 0;
        System.out.println("Сумма отрицательных: " + sumByCondition(numbers, negative));
    }
}
