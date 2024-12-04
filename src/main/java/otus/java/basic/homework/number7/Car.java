package otus.java.basic.homework.number7;

public class Car implements Transport{
    private int fuel;
    private boolean status = true;
    final boolean isPlainEnable = true;
    final boolean isForestEnable = false;
    final boolean isSwampEnable = false;
    public TransportTitle title = TransportTitle.CAR;

    @Override
    public boolean isStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    public Car(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public String getName() {
        return title.getTitle();
    }

    @Override
    public boolean go(int distance, Area area, Human driver) {
        if (area == Area.PLAIN && !isPlainEnable) {
            System.out.println("Машина не может проехать по равнине." );
            return false;
        } else if (area == Area.FOREST && !isForestEnable) {
            System.out.println("Машина не может проехать по лесу." );
            return false;
        } else if (area == Area.SWAMP && !isSwampEnable) {
            System.out.println("Машина не может проехать по болоту." );
            return false;
        } else if (fuel < 5 * distance/100) {
            System.out.println("Машина не может проехать дистанцию " + distance + ". Не хватает бензина." );
            return false;
        } else {
            fuel -= 5 * distance / 100;
            System.out.println("Человек проехал на машине дистанцию " + distance + ". Осталось бензина - " + getFuel());
            return true;
        }
    }


}
