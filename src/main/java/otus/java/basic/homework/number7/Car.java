package otus.java.basic.homework.number7;

public class Car implements Transport{
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

    public Car(int fuel) {
        this.fuel = fuel;
    }

    public int getFuel() {
        return fuel;
    }


    @Override
    public String getName() {
        return "машина";
    }

    @Override
    public boolean go(int distance, Area area) {
        if (area == Area.PLAIN && !Area.PLAIN.isForCar()) {
            System.out.println("Машина не может проехать по равнине." );
            return false;
        }
        if (area == Area.FOREST && !Area.FOREST.isForCar()) {
            System.out.println("Машина не может проехать по лесу." );
            return false;
        }
        if (area == Area.SWAMP && !Area.SWAMP.isForCar()) {
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
