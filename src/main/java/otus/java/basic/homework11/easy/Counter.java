package otus.java.basic.homework11.easy;

public class Counter {
    private Long count;

    public Counter() {
        count = 0L;
    }

    public Long getCount() {
        count++;
        return count;
    }

    public void increment() {
        count++;
    }
}
