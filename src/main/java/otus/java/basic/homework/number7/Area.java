package otus.java.basic.homework.number7;

public enum Area {
    FOREST("ЛЕС", false, true, true, true),
    PLAIN("РАВНИНА", true, true, true, true),
    SWAMP("БОЛОТО", false, false, false, true);

    private String title;
    private boolean forCar;
    private boolean forBike;
    private boolean forHorse;
    private boolean forRover;


    Area(String title, boolean forCar, boolean forBike, boolean forHorse, boolean forRover) {
        this.title = title;
        this.forCar = forCar;
        this.forBike = forBike;
        this.forHorse = forHorse;
        this.forRover = forRover;
    }
    public String getTitle() {
        return title;
    }

    public boolean isForCar() {
        return forCar;
    }

    public boolean isForBike() {
        return forBike;
    }

    public boolean isForHorse() {
        return forHorse;
    }

    public boolean isForRover() {
        return forRover;
    }
}
