package otus.java.basic.homework20;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Домашнее задание: Работа с чтением/записью файлов");
        System.out.println("\nВведите имя файла: ");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
            System.out.println("\nОпределим сколько раз в файле встречается искомая последовательность символовю.\nВведите последовательность символов: ");
            String chars = scanner.nextLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int index = line.indexOf(chars);
                while (index != -1) {
                    count += 1;
                    try {
                        index = line.indexOf(chars, index + chars.length());
                    } catch (StringIndexOutOfBoundsException e) {
                        break;
                    }
                }
            }
            System.out.println("В содержимом файла слово '" + chars + "' повторяется " + count + " раз.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
