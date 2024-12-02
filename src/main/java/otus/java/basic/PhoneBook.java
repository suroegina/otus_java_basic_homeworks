package otus.java.basic;


import java.util.*;

public class PhoneBook {
    Map<String, String> phoneBookMap = new HashMap<>();

    public void add(String name, String phoneNumber) {
        phoneBookMap.put(phoneNumber, name);
    }

    public void toPrint() {
        System.out.println("Телефонный справочник: ");
        for (Map.Entry<String, String> entry : phoneBookMap.entrySet()) {
            System.out.println("Name=" + entry.getValue() + ", Phone=" + entry.getKey());
        }
        System.out.println("\n");
    }

    public void find(String name) {
        if (!phoneBookMap.containsValue(name)) {
            System.out.println("Имени " + name + " нет в телефонном справочнике.\n");
            return;
        }
        System.out.println("Список телефонов у " + name + ": ");
        for (Map.Entry<String, String> entry : phoneBookMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (name.equals(value)) {
                System.out.println(key);
            }
        }
        System.out.println("\n");
    }

    public void containsPhoneNumber(String phoneNumber) {
        if (phoneBookMap.containsKey(phoneNumber)) {
            System.out.println("Номер " + phoneNumber + " есть в телефонном справочнике \n");
        } else {
            System.out.println("Номер " + phoneNumber + " отсутствует в телефонном справочнике\n");
        }
    }


}
