import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Cat[] cats = new Cat[]{
                new Cat("Basik", 30),
                new Cat("Murzik", 20),
                new Cat("Rock", 15),
                new Cat("Marusya", 25),
                new Cat("Tobik", 35)
        };

        for (Cat cat: cats) {
            cat.info();
        }
        Plate plate = new Plate(130);
        do {
            System.out.println("Покормим котов? Y - да, N - нет, X - выйти из программы");
            String userAnswer = scanner.nextLine();
            if (userAnswer.equals("Y")) {
                putFood(plate);
                for (Cat cat: cats) {
                    cat.feed(plate);
                }
                break;
            } else if (userAnswer.equals("N")) {
                System.out.println("Котов не стали кормить :-(");
                continue;
            } else if (userAnswer.equals("X")) {
                break;
            } else {
                System.out.println("Такого пункта нет в меню, попробуем снова.");
                continue;
            }
        } while (true);
        System.out.println();
        for (Cat cat: cats) {
            cat.info();
        }
        System.out.println("На тарелке осталось " + plate.getCurrentFood() + " единиц еды.");
    }

    public static void putFood(Plate plate) {
        do {
            System.out.println("На тарелку нужно положить не болеее " + plate.getMaxFood() + " единиц еды. Сколько положим?");
            int foodCount = scanner.nextInt();
            if (plate.addFood(foodCount)) break; else continue;
        } while (true);
    }
}
