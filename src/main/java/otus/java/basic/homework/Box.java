package otus.java.basic.homework;

import java.util.ArrayList;

public class Box <T extends Fruit>{
    private double weightBox;
    private ArrayList<T> fruitsList = new ArrayList<>();

    public double getWeight() {
        return weightBox;
    }

    public ArrayList<T> getFruitsList() {
        return fruitsList;
    }

    public void setFruitsList(ArrayList<T> fruitsList) {
        this.fruitsList = fruitsList;
    }

    public void addFruit(T fruit) {
        fruitsList.add(fruit);
    }

    public double weight() {
        double sum = 0.0;
        for (T fruits: fruitsList) {
            sum += fruits.getWeight();
        }
        weightBox = sum;
        return sum;
    }

    public boolean compare(Box<?> otherBox) {
        return this.getWeight() == otherBox.getWeight();
    }

    public void move(Box<T> otherBox) {
        otherBox.setFruitsList(fruitsList);
        fruitsList = new ArrayList<>();
    }
}
