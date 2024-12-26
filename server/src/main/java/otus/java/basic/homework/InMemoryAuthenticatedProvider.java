package otus.java.basic.homework;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class InMemoryAuthenticatedProvider implements AuthenticatedProvider{

    private class User {
        private String login;
        private String password;
        private String username;
        private UserRole role;

        public User(String login, String password, String username, UserRole role) {
            this.login = login;
            this.password = password;
            this.username = username;
            this.role = role;
        }

        public UserRole getRole() {
            return role;
        }
    }

    private List<User> users;
    private Server server;

    public InMemoryAuthenticatedProvider(Server server) {
        this.server = server;
        this.users = new CopyOnWriteArrayList<User>();
        users.add(new User("user1","user1", "username1", UserRole.USER));
        users.add(new User("user2","user2", "username2", UserRole.USER));
        users.add(new User("user3","user3", "username3", UserRole.USER));
        users.add(new User("admin1","admin1", "administrator1", UserRole.ADMIN));
        users.add(new User("admin2","admin2", "administrator2", UserRole.ADMIN));



    }

    @Override
    public void initialize() {
        System.out.println("Инициализация InMemoryAuthenticatedProvider");
    }

    private String getUsernameByLoginAndPassword (String login, String password) {
        for (User u : users) {
            if (u.login.equalsIgnoreCase(login) && u.password.equals(password)) {
                return u.username;
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
            if (u.login.equalsIgnoreCase(login)) {
                return true;
            }
        }
        return false;
    }

    private boolean isUsernameAlreadyExists(String username) {
        for (User u: users) {
            if (u.username.equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean registration(ClientHandler clientHandler, String login, String password, String username) {
        // /reg login password username
        if (login.length() < 3 || password.length() < 3 || username.length() < 3 ) {
            clientHandler.sendMsg("Логин 3+ символа, пароль 3+ символа, имя пользователя 3+ символа");
            return false;
        }
        if (isLoginAlreadyExists(login)) {
            clientHandler.sendMsg("Указанный логин уже занят.");
            return false;
        }
        if (isUsernameAlreadyExists(username)) {
            clientHandler.sendMsg("Указанное имя пользователя уже занято.");
            return false;
        }

        users.add(new User(login, password, username, UserRole.USER));
        clientHandler.setUserName(username);
        server.subscribe(clientHandler);
        clientHandler.sendMsg("/regok " + username);

        return true;
    }

    private boolean isAdmin(ClientHandler clientHandler) {
        for (User u : users) {
            if (u.username.equalsIgnoreCase(clientHandler.getUserName()) && u.role == UserRole.ADMIN ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean kick(ClientHandler clientHandler, String username) {
        if (!isAdmin(clientHandler)) {
            clientHandler.sendMsg("Нет прав для выполнения такой команды.");
            return false;
        }
        if (isUsernameAlreadyExists(username)) {
            ClientHandler moveClient = server.findClientByUsername(username);
            moveClient.sendMsg("Администратор вас удалил из чата.");
            moveClient.disconnect();
            //server.unsubscribe(moveClient);
            clientHandler.sendMsg("/kickok " + username);
            return true;
        }
        clientHandler.sendMsg("В чате нет пользователя с именем " + username);
        return false;

    }
}

