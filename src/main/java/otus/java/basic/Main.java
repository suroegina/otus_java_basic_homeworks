package otus.java.basic;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayUtils arrayUtils = new ArrayUtils();
        int[] arr1 = {1,2,1,2,2};
        int[] arr2 = arrayUtils.getArrayAfterOne(arr1);
        System.out.println(Arrays.toString(arr2));


        int[] arr5 = {1,2};
        int[] arr6 = {1,1};
        int[] arr7 = {1,3};
        int[] arr8 = {1,2,2,1};
        System.out.println(arrayUtils.arrayContainsOneTwo(arr5));
        System.out.println(arrayUtils.arrayContainsOneTwo(arr6));
        System.out.println(arrayUtils.arrayContainsOneTwo(arr7));
        System.out.println(arrayUtils.arrayContainsOneTwo(arr8));




    }



}
