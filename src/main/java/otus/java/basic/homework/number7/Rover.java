package otus.java.basic.homework.number7;

public class Rover implements Transport{
    private int fuel;
    private boolean status = true;
    public TransportTitle title = TransportTitle.ROVER;

    @Override
    public boolean isStatus() {
        return status;
    }

    @Override
    public String getName() {
        return title.getTitle();
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    public Rover(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public boolean go(int distance, Area area, Human driver) {
        if (fuel < 10 * distance/100) {
            System.out.println("Вездеход не может проехать дистанцию " + distance + ". Не хватает бензина." );
            return false;
        } else {
            fuel -= 10 * distance / 100;
            System.out.println("Человек проехал на вездеходе дистанцию " + distance + ". Осталось бензина - " + getFuel());
            return true;
        }
    }
}
