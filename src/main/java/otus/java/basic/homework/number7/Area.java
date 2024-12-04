package otus.java.basic.homework.number7;

public enum Area {
    FOREST("ЛЕС"),
    PLAIN("РАВНИНА"),
    SWAMP("БОЛОТО");

    final String title;

    Area(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

}
