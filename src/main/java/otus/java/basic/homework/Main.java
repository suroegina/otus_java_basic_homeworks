package otus.java.basic.homework;

public class Main {
    public static void main(String[] args) {
        System.out.println("Домашняя работа по теме Обобщенные классы");
        Box<Apple> boxApple = new Box<>();
        Box<Orange> boxOrange = new Box<>();

        boxOrange.addFruit(new Orange(0.5));
        boxOrange.addFruit(new Orange(0.7));
        boxApple.addFruit(new Apple(0.3));
        boxApple.addFruit(new Apple(0.2));

        System.out.println(boxApple.getFruitsList().toString());

        System.out.println("Вес коробки с апельсинами: " + boxOrange.weight());
        System.out.println("Вес коробки с яблоками: " + boxApple.weight());


        System.out.println("Вес коробки с яблоками совпадает с весом коробки с апельсном? " + (boxApple.compare(boxOrange)?"да":"нет"));

        Box<Apple> boxApple2 = new Box<>();
        Box<Orange> boxOrange2 = new Box<>();

        System.out.println("Переложим яблоки из одной коробки в другую:");
        System.out.println("БЫЛО");
        System.out.println("Коробка 1: " + boxApple.getFruitsList().toString() );
        System.out.println("Коробка 2: " + boxApple2.getFruitsList().toString() );
        boxApple.move(boxApple2);

        System.out.println("СТАЛО");
        System.out.println("Коробка 1: " + boxApple.getFruitsList().toString() );
        System.out.println("Коробка 2: " + boxApple2.getFruitsList().toString() );

        System.out.println("\nПереложим апельсины из одной коробки в другую:");
        System.out.println("БЫЛО");
        System.out.println("Коробка 1: " + boxOrange.getFruitsList().toString() );
        System.out.println("Коробка 2: " + boxOrange2.getFruitsList().toString() );
        boxOrange.move(boxOrange2);

        System.out.println("СТАЛО");
        System.out.println("Коробка 1: " + boxOrange.getFruitsList().toString() );
        System.out.println("Коробка 2: " + boxOrange2.getFruitsList().toString() );

        System.out.println("\nДобавим апельсин весом 0.7 в коробку 2.");
        boxOrange2.addFruit(new Orange(0.7));

        System.out.println("Вес коробки 2 с яблоками совпадает с весом коробки 2 с апельсном? " + (boxApple2.compare(boxOrange2)?"да":"нет"));




    }
}
