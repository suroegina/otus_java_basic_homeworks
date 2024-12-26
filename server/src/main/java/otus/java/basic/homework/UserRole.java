package otus.java.basic.homework;

public enum UserRole {
    ADMIN("АДМИН"),
    USER("ПОЛЬЗОВАТЕЛЬ");

    private String title;

    UserRole(String title) {
        this.title = title;
    }
}
