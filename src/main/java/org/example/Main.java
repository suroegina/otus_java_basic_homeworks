package org.example;

import otus.java.basic.homeworks.oop.animals.Animal;
import otus.java.basic.homeworks.oop.animals.Dog;
import otus.java.basic.homeworks.oop.animals.Cat;
import otus.java.basic.homeworks.oop.animals.Horse;

import java.util.Scanner;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the
public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[]{
            new Cat("Басик", 0, 10, 400),
            new Dog("Шурик", 3, 10, 500),
            new Horse("Вакула", 2, 20, 600)
        };
        System.out.println("Информация о животных:");
        for (Animal animal: animals) {
            animal.info();
        }
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Какое соревнование устроим: 1 - бег, 2 - плавние, N - не хочу соревнований? ");
            String userAnswer = scanner.nextLine();
            if (userAnswer.equals("1")) {
                runCompetition(scanner, animals);
            } else if (userAnswer.equals("2")) {
                swimCompetition(scanner, animals);
            } else if (userAnswer.equals("N")) {
                break;
            } else {
                System.out.println("Такого пункта нет в меню, попробуем снова");
                continue;
            }
            System.out.println();
            for (Animal a: animals) {
                a.info();
            }
        } while (true);
    }

    private static void swimCompetition(Scanner scanner, Animal[] animals) {
        float time;
        System.out.println("Укажите дистанцию в метрах: ");
        int distance = scanner.nextInt();
        for (Animal a: animals) {
            time = a.swim(distance);
            if (time == -1.0f) {
                System.out.println("Животное по имени " + a.getName() + " устало. Спасаем его!");
            } else if (time == 0.0f) {
                System.out.println("Животное по имени " + a.getName() + " не может поплыть. Пожалеем!");
            } else {
                System.out.println("Животное по имени " + a.getName() + " проплыло за " + time + " секунд");
            }
        }
    }

    private static void runCompetition(Scanner scanner, Animal[] animals) {
        float time;
        System.out.println("Укажите дистанцию в метрах: ");
        int distance = scanner.nextInt();
        for (Animal animal: animals) {
            time = animal.run(distance);
            if (time == -1.0f) {
                System.out.println("Животное по имени " + animal.getName() + " устало. Спасаем его!");
            } else if (time == 0.0f) {
                System.out.println("Животное по имени " + animal.getName() + " не может побежать. Пожалеем!");
            } else {
                System.out.println("Животное по имени " + animal.getName() + " пробежало за " + time + " секунд");
            }
        }
    }

}