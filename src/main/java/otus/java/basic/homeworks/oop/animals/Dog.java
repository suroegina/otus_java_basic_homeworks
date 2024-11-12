package otus.java.basic.homeworks.oop.animals;

public class Dog extends Animal {

    public Dog(String name, float swimSpeed, float runSpeed, int endurance) {
        super(name, swimSpeed, runSpeed, endurance);
        swimEndurance = 2;
    }

    @Override
    public void info() {
        System.out.println("Состояние собаки");
        System.out.println("Имя: " + name);
        System.out.println("Скорость бега: " + runSpeed);
        System.out.println("Скорость плавания: " + swimSpeed);
        System.out.println("Выносливость на текущий момент: " +  endurance);
        System.out.println();
    }
}
