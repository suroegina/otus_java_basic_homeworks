package otus.java.basic.homework11.easy;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int size = 10;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 1000);
        }
        System.out.println("Исходный массив: "  );
        printArray(array);
        Measure.stamp();
        bubbleSort(array);
        Measure.print();
        System.out.println("Отсортированный массив методом bubbleSort: "  );
        printArray(array);
        int[] array1 = new int[size];
        for (int i = 0; i < array.length; i++) {
            array1[i] = (int) (Math.random() * 1000);
        }
        System.out.println("-------------------------");
        System.out.println("Исходный массив: "  );
        printArray(array1);
        Measure.stamp();
        quickSort(array1, 0, array1.length - 1);
        Measure.print();
        System.out.println("Отсортированный массив методом quickSort: "  );
        printArray(array1);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    static void quickSort(int[] array, int leftBorder, int rightBorder){
        int middle = (int)(leftBorder + (rightBorder-leftBorder)/2);
        int pivot = array[middle];
        int leftIndex = 0;
        int rightIndex = array.length-1;

        do {
            while (array[leftIndex] < pivot) {
                leftIndex++;
            }
            while (array[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                int tmp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = tmp;
            }
            leftIndex++;
            rightIndex--;


        } while (leftIndex <= rightIndex);
        if (leftIndex < rightBorder) {
            quickSort(array, leftIndex, rightBorder);
        }
        if (leftBorder < rightIndex) {
            quickSort(array, leftBorder, rightIndex);
        }

    }

    static void bubbleSort(int[] array){
        int tmp;
        for (int i = array.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j+1] ) {
                   tmp = array[j];
                   array[j] = array[j+1];
                   array[j+1] = tmp;
                }
            }
        }

    }
}
