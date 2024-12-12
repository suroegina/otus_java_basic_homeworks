package server;

import util.ClientHandler;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);
        System.out.println("SERVER APPLICATION RUN!");
        while (true) {
            Socket client = socket.accept();
            DataInputStream inputStream = new DataInputStream(client.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(client.getOutputStream());
            System.out.println("Клиент с портом :" + client.getPort() + " подключился!");
            outputStream.writeUTF("Доступны математические операции: +, -, /, *.");
            int num1,num2;
            float result = 0.0f;
            String operation;

            while (true) {
                outputStream.writeUTF("Введите первое число: ");
                String userInput = inputStream.readUTF();
                try {
                    num1 = Integer.parseInt(userInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка! " + e.getMessage());
                }
            }
            while (true) {
                outputStream.writeUTF("Введите второе число: ");
                String userInput = inputStream.readUTF();
                try {
                    num2 = Integer.parseInt(userInput);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка! " + e.getMessage());
                }
            }
            while (true) {
                outputStream.writeUTF("Введите математическую операцию: +, -, /, *: ");
                String userInput = inputStream.readUTF();
                System.out.println(userInput);
                operation = userInput;
                if (userInput.equals("+") || userInput.equals("-") || userInput.equals("*") || userInput.equals("/")) {
                        switch (userInput) {
                            case "+":
                                result = num1 + num2;
                                break;
                            case "-":
                                result = num1 - num2;
                                break;
                            case "*":
                                result = num1 * num2;
                                break;
                            case "/":
                                try {
                                    result = (float) num1 / (float) num2;
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Ошибка!" + e.getMessage());
                                    continue;
                                }
                            default:
                                break;
                        }
                        break;
                    }
            }
            outputStream.writeUTF("Результат: " + num1 + operation + num2 + "=" + result + "\nНапишите 'y' чтобы продолжить, 'n' - выйти из приложения.");
            String userInput = inputStream.readUTF();
            if (userInput.equals("y")) {
                System.out.println("Клиент с портом :" + client.getPort() + " отключился!");
                client.close();
            } else {
                client.close();
                break;
            }

        }
    }

}
