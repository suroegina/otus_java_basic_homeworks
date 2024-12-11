package otus.java.basic.homework11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File folder = new File("src/main/resources/");
        System.out.println("Список файлов:");
        for (File file : folder.listFiles()) {
            System.out.println(file.getName());
        }
        System.out.println("\nВведите имя файла, с которым будем работать: ");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String fileName = scanner.nextLine();
            boolean isFileExists = false;
            for (File file : folder.listFiles()) {
                if (file.getName().toString().equals(fileName)) {
                    isFileExists = true;
                    break;
                }
            }
            if (isFileExists) {
                System.out.println("\nТакой файл есть в списке. Его содержимое:");
                readFile(fileName);
                System.out.println("\nДавайте запишем в файл что-то. Напишите любой текст:");
                String text = scanner.nextLine();
                writeInFile(fileName, "\n" + text);
                System.out.println("\nФайл обновлен. Давайте проверим содержимое:");
                readFile(fileName);
                break;
            } else {
                System.out.println("Такого файла нет в списке. Попробуем снова?");
            }
        }



    }
    private static void readFile(String fileName) {
        try (FileInputStream in = new FileInputStream("src/main/resources/" +fileName )) {
            byte[] buf = new byte[128];
            int n = in.read(buf);
            while (n > 0) {
                System.out.print(new String(buf, 0, n));
                n = in.read(buf);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeInFile(String fileName, String text) {
        try (FileOutputStream out = new FileOutputStream("src/main/resources/" +fileName, true)) {
            byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
            out.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
