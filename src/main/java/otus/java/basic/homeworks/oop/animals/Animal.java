package otus.java.basic.homeworks.oop.animals;

public class Animal {
    protected String name;
    protected float runSpeed;
    protected float swimSpeed;
    protected int endurance;
    protected int swimEndurance = 0;
    protected int runEndurance = 1;

    public Animal(String name, float swimSpeed, float runSpeed, int endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.swimSpeed = swimSpeed;
        this.endurance = endurance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float run(int distance) {
        if (runEndurance == 0) {return 0.0f;}
        if (endurance >= distance/runEndurance) {
            endurance -=  (int)distance/runEndurance;
            return distance/runSpeed;
        }
        endurance = 0;
        return -1.0f;
    }
    public float swim(int distance) {
        if (swimEndurance == 0) {return 0.0f;}
        if (endurance >= (int)distance/swimEndurance) {
            endurance -= (int)distance/swimEndurance;
            return distance/swimSpeed;
        }
        endurance = 0;
        return -1.0f;
    }

    public void info() {
        System.out.println("Имя: " + name);
        System.out.println("Скорость бега: " + runSpeed);
        System.out.println("Скорость плавания: " + swimSpeed);
        System.out.println("Выносливость на текущий момент: " +  endurance);
    }
}
