package otus.java.basic.homework.number7;

public interface Transport {
    boolean go(int distance, Area area);
    String getName();
    boolean isStatus();
    void setStatus(boolean status);
}
