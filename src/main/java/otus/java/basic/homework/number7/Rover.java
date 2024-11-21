package otus.java.basic.homework.number7;

public class Rover implements Transport{
    private int fuel;
    private boolean status = true;

    @Override
    public boolean isStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    public Rover(int fuel) {
        this.fuel = fuel;
    }

    @Override
    public String getName() {
        return "вездеход";
    }

    public int getFuel() {
        return fuel;
    }

    @Override
    public boolean go(int distance, Area area) {
        if (fuel < 10 * distance/100) {
            System.out.println("Вездеход не может проехать дистанцию " + distance + ". Не хватает бензина." );
            return false;
        }
        fuel -= 10 * distance/100;
        System.out.println("Человек проехал на вездеходе дистанцию " + distance + ". Осталось бензина - " + getFuel() );
        return true;
    }
}
