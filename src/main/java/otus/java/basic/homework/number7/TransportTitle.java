package otus.java.basic.homework.number7;

public enum TransportTitle {
    BIKE("велосипед"),
    ROVER("вездеход"),
    HORSE("лошадь"),
    CAR("машина");

    final String title;

    TransportTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }
}
