package client;

import util.ExampleClient;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try (Socket socket = new Socket("localhost", 8080)) {
                ExampleClient client = new ExampleClient(socket.getInputStream(), socket.getOutputStream());
                client.hello();
                client.hello();
                while (true) {
                    String userMessage = scanner.nextLine();
                    if (userMessage.equals("YES")) {
                        client.send(userMessage);
                        break;
                    } else if (userMessage.equals("NO")) {
                        break;
                    }
                    client.send(userMessage);
                }

            } catch (IOException e) {
                break;
            }
            //break;
        }
    }
}
