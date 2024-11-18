package otus.java.basic.homework.number7;

public interface Transport {
    boolean isActive();
    boolean go(int distance, Area area, Human human);
    boolean isForestGo();
    boolean isSwampGo();
    boolean isPlainGo();
    String getName();

}
