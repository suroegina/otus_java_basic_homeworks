package otus.java.basic.oop.homework;
import java.time.Year;

public class User {
    private String fio;
    private int birthYear;
    private String email;

    public User(String fio, int birthYear, String email) {
        this.fio = fio;
        this.birthYear = birthYear;
        this.email = email;
    }

    public void info(){
        System.out.println("ФИО: " + fio);
        System.out.println("Год рождения: " + birthYear);
        System.out.println("e-mail: " + email);
    }
    public void getInfoOver40(){
        int currentYear = Year.now().getValue();
        if (currentYear - this.birthYear >= 40) {
            info();
            System.out.println();
        }
    }
}
