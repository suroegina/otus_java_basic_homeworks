package otus.java.basic.homework;

import java.sql.SQLException;
import java.util.List;

public class InMemoryAuthenticatedProvider implements AuthenticatedProvider{
    private List<User> users;
    private Server server;

    public InMemoryAuthenticatedProvider(Server server) {
        this.server = server;
        try {
            UserServiceJDBC userServiceJDBC = new UserServiceJDBCImpl();
            System.out.println("userServiceJDBC.getAll() = " + userServiceJDBC.getAll());
            this.users = userServiceJDBC.getAll();
            for (User user : users) {
                System.out.println("Пользователь с ID = " + user.getId() + " является администратором?\n" +
                        userServiceJDBC.isAdmin(user.getUsername()));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize() {
        System.out.println("Инициализация InMemoryAuthenticatedProvider");
    }

    private String getUsernameByLoginAndPassword (String login, String password) {
        for (User u : users) {
            if (u.getUsername().equalsIgnoreCase(login) && u.getPassword().equals(password)) {
                return u.getUsername();
            }
        }
        return null;
    }

    @Override
    public boolean authenticate(ClientHandler clientHandler, String login, String password) {
        String authUsername = getUsernameByLoginAndPassword(login, password);
        if (authUsername == null) {
            clientHandler.sendMsg("Неверный логин/пароль.");
            return false;
        }
        if (server.isUsernameBusy(authUsername)) {
            clientHandler.sendMsg("Указанная учетная запись уже занята.");
            return false;
        }
        clientHandler.setUserName(authUsername);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/authok " + authUsername);
        return true;
    }

    private boolean isLoginAlreadyExists(String login) {
        for (User u: users) {
            if (u.getUsername().equalsIgnoreCase(login)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUsernameAlreadyExists(String username) {
        for (User u: users) {
            if (u.getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String username, String password, String email) throws SQLException {
        if (username.length() < 3 || password.length() < 3 ) {
            clientHandler.sendMsg("Пароль 3+ символа, имя пользователя 3+ символа");
            return false;
        }
        if (isLoginAlreadyExists(username)) {
            clientHandler.sendMsg("Указанный логин уже занят.");
            return false;
        }
        if (isUsernameAlreadyExists(username)) {
            clientHandler.sendMsg("Указанное имя пользователя уже занято.");
            return false;
        }
        UserServiceJDBC userServiceJDBC = new UserServiceJDBCImpl();
        userServiceJDBC.addUser(username, password, email);
        users = userServiceJDBC.getAll();
        clientHandler.setUserName(username);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/regok " + username);

        return true;
    }


    @Override
    public boolean kick(ClientHandler clientHandler, String username) throws SQLException {
        UserServiceJDBC userServiceJDBC = new UserServiceJDBCImpl();
        if (!userServiceJDBC.isAdmin(clientHandler.getUserName())) {
            clientHandler.sendMsg("Нет прав для выполнения такой команды.");
            return false;
        }
        if (isUsernameAlreadyExists(username)) {
            ClientHandler moveClient = server.findClientByUsername(username);
            moveClient.sendMsg("Администратор вас удалил из чата.");
            moveClient.disconnect();
            clientHandler.sendMsg("/kickok " + username);
            return true;
        }
        clientHandler.sendMsg("В чате нет пользователя с именем " + username);
        return false;

    }
}

