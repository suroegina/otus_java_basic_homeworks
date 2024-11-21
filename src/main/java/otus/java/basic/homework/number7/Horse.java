package otus.java.basic.homework.number7;

public class Horse implements Transport {
    private int endurance;
    private boolean status = true;

    @Override
    public boolean isStatus() {
        return status;
    }

    @Override
    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String getName() {
        return "лошадь";
    }

    public Horse(int endurance) {
        this.endurance = endurance;
    }

    public int getEndurance() {
        return endurance;
    }

    @Override
    public boolean go(int distance, Area area) {
        if (area == Area.PLAIN && !Area.PLAIN.isForHorse()) {
            System.out.println("Лошадь не может пройти по равнине." );
            return false;
        } else if (area == Area.FOREST && !Area.FOREST.isForHorse()) {
            System.out.println("Лошадь не может пройти по лесу." );
            return false;
        }else if (area == Area.SWAMP && !Area.SWAMP.isForHorse()) {
            System.out.println("Лошадь не может пройти по болоту." );
            return false;
        } else if (endurance < 0.4 * distance) {
            System.out.println("Лошадь не может пройти дистанцию " + distance + ". Не хватает сил." );
            return false;
        } else {
            endurance -= 0.4 * distance;
            System.out.println("Человек прокатился на лошади дистанцию " + distance + ". Осталось сил у лошади - " + getEndurance());
            return true;
        }

    }
}
