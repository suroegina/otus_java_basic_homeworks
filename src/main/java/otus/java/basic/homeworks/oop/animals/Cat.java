package otus.java.basic.homeworks.oop.animals;

public class Cat extends Animal {

    public Cat(String name, float swimSpeed, float runSpeed, int endurance) {
        super(name, swimSpeed, runSpeed, endurance);
        swimEndurance = 0;
    }

    @Override
    public void info() {
        System.out.println("Состояние кота");
        System.out.println("Имя: " + name);
        System.out.println("Скорость бега (м/с): " + runSpeed);
        System.out.println("Скорость плавания (м/с): " + swimSpeed);
        System.out.println("Выносливость на текущий момент (ед.): " +  endurance);
        System.out.println();
    }
}
