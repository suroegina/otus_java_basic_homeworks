package otus.java.basic;

import java.util.Arrays;

public class ArrayUtils {
    public int[] getArrayAfterOne(int[] array) {
        int lastPosOne = -1;
        int[] newArray;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                lastPosOne = i;
            }
        }
        if (lastPosOne != -1) {
            return Arrays.copyOfRange(array, lastPosOne + 1, array.length);
        } else {
            throw new RuntimeException();
        }
    }

    public boolean arrayContainsOneTwo(int[] array) {
        int countOne = 0;
        int countTwo = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                countOne++;
            } else if (array[i] == 2) {
                countTwo++;
            }
        }
        if (countOne + countTwo == array.length && countOne != 0 && countTwo != 0) {
            return true;
        }
        return false;
    }
}
