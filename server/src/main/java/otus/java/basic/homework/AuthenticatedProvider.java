package otus.java.basic.homework;

import java.sql.SQLException;

public interface AuthenticatedProvider {
    void initialize();
    boolean authenticate(ClientHandler clientHandler, String login, String password);
    boolean registration(ClientHandler clientHandler, String username, String password, String email) throws SQLException;
    boolean kick(ClientHandler clientHandler, String username) throws SQLException;

}

