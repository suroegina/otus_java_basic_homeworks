package otus.java.basic.homework.number7;

public class Bike implements Transport{
    private boolean isForestGo = true;
    private boolean isSwampGo = false;
    private boolean isPlainGo = true;

    @Override
    public String getName() {
        return "велосипед";
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
        return true;
    }

    @Override
    public boolean go(int distance, Area area, Human human) {
        if (area == Area.PLAIN && !isPlainGo()) {
            System.out.println("Велосипед не может проехать по равнине." );
            return false;
        }
        if (area == Area.FOREST && !isForestGo()) {
            System.out.println("Велосипед не может проехать по лесу." );
            return false;
        }
        if (area == Area.SWAMP && !isSwampGo()) {
            System.out.println("Велосипед не может проехать по болоту." );
            return false;
        }
        if (human.getEndurance() < (int)distance*0.4) {
            System.out.println("Человек не может проехать на велосипеде. Не хватает сил." );
            return false;
        }

        int endurance = human.getEndurance();
        endurance -= (int)distance*0.4;
        human.setEndurance(endurance);
        System.out.println("Человек проехал на велосипеде дистанцию " + distance + ". Осталось сил у человека: " + human.getEndurance());
        return true;
    }
}
