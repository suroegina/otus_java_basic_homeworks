package otus.java.basic.homework.number7;

public class Rover implements Transport{
    private boolean isForestGo = true;
    private boolean isSwampGo = true;
    private boolean isPlainGo = true;
    private int fuel;

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
    public boolean isForestGo() {
        return isForestGo;
    }

    @Override
    public boolean isSwampGo() {
        return isSwampGo;
    }

    @Override
    public boolean isPlainGo() {
        return isPlainGo;
    }

    @Override
    public boolean isActive() {
        if (fuel > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean go(int distance, Area area, Human human) {
        if (fuel < 10 * distance/100) {
            System.out.println("Вездеход не может проехать дистанцию " + distance + ". Не хватает бензина." );
            return false;
        }
        fuel -= 10 * distance/100;
        System.out.println("Человек проехал на вездеходе дистанцию " + distance + ". Осталось бензина - " + getFuel() );
        return true;
    }
}
