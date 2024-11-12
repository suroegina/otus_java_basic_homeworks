public class Cat  {
    private String name;
    private int appetite; // аппетит кота
    private boolean isHappy = false; // сытость кота

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

    public boolean feed(Plate plate) {
        if (plate.getCurrentFood() < appetite) {
            return false;
        }
        plate.setCurrentFood(plate.getCurrentFood() - appetite);
        isHappy = true;
        return true;
    }

    public int getAppetite() {
        return appetite;
    }
}
