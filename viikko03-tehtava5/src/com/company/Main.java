package com.company;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int size = 100000000;
        Random random = new Random();

        int[] test = new int[size];
        int[] test1 = new int[size];

        for (int i = 0; i < size; i++) {
            int ran = random.nextInt(100000);
            test[i] = ran;
            test1[i] = ran;
        }

        long start = System.nanoTime();
        Main.sortOwn(test);
        long end = System.nanoTime();
        System.out.println("OWN SORT - Aikaa kului: "+ ((end-start)/1000000)+" millisek");

        long start1 = System.nanoTime();
        Arrays.sort(test1);
        long end1 = System.nanoTime();
        System.out.println("JAVA SORT - Aikaa kului: "+((end1-start1)/1000000)+" millisek");

    }

    public static void sortOwn(int[] arr) {
        int maxNum = 100000;
        int[] helper = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            helper[arr[i]] += 1;
        }

        int i = 0;
        for (int j = 0; j < maxNum; j++) {
            for (int k = 1; k < helper[j]; k++) {
                arr[i] = j;
                i++;
            }
        }
    }
}

