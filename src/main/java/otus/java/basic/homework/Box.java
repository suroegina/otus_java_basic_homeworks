package otus.java.basic.homework;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{
    private double weightBox;
    private List<T> fruitsList = new ArrayList<>();

    public double getWeight() {
        return weightBox;
    }

    public List<T> getFruitsList() {
        return fruitsList;
    }

    public void setFruitsList(List<T> fruitsList) {
        this.fruitsList.addAll(fruitsList);
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
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.00001;
    }

    public void move(Box<T> otherBox) {
        otherBox.setFruitsList(fruitsList);
        fruitsList.clear();
    }
}
