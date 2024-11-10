package otus.java.basic.oop.homework;

public class Box {
    private String size;
    private String color;
    private Boolean isOpened;
    private String item;

    public Box(String size, String color) {
        this.size = size;
        this.color = color;
        isOpened = false;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void open() {
        isOpened = true;
        System.out.println("Коробку открыли.");
    }

    public void close() {
        isOpened = false;
        System.out.println("Коробку закрыли.");
    }

    public void info() {
        System.out.println("Информация о коробке:");
        System.out.println("Размер коробки: " + size);
        System.out.println("Цвет коробки: " + color);
        System.out.println("В коробке лежит: " + item);
        if (isOpened) System.out.println("Коробка открыта."); else System.out.println("Коробка закрыта.");
    }

    public void putItem(String item) {
        if (isOpened && this.item == null) {
            this.item = item;
            System.out.println("Коробка открыта. В коробку положили предмет - " + item);
        } else {
            System.out.println("Коробка закрыта и/или заполнена. ");
        }
    }
    public void deleteItem() {
        if (isOpened) {
            System.out.println("Коробка закрыта. Из коробки не можем убрать предмет.");
            return;
        }
        if (item == null) {
            System.out.println("Коробка открыта. В коробке ничего нет.");
            return;
        }
        System.out.println("Коробка открыта. Из коробки убрали предмет - " + item);
        item = null;
    }

}
