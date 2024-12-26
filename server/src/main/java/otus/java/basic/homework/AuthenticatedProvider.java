package otus.java.basic.homework;

public interface AuthenticatedProvider {
    void initialize();
    boolean authenticate(ClientHandler clientHandler, String login, String password);
    boolean registration(ClientHandler clientHandler, String login, String password, String username);
    boolean kick(ClientHandler clientHandler, String username);

}

