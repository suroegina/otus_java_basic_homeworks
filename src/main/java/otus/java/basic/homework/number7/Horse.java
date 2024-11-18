package otus.java.basic.homework.number7;

public class Horse implements Transport {
    private boolean isForestGo = true;
    private boolean isSwampGo = false;
    private boolean isPlainGo = true;
    private int endurance;

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
    public boolean isForestGo() {
        return isForestGo;
    }

    @Override
    public boolean isSwampGo() {
        return isSwampGo;
    }

    @Override
    public boolean isPlainGo() {
        return isPlainGo;
    }

    @Override
    public boolean isActive() {
        if (endurance > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean go(int distance, Area area, Human human) {
        if (area == Area.PLAIN && !isPlainGo()) {
            System.out.println("Лошадь не может пройти по равнине." );
            return false;
        }
        if (area == Area.FOREST && !isForestGo()) {
            System.out.println("Лошадь не может пройти по лесу." );
            return false;
        }
        if (area == Area.SWAMP && !isSwampGo()) {
            System.out.println("Лошадь не может пройти по болоту." );
            return false;
        }
        if (endurance < 3 * distance) {
            System.out.println("Лошадь не может пройти дистанцию " + distance + ". Не хватает сил." );
            return false;
        }
        endurance -= 3 * distance;
        System.out.println("Человек прокатился на лошади дистанцию " + distance + ". Осталось сил у лошади - " + getEndurance() );
        return true;

    }
}
