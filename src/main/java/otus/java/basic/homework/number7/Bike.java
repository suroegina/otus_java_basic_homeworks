package otus.java.basic.homework.number7;

public class Bike implements Transport{
    private boolean humanInto;
    private boolean status = true;

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
        return "велосипед";
    }

    @Override
    public boolean go(int distance, Area area) {
        if (area == Area.PLAIN && !Area.PLAIN.isForBike()) {
            System.out.println("Велосипед не может проехать по равнине." );
            return false;
        } else if (area == Area.FOREST && !Area.FOREST.isForBike()) {
            System.out.println("Велосипед не может проехать по лесу." );
            return false;
        } else if (area == Area.SWAMP && !Area.SWAMP.isForBike()) {
            System.out.println("Велосипед не может проехать по болоту." );
            return false;
        } else {
            return true;
        }
    }
}
