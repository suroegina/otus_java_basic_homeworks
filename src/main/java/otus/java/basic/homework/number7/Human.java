package otus.java.basic.homework.number7;

public class Human{
    final String name;
    public Transport currentTransport;
    private int endurance = 100;

    public Human(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCurrentTransport(Transport transport) {
        this.currentTransport = transport;
    }

    public String getCurrentTransport(Transport transport) {
        return transport.getName();
    }

    public int getEndurance() {
        return endurance;
    }

    public void setEndurance(int endurance) {
        this.endurance = endurance;
    }

    public boolean humanAble(int distance, float precent) {
        if (endurance < (int)(distance * precent)) {
            System.out.println("Человек не осилит дистанцию " + distance + "." );
            return false;
        }
        lowEndurance(distance, precent);
        System.out.println("Человек осилил дистанцию " + distance + ". Осталось сил у человека: " + endurance );
        return true;
    }

    public boolean go(int distance, Area area) {
        System.out.println("На текущий момент сил у человека: " + getEndurance());
        if (area == Area.SWAMP) {
            return humanAble(distance, 0.8f);
        } else if (area == Area.FOREST) {
            return humanAble(distance, 0.5f);
        } else {
            return humanAble(distance, 0.3f);
        }
    }

    public void lowEndurance(int distance, float precent) {
        endurance -= (int)distance*precent;
        setEndurance(endurance);
    }





}
