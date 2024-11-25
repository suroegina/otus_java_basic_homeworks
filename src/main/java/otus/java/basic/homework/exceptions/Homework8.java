package otus.java.basic.homework.exceptions;

import java.util.Arrays;

public class Homework8 {
    public static void main(String[] args) {
        String[][] arrayStr = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        printArray(arrayStr);
        System.out.println("Сумма всех элементов массива: " + getArraySum(arrayStr));
        System.out.println();

//        String[][] arrayStr1 = {
//                {"1", "2", "3", "4", "8"},
//                {"1", "2", "0", "4", "7"},
//                {"1", "2", "3", "4", "9"},
//                {"1", "2", "3", "4", "0"}
//        };
//        printArray(arrayStr1);
//        System.out.println("Сумма всех элементов массива: " + getArraySum(arrayStr1));
//
//        System.out.println();

        String[][] arrayStr2 = {
                {"1", "2", "3", "4"},
                {"1", "2", "g", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        printArray(arrayStr2);
        System.out.println("Сумма всех элементов массива: " + getArraySum(arrayStr2));

    }

    public static void printArray (String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int getArraySum (String[][] array) throws AppArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new AppArraySizeException("Дмумерный массив должен быть размером 4х4");
        }
        int[][] arrayInt = new int[4][4];
        int sum = 0;
        int currentX = 0;
        int currentY = 0;
        try {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    currentX = i;
                    currentY = j;
                    arrayInt[i][j] = Integer.parseInt(array[i][j]);
                }
            }
            for (int i = 0; i < arrayInt.length; i++) {
                for (int j = 0; j < arrayInt[i].length; j++) {
                    sum += arrayInt[i][j];
                }
            }
            return sum;
        } catch (Exception e) {
            throw new AppArrayDataException("В ячейке [" + currentX + "][" + currentY + "] значение '" + array[currentX][currentY] + "' невозможно преобразовать в тип int.");
        }
    }
}

