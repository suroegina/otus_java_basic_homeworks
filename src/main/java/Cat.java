public class Cat  {
    private String name;
    private int appetite;
    private boolean isHappy = false;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void info() {
        if (isHappy) {
            System.out.println(name + " сыт.");
        } else {
            System.out.println(name + " голоден.");
        }
    }

    public void feed(Plate plate) {
        if (plate.getCurrentFood() < appetite || isHappy) {
            return;
        }
        plate.setCurrentFood(plate.getCurrentFood() - appetite);
        isHappy = true;
    }
}
