package otus.java.basic.homework3;

public class Homework3 {
    public static void main(String[] args) {
        System.out.println("------------------");
        int sumArr = 0;
        int [][] arr2d = {
                {  1,  2,  3},
                { -5,  6, 10},
                {-10, -3,  0}
        };
        printArr(arr2d);
        sumArr = sumOfPositiveElements(arr2d);
        System.out.println("Сумма положительных элементов массива равна " + sumArr);
        System.out.println("------------------");
        printSquare(7);
        System.out.println("------------------");
        System.out.println("Нули по диагонали");
        int [][] arr2 = {
                { 1, 2, 3, 8},
                { 5, 6, 2, 5},
                { 6, 3, 5, 1},
                { 2, 7, 9, 2}
        };
        zeroArrDiagonal(arr2);
        System.out.println("------------------");
        int max = 0;
        printArr(arr2d);
        max = findMax(arr2d);
        System.out.println("Максимальный элемент двумерного массива: " + max);
        System.out.println();
        printArr(arr2);
        max = findMax(arr2);
        System.out.println("Максимальный элемент двумерного массива: " + max);
        System.out.println("------------------");
        int [][] arr = {
                {  1,  2,  3},
                { -5,  6, 10},
                {-10, -3,  0}
        };
        System.out.println("Сумма элементов второй строки массива: " + sumSecondStr(arr));
        System.out.println();
        int [][] arr3 = {
                {  1,  2,  3}
        };
        System.out.println("Сумма элементов второй строки массива: " + sumSecondStr(arr3));
        System.out.println("------------------");
        System.out.println("Заполнение двумерного массива размером N*N по спирали");
        spiralArr(4);
        System.out.println();
        spiralArr(7);
        System.out.println("------------------");
        System.out.println("Заполнение двумерного массива размером N*M по спирали");
        spiralBoxArr(4, 6);
        System.out.println();
        spiralBoxArr(7,9);
        System.out.println();
        spiralBoxArr(8,5);
        System.out.println("------------------");
    }

    /**
     * Метод подсчета сумм положительных элементов двумерного массива
     * @param arr - двумерный массив
     * @return sum - сумма положительных элементов двумерного массива
     */
    public static int sumOfPositiveElements(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] >= 0) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    /**
     * Метод, печатающий в консоль квадрат из символов * со стороной size длины
     * @param size
     */
    public static void printSquare(int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    /** Метод зануляющий диагональные элементы двумерного массива
     * @param arr - двумерный массив
     */
    public static void zeroArrDiagonal(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }
        printArr(arr);

    }

    /**
     * Метод нахождения максимального элемента двумерного массива
     * @param arr - двумерный массив
     * @return max - максимальный двумерного массива
     */
    public static int findMax(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] >= max) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    /**
     * Метод подсчета сумм элементов второй строки двумерного массива
     * @param arr - двумерный массив
     * @return sum - сумма положительных элементов двумерного массива
     */
    public static int sumSecondStr(int[][] arr) {
        printArr(arr);
        int sum = 0;
        if (arr.length <= 1) {
            return -1;
        }
        for (int i = 0; i < arr[1].length; i++) {
            sum += arr[1][i];
        }
        return sum;
    }

    /**
     * Метод печатающий в консоль форматированный массив
     * @param arr - двумерный массив типа int[][]
     */
    public static void printArr(int[][] arr) {
        String strArr;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                strArr= String.format("%3s", arr[i][j]);
                System.out.print(strArr);
            }
            System.out.println();
        }
    }

    /**
     * Метод печатающий числа от 0 до size*size-1 по спирали двумерного массива размерностью size
     * @param size
     */
    public static void spiralArr(int size) {
        int[][] arrNum = new int[size][size];
        int rowMin = 0;
        int columnMin = 0;
        int rowMax = size - 1;
        int columnMax = size - 1;
        int num = 0;
        do {
            // проход влево по верхней строке
            for (int i = columnMin; i <= columnMax ; i++) {
                arrNum[rowMin][i] = num++;
            }
            rowMin++;
            // проход вниз по столбцу по правому краю
            for (int i = rowMin; i <= rowMax; i++) {
                arrNum[i][columnMax] = num++;
            }
            columnMax --;
            // проход вправо по нижней строке
            for (int i = columnMax; i >= columnMin; i--) {
                arrNum[rowMax][i] = num++;
            }
            rowMax --;
            // проход вверх по столбцу по левому краю
            for (int i = rowMax; i >= rowMin; i--) {
                arrNum[i][columnMin] = num++;
            }
            columnMin++;
        } while (num < size*size);

        printArr(arrNum);

    }

    /**
     *  * Метод печатающий числа от 0 до N*M-1 по спирали двумерного массива размерностью N*M
     * @param n
     * @param m
     */
    public static void spiralBoxArr(int n, int m) {
        int[][] arrNum = new int[n][m];
        int rowMin = 0;
        int columnMin = 0;
        int rowMax = n - 1;
        int columnMax = m - 1;
        int num = 0;
        do {
            // проход влево по верхней строке
            for (int i = columnMin; i <= columnMax ; i++) {
                if (arrNum[rowMin][i] != 0) break;
                arrNum[rowMin][i] = num++;
            }
            rowMin++;

            // проход вниз по столбцу по правому краю
            for (int i = rowMin; i <= rowMax; i++) {
                if (arrNum[i][columnMax] != 0) break;
                arrNum[i][columnMax] = num++;
            }
            columnMax--;

            // проход вправо по нижней строке
            for (int i = columnMax; i >= columnMin; i--) {
                if (arrNum[rowMax][i] != 0) break;
                arrNum[rowMax][i] = num++;
            }
            rowMax--;
            // проход вверх по столбцу по левому краю
            for (int i = rowMax; i >= rowMin; i--) {
                if (arrNum[i][columnMin] != 0) break;
                arrNum[i][columnMin] = num++;
            }
            columnMin++;
        } while (num < n*m);

        printArr(arrNum);

    }
}
