package otus.java.basic.oop.homework;

import java.util.Scanner;

public class Homework4 {
    public static void main(String[] args) {
        User[] users = {
                new User("Иванов Иван Иваночич", 1985, "ivanov@ya.ru"),
                new User("Петров Петр Петрович", 1980, "petrov@ya.ru"),
                new User("Семенов Семен Семенович", 1982, "semenov@ya.ru"),
                new User("Иванова Мария Ивановна", 1990, "ivanova@ya.ru"),
                new User("Титов Михаил Семенович", 1970, "titov@ya.ru"),
                new User("Попов Денис Петрович", 1987, "popov@ya.ru"),
                new User("Суслин Василий Романович", 1988, "suslin@ya.ru"),
                new User("Колоколова Анна Петровна", 1978, "kolokolova@ya.ru"),
                new User("Орлова Ирина Олеговна", 1977, "orlova@ya.ru"),
                new User("Писаренко Роман Петрович", 1989, "pisarenko@ya.ru"),
        };
        System.out.println("Пользователи старше 40 лет:");
        for (User u: users) {
            u.getInfoOver40();
        }
        System.out.println("------------------------------------");
        Box box = new Box("M", "YELLOW");
        System.out.println("Информация о коробке:");
        box.info();
        System.out.println("Покрасим короьбку в зеленый цвет.");
        box.setColor("GREEN");
        box.info();

        do {
            System.out.println("Открыть или закрыть коробку? Y - открыть, N - закрыть");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if (answer.equals("Y")) box.open(); else box.close();
            System.out.println("Положим в коробку книгу.");
            box.putItem("book");
            box.info();
            System.out.println("Выйти из программы? Y - да, N - нет");
            String answerExit = scanner.nextLine();
            if (answerExit.equals("Y")) break;
        } while (true);



    }
}
