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
                for (Transport t:transports) {
                    System.out.println("\nНа текущий момент сил у человека: " + human.getEndurance());
                    if (!t.isStatus()) {
                        System.out.println("Транспорт: " + t.getName() + ". Статус: занят. Попробуем другой транспорт.");
                        continue;
                    }
                    System.out.println("Текущий транспорт: " + t.getName() + ". Статус: свободен.");
                    human.setCurrentTransport(t);
                    t.setStatus(false);
                    if (t.go(distance, area, human)) {
                        continue;
                    }
                    t.setStatus(true);
                }
                human.setCurrentTransport(null);
                if (human.go(distance, area)) {
                    continue;
                }
        }
        System.out.println("---------------------------------");
    }
}
