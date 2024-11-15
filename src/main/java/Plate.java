public class Plate {
    private int maxFood;
    private int currentFood = 0;

    public Plate(int maxFood) {
        this.maxFood = maxFood;
    }

    public int getCurrentFood() {
        return currentFood;
    }

    public void setCurrentFood(int currentFood) {
        this.currentFood = currentFood;
    }

    public int getMaxFood() {
        return maxFood;
    }

    public boolean addFood(int countFood) {
        if (currentFood + countFood > maxFood) {
            System.out.println("Нельзя положить столько еды. Нужно положить не более " + (maxFood - currentFood)+ " единиц еды.");
            return false;
        }
        currentFood += countFood;
        return true;
    }

}
