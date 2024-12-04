package otus.java.basic.homework.number7;

public interface Transport {
    boolean go(int distance, Area area, Human driver);
    boolean isStatus();
    void setStatus(boolean status);
    public String getName();
}
