package otus.java.basic.homework;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        double[] array1 = new double[100_000_000];
        System.out.println("Заполнение массива double[100_000_000] по формуле в 1 поток...");
        Measure.stamp();
        for (int i = 0; i < array1.length; i++) {
            array1[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
        System.out.println("Конец выполнения");
        Measure.print();
        long time1 = Measure.getTime();

        System.out.println("\nЗаполнение массива double[100_000_000] по формуле в 4 потока...");
        double[] array2 = new double[100_000_000];
        int l1 = 0;
        int l2 = (int)array2.length/4;
        int l3 = (int)array2.length/2;
        int l4 = (int)array2.length*3/4;
        int l5 = array2.length;
        Measure.stamp();
        Thread t1 = new Thread(() -> {
            for (int i = l1; i < l2; i++) {
                array2[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = l2; i < l3; i++) {
                array2[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread t3 = new Thread(() -> {
            for (int i = l3; i < l4; i++) {
                array2[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        Thread t4 = new Thread(() -> {
            for (int i = l4; i < l5; i++) {
                array2[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("Конец выполнения");
        Measure.print();
        long time2 = Measure.getTime();

        double value = (double)time1/time2;
        System.out.println("\nЗаполнение массива в 4 потока выполнилось в " + value + " раза быстрее, чем в один поток.");




    }
}
