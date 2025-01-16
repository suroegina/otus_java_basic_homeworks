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

        System.out.println("Коробка с яблоками: " + boxApple.getFruitsList().toString());
        System.out.println("Коробка с апельсинами: " + boxOrange.getFruitsList().toString());

        System.out.println("Вес коробки с яблоками: " + boxApple.getWeight());
        System.out.println("Вес коробки с апельсинами: " + boxOrange.getWeight());

        System.out.println("\nВес коробки с яблоками совпадает с весом коробки с апельсном? " + (boxApple.compare(boxOrange)?"да":"нет"));

        Box<Apple> boxApple2 = new Box<>();
        Box<Orange> boxOrange2 = new Box<>();

        System.out.println("\nПереложим яблоки из одной коробки в другую:");
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

        System.out.println("\nДобавим яблоко весом 0.7 в коробку 2.");
        boxApple2.addFruit(new Apple(0.7));
        System.out.println("Вес коробки 2 с яблоками: " + boxApple2.getWeight());
        System.out.println("Вес коробки 2 с апельсинами: " + boxOrange2.getWeight());

        System.out.println("\nВес коробки 2 с яблоками совпадает с весом коробки 2 с апельсном? " + (boxApple2.compare(boxOrange2)?"да":"нет"));

        System.out.println("\nДобавим третью коробку с апельсинами и добавим 3 апельсина весом 0.1, 0.2, 0.3");
        Box<Orange> boxOrange3 = new Box<>();
        boxOrange3.addFruit(new Orange(0.1));
        boxOrange3.addFruit(new Orange(0.2));
        boxOrange3.addFruit(new Orange(0.3));

        System.out.println("\nПереложим фрукты из 2 коробки в 3 коробку апельсины:");
        System.out.println("БЫЛО");
        System.out.println("Коробка 2: " + boxOrange2.getFruitsList().toString() );
        System.out.println("Коробка 3: " + boxOrange3.getFruitsList().toString() );
        boxOrange2.move(boxOrange3);

        System.out.println("СТАЛО");
        System.out.println("Коробка 2: " + boxOrange2.getFruitsList().toString() );
        System.out.println("Коробка 3: " + boxOrange3.getFruitsList().toString() );





    }
}
