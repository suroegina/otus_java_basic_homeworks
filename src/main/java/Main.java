import java.util.Scanner;

public class Main {
//    Описание/Пошаговая инструкция выполнения домашнего задания:
//    Реализуйте классы Тарелка (максимальное количество еды, текущее количество еды) и Кот (имя, аппетит). Количество еды измеряем в условных единицах.
//    При создании тарелки указывается ее объем и она полностью заполняется едой
//    В тарелке должен быть метод, позволяющий добавить еду в тарелку. После добавления в тарелке не может оказаться еды больше максимума
//    В тарелке должен быть boolean метод уменьшения количества еды, при этом после такого уменьшения, в тарелке не может оказаться отрицательное количество еды (если удалось уменьшить еду так, чтобы в тарелке осталось >= 0 кусков еды, то возвращаем true, в противном случае - false).
//    Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
//    Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
//    Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.

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
            Scanner scanner = new Scanner(System.in);
            String userAnswer = scanner.nextLine();
            if (userAnswer.equals("Y")) {
                putFood(plate);
                for (Cat cat: cats) {
                    if (!cat.feed(plate)) {break;}
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
            Scanner scanner = new Scanner(System.in);
            System.out.println("На тарелку нужно положить не болеее " + plate.getMaxFood() + " единиц еды. Сколько положим?");
            int foodCount = scanner.nextInt();
            if (plate.addFood(foodCount)) break; else continue;
        } while (true);
    }
}
