package otus.java.basic.homework;

import java.util.ArrayList;

public class Homework9 {
    public static void main(String[] args) {
        System.out.println(getList(10, 15));
        System.out.println(getList(2, 5));
        System.out.println("----------------------");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(i);
        }
        System.out.println("Исходный список: " + list);
        System.out.println("Cумма всех элементов больше 5: " + getListSum(list));
        System.out.println("----------------------");
        System.out.println("Исходный список: " + list);
        replaceList(20, list);
        System.out.println("----------------------");
        list.clear();
        for (int i = 0; i < 8; i++) {
            list.add(i);
        }
        System.out.println("Исходный список: " + list);
        updateList(10, list);
        System.out.println("----------------------");
        ArrayList<Employee> employeesList = new ArrayList<>();
        employeesList.add(new Employee("Ivan", 30));
        employeesList.add(new Employee("Petr", 25));
        employeesList.add(new Employee("Anna", 27));
        employeesList.add(new Employee("Daria", 36));
        employeesList.add(new Employee("Natalia", 46));
        employeesList.add(new Employee("German", 40));
        System.out.println("Список имен сотрудников: " + getEmloyesName(employeesList));
        System.out.println("----------------------");
        ArrayList<Employee> employeesAgeList = getAgeEmployees(employeesList, 30);
        System.out.println("Список сотрудников c минимальным возрастом 30: ");
        printEmployees(employeesAgeList);
        System.out.println("----------------------");
        getAvgAgeEmployees(employeesList, 40);
        System.out.println("----------------------");
        System.out.println("Самый молодой сотрудник: ");
        Employee young = getYoungEmployees(employeesList);
        System.out.println(young.getData());
        System.out.println("----------------------");

    }

    public static ArrayList<Integer> getList(int min, int max) {
        ArrayList<Integer> newList = new ArrayList<>();
        if (min > max) {
            throw new IllegalArgumentException("min > max!");
        }
        for (int i = min; i < max + 1 ; i++) {
            newList.add(i);
        }
        System.out.println("Новый список из значений в диапазоне [" + min + ", " + max + "]: ");
        return newList;
    }

    public static int getListSum(ArrayList<Integer> inList) {
        int sum = 0;
        for (int i = 0; i < inList.size(); i++) {
            if (inList.get(i) > 5) {
                sum += inList.get(i);
            }
        }
        return sum;
    }

    public static void replaceList(int num, ArrayList<Integer> inList) {
        for (int i = 0; i < inList.size(); i++) {
            inList.set(i, num);
        }
        System.out.println("Новый список из значений " + num + ": " + inList);
    }

    public static void updateList(int num, ArrayList<Integer> inList) {
        for (int i = 0; i < inList.size(); i++) {
            inList.set(i, inList.get(i) + num);
        }
        System.out.println("Новый список из значений увеличенных на  " + num + ": " + inList);
    }

    public static ArrayList<String> getEmloyesName(ArrayList<Employee> employeesList) {
        ArrayList<String> employesNameList = new ArrayList<>();
        for (Employee employee : employeesList) {
            employesNameList.add(employee.getName());
        }
        return employesNameList;
    }

    public static ArrayList<Employee> getAgeEmployees(ArrayList<Employee> employeesList, int minAge) {
        ArrayList<Employee> employesAgeList = new ArrayList<>();
        for (Employee employee : employeesList) {
            if (employee.getAge() >= minAge) {
                employesAgeList.add(employee);
            }
        }
        return employesAgeList;
    }

    public static void printEmployees(ArrayList<Employee> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getData());
        }
    }
    public static void getAvgAgeEmployees(ArrayList<Employee> employeesList, int avgAge) {
        System.out.println("Список сотрудников старше среднего возраста " + avgAge + ":");
        ArrayList<Employee> employesAgeList = new ArrayList<>();
        for (Employee employee : employeesList) {
            if (employee.getAge() >= avgAge) {
                employesAgeList.add(employee);
            }
        }
        printEmployees(employesAgeList);
    }

    public static Employee getYoungEmployees(ArrayList<Employee> employeesList) {
        Employee youngEmployee = employeesList.get(0);
        for (int i = 1; i < employeesList.size(); i++) {
            if (employeesList.get(i).getAge() <= youngEmployee.getAge()) {
                youngEmployee = employeesList.get(i);
            }
        }
        return youngEmployee;
    }



}
