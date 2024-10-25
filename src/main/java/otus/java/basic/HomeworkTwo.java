package otus.java.basic;

import java.util.Arrays;

public class HomeworkTwo {
    public static void main(String[] args) {
//        printString(5, "Hello, Java!");
//        sumArr(new int[] {4, 5, 10, 0, 3, 20});
//        fillArr(20, new int[5]);
//        fillArrEvery(5, new int[] {1, 2, 3, 4, 5, 6});
//        checkSumArr(new int[] {1, 2, 3, 4, 5, 6});
//        checkSumArr(new int[] {10, 20, 30, 4, 5, 6});
//        checkSumArr(new int[] {1, 2, 3, 1, 2, 3});
//        checkSumArr(new int[] {1, 2, 3, 4, 5, 6, 7});
        // ДЗ* дополнительное
        sumAllArr(new int[] {1, 2, 3}, new int[] {2,2}, new int[] {1,1,1,1,1});
        equalSum(new int[] {1, 2, 3});
        equalSum(new int[] {1, 1, 1, 3});
        equalSum(new int[] {1, 1, 1, 3, 5});
        sortArr(new int[] {1, 1, 1, 3, 5});
        sortArr(new int[] {1, 4, 7, 9, 15});
        sortArr(new int[] {1, 10, 1, 3, 5});
        mirrorArr(new int[] {1, 11, 10, 35, 5});
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


    public static void sumAllArr(int[] arr1, int[] arr2, int[] arr3 ) {
        int maxLength = Math.max(arr1.length, Math.max(arr2.length, arr3.length));
        int[] output = new int[maxLength];
        for (int i = 0; i < arr1.length; i++) {
            output[i] += arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            output[i] += arr2[i];
        }
        for (int i = 0; i < arr3.length; i++) {
            output[i] += arr3[i];
        }

        System.out.println(Arrays.toString(arr1));
        System.out.println("+");
        System.out.println(Arrays.toString(arr2));
        System.out.println("+");
        System.out.println(Arrays.toString(arr3));
        System.out.println("=");
        System.out.println(Arrays.toString(output));
    }

    public static void equalSum(int[] arr) {
        int sum1 = arr[0] ;
        int sum2 = arr[arr.length-1];
        int fix1 = 0;
        int fix2 = arr.length-1;
        System.out.println(Arrays.toString(arr));
        for (int i = 1; i < arr.length - 1; i++) {
            if (sum1 > sum2) {
                sum2 += arr[arr.length-1-i];
                fix2 = arr.length-1-i;
                if (fix1 + 1 == fix2){
                    if (sum1 == sum2) {
                        System.out.println("Точка находится между элементами "+arr[fix1]+" и "+ arr[fix2]);
                        break;
                    }
                    System.out.println("Такой точки нет");
                    break;
                }
            } else if (sum1 < sum2) {
                sum1 += arr[i];
                fix1 = i;
                if (fix1 + 1 == fix2){
                    if (sum1 == sum2) {
                        System.out.println("Точка находится между элементами "+arr[fix1]+" и "+ arr[fix2]);
                        break;
                    }
                    System.out.println("Такой точки нет");
                    break;
                }
            } else {
                if (fix1 +1 == fix2){
                    System.out.println("Точка находится между элементами "+arr[fix1]+" и "+ arr[fix2]);
                    break;
                } else {
                    System.out.println("Такой точки нет.");
                    break;
                }
            }
        }
    }

    public static void sortArr(int[] a) {
        System.out.println(Arrays.toString(a));
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                System.out.println("Элементы массива расположены не по порядку возрастания");
                break;
            }
            if (i == a.length - 1) {
                System.out.println("Элементы массива расположены по порядку возрастания");
            }
        }
    }

    public static void mirrorArr(int[] a) {
        System.out.println("Входящий массив: " + Arrays.toString(a));
        int[] b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[a.length - 1 - i] = a[i];
        }
        System.out.println("Перевернутый массив: " + Arrays.toString(b));

    }
}
