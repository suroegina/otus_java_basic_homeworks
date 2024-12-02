package otus.java.basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Homework10 {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivan", "89268888810");
        phoneBook.add("Daria", "89268888899");
        phoneBook.add("Daria", "89268888822");
        phoneBook.toPrint();
        phoneBook.find("Daria");
        phoneBook.find("Maria");

        phoneBook.containsPhoneNumber("66666666");
        phoneBook.containsPhoneNumber("89268888822");


    }



}
