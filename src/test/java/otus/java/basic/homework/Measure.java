package otus.java.basic.homework;

public class Measure {
    private static long time;

    public static void stamp() {
        time = System.currentTimeMillis();
    }

    public static void print() {
        time = System.currentTimeMillis() - time;
        System.out.println("Time: " + time);
    }

    public static long getTime() {
        return time;
    }
}
