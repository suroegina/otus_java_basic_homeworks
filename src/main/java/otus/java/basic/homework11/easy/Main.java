package otus.java.basic.homework11.easy;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        PersonDataBase personDataBase = new PersonDataBase(new HashMap<>());
        Person[] persons = {
                new Person("Ivan", Position.DEVELOPER, 1L),
                new Person("Daria", Position.ENGINEER, 2L),
                new Person("Maria", Position.MANAGER, 3L),
                new Person("Petr", Position.DIRECTOR, 4L),
                new Person("German", Position.JUNIOR_DEVELOPER,5L)

        };
        for (Person p: persons) {
            personDataBase.add(p);
        }
        personDataBase.printList();
        System.out.println("----------------------------");
        printFounded(personDataBase.findById(5L));
        printFounded(personDataBase.findById(10L));

        System.out.println(personDataBase.isManager(personDataBase.findById(2L)) ?"Сотрудник - менеджер":"Сотрудник не менеджер");
        System.out.println(personDataBase.isEmployee(3L)?"Обычный сотрудник":"Менеджер" );


    }

    public static void printFounded(Person person) {
        if (person != null) {
            System.out.println("Сотрудник с ид " + person.getId() + " найден");
        } else {
            System.out.println("Сотрудник не найден");
        }
    }

}
