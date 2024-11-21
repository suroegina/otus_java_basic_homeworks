package otus.java.basic.homework.number7;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Human human = new Human("Bob");

        Transport[] transports =  {
                new Bike(),
                new Car(100),
                new Horse(200),
                new Rover(100)
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Человеку по имени "+ human.getName()+ " надо добраться домой с работы.");
        System.out.print("Введите дистанцию в километрах:");
        int distance = scanner.nextInt();

        for (Area area : Area.values()) {
            System.out.println("---------------------------------");
            System.out.println("Местность: " + area.getTitle());
            System.out.println();
                for (Transport t:transports) {
                    System.out.println("На текущий момент сил у человека: " + human.getEndurance());
                    if (!t.isStatus()) {
                        System.out.println("Транспорт: " + t.getName() + ". Статус: занят. Попробуем другой транспорт.");
                        System.out.println();
                        continue;
                    }
                    System.out.println("Текущий транспорт: " + t.getName() + ". Статус: свободен.");
                    human.setCurrentTransport(t);
                    t.setStatus(false);
                    if (t.go(distance, area)) {
                        if (!human.getActive(distance)) {
                            continue;
                        }
                    }
                    t.setStatus(true);
                    System.out.println();
                }
                human.setCurrentTransport(null);
                if (human.go(distance, area)) {
                    continue;
                }
            System.out.println();
        }
        System.out.println("---------------------------------");
    }
}
