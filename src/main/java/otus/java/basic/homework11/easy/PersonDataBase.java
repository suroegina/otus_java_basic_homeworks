package otus.java.basic.homework11.easy;

import java.util.ArrayList;

public class PersonDataBase {
    ArrayList<Person> personList;

    public PersonDataBase(ArrayList<Person> person) {
        this.personList = person;
    }

    public Person findById(Long id) {
        for (Person p: personList) {
            if (p.getId().longValue() == id.longValue()) {
                System.out.println("Найден сотрудник c id " + p.getId() + " - " + p.getName());
                return p;
            }
        }
        System.out.println("Такого сотрудника нет в списке с id " + id);
        return null;
    }

    public void add(Person person) {
        personList.add(person);
    }

    public void printList() {
        for (Person p: personList) {
            System.out.println(p.getId() + " - " + p.getName());
        }
    }

    public boolean isManager(Person person) {
        return person.getPosition() == Position.MANAGER ||
                person.getPosition() == Position.DIRECTOR ||
                person.getPosition() == Position.BRANCH_DIRECTOR ||
                person.getPosition() == Position.SENIOR_MANAGER;
    }

    public boolean isEmployee(Long id) {
        Person person = findById(id);
        return !isManager(person);
    }


}
