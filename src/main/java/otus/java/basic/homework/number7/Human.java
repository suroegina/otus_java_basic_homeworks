package otus.java.basic.homework.number7;

public class Human{
    private String name;
    private Transport currentTransport;
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

    public boolean go(int distance) {
        if ( distance > (int)(endurance * 0.6)) {
            System.out.println("Человек не осилит дистанцию " + distance + " пешком." );
            return false;
        }
        endurance -= (int)distance*0.2;
        System.out.println("Человек прошел дистанцию " + distance + ". Осталось сил у человека: " + endurance );
        return true;
    }

}
