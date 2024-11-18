package otus.java.basic.homework.number7;

public class Car implements Transport{
    private boolean isForestGo = false;
    private boolean isSwampGo = false;
    private boolean isPlainGo = true;
    private int fuel;

    public Car(int fuel) {
        this.fuel = fuel;
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
    public String getName() {
        return "машина";
    }

    @Override
    public boolean go(int distance, Area area, Human human) {
        if (area == Area.PLAIN && !isPlainGo()) {
            System.out.println("Машина не может проехать по равнине." );
            return false;
        }
        if (area == Area.FOREST && !isForestGo()) {
            System.out.println("Машина не может проехать по лесу." );
            return false;
        }
        if (area == Area.SWAMP && !isSwampGo()) {
            System.out.println("Машина не может проехать по болоту." );
            return false;
        }
        if (fuel < 5 * distance/100) {
            System.out.println("Машина не может проехать дистанцию " + distance + ". Не хватает бензина." );
            return false;
        }
        fuel -= 5 * distance/100;
        System.out.println("Человек проехал на машине дистанцию " + distance + ". Осталось бензина - " + getFuel() );
        return true;
    }


}
