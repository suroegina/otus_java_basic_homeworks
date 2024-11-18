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
        System.out.println("---------------------------------");

        for (Area area : Area.values()) {
            System.out.println("Местность: " + area.getTitle());
            System.out.println();
                for (Transport t:transports) {
                    human.setCurrentTransport(t);
                    System.out.println("Текущий транспорт: " + human.getCurrentTransport(t));
                    if (t.go(distance, area, human)) {
                        System.out.println();
                        continue;
                    }
                    System.out.println();
                }
                System.out.println();
                if (human.go(distance)) {
                    continue;
                }
            System.out.println("-------------------------");
            }
        }


}
