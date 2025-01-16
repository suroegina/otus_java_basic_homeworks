package otus.java.basic.homework;

import java.util.List;

public interface UserServiceJDBC {
    List<User> getAll();
    boolean isAdmin(String username);
    void addUser(String username, String password, String email);
}
