package otus.java.basic.homework.number7;

public class Horse implements Transport {
    private int endurance;
    private boolean status = true;
    final boolean isPlainEnable = true;
    final boolean isForestEnable = true;
    final boolean isSwampEnable = false;
    final TransportTitle title = TransportTitle.HORSE;

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
        return title.getTitle();
    }

    public Horse(int endurance) {
        this.endurance = endurance;
    }

    public int getEndurance() {
        return endurance;
    }

    @Override
    public boolean go(int distance, Area area, Human driver) {
        if (area == Area.PLAIN && !isPlainEnable) {
            System.out.println("Лошадь не может пройти по равнине." );
            return false;
        } else if (area == Area.FOREST && !isForestEnable) {
            System.out.println("Лошадь не может пройти по лесу." );
            return false;
        }else if (area == Area.SWAMP && !isSwampEnable) {
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
