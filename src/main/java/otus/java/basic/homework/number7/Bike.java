package otus.java.basic.homework.number7;

public class Bike implements Transport{
    Human driver;
    private boolean status = true;
    final boolean isPlainEnable = true;
    final boolean isForestEnable = true;
    final boolean isSwampEnable = false;
    final TransportTitle title = TransportTitle.BIKE;

    @Override
    public boolean isStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String getName() {
        return title.getTitle();
    }

    @Override
    public boolean go(int distance, Area area, Human driver) {
        if (area == Area.PLAIN && !isPlainEnable) {
            System.out.println("Велосипед не может проехать по равнине." );
            return false;
        } else if (area == Area.FOREST && !isForestEnable) {
            System.out.println("Велосипед не может проехать по лесу." );
            return false;
        } else if (area == Area.SWAMP && !isSwampEnable) {
            System.out.println("Велосипед не может проехать по болоту." );
            return false;
        } else {
            if (driver.humanAble(distance, 0.4f)) {
                return true;
            }
            System.out.println("У человека нет сил, чтобы на велосипеде проехать." );
            return false;
        }
    }
}
