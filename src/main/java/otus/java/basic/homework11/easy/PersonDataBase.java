package otus.java.basic.homework11.easy;

import java.lang.reflect.Array;
import java.util.*;

public class PersonDataBase {
    HashMap<Long, Person> personList;

    public PersonDataBase(HashMap<Long, Person> person) {
        this.personList = person;
    }

    public Person findById(Long id) {
        return personList.get(id);
    }

    public void add(Person person) {
        personList.put(person.getId(), person);
    }

    public void printList() {
        System.out.println("Список сотрудников:");
        for (Person p: personList.values()) {
            System.out.println(p.getId() + " - " + p.getName() + " - " + p.getPosition());
        }
    }

    public boolean isManager(Person person) {
        TreeSet<Position> managers = new TreeSet<>();
        managers.add(Position.MANAGER);
        managers.add(Position.DIRECTOR);
        managers.add(Position.BRANCH_DIRECTOR);
        managers.add(Position.SENIOR_MANAGER);

        return managers.contains(person.getPosition());
    }

    public boolean isEmployee(Long id) {
        Person person = findById(id);
        return !isManager(person);
    }


}
