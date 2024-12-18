package otus.java.basic.homework;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        double[] array1 = new double[100_000_000];
        System.out.printf("Заполнение массива double[%d] по формуле в 1 поток...%n", array1.length);
        Measure.stamp();
        for (int i = 0; i < array1.length; i++) {
            array1[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        System.out.println("Конец выполнения");
        Measure.print();
        long time1 = Measure.getTime();


        double[] array2 = new double[100_000_000];
        int[] boundaries = {0, array2.length / 4, array2.length / 2, array2.length * 3 / 4, array2.length};
        System.out.printf("\nЗаполнение массива double[%d] по формуле в 4 потока...%n", array2.length);
        Measure.stamp();
        Thread[] threads = new Thread[4];
        for (int i = 0; i < threads.length; i++) {
            final int start = boundaries[i];
            final int end = boundaries[i + 1];
            threads[i] = new Thread(() -> {
                for (int j = start; j < end; j++) {
                    array2[j] = 1.14 * Math.cos(j) * Math.sin(j * 0.2) * Math.cos(j / 1.2);
                }
            });
        }
        threads[0].start();
        threads[1].start();
        threads[2].start();
        threads[3].start();
        threads[0].join();
        threads[1].join();
        threads[2].join();
        threads[3].join();

        System.out.println("Конец выполнения");
        Measure.print();
        long time2 = Measure.getTime();

        double value = (double)time1/time2;
        System.out.println("\nЗаполнение массива в 4 потока выполнилось в " + value + " раза быстрее, чем в один поток.");




    }
}
