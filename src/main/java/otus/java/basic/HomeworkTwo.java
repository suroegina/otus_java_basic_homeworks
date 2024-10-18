package otus.java.basic;

import java.util.Arrays;

public class HomeworkTwo {
    public static void main(String[] args) {
        printString(5, "Hello, Java!");
        sumArr(new int[] {4, 5, 10, 0, 3, 20});
        fillArr(20, new int[5]);
        fillArrEvery(5, new int[] {1, 2, 3, 4, 5, 6});
        checkSumArr(new int[] {1, 2, 3, 4, 5, 6});
        checkSumArr(new int[] {10, 20, 30, 4, 5, 6});
        checkSumArr(new int[] {1, 2, 3, 1, 2, 3});
        checkSumArr(new int[] {1, 2, 3, 4, 5, 6, 7});


    }

    public static void printString(int n, String str) {
        for (int i = 0; i < n; i++) {
            System.out.println(str);
        }
    }

    public static void sumArr(int... arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 5) {
                sum += arr[i];
            }
        }
        System.out.println("Сумма элементов массива, значение которых больше 5 равна " + sum);
    }

    public static void fillArr(int n, int... arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = n;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void fillArrEvery(int n, int... arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += n;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void checkSumArr(int... arr) {
        int sum1 = 0;
        int sum2 = 0;
        System.out.println("Исходный массив: " + Arrays.toString(arr));
        for (int i = 0; i < arr.length/2; i++) {
            sum1 += arr[i];
        }
        for (int i = arr.length/2; i < arr.length; i++) {
            sum2 += arr[i];
        }
        if (sum1 > sum2) {
            System.out.println("Сумма первой половины массива (" + sum1 + ") больше суммы второй половины массива ("+sum2+")");
        } else if (sum1 < sum2) {
            System.out.println("Сумма второй половины массива (" + sum2 + ") больше суммы первой половины массива ("+sum1+")");
        } else {
            System.out.println("Сумма первой половины массива (" + sum1 + ") равна сумме второй половины массива ("+sum2+")");
        }

    }
}
