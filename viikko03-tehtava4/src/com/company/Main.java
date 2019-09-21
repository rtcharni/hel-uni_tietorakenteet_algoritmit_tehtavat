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
            int ran = random.nextInt();
            test[i] = ran;
            test1[i] = ran;
        }

        long start = System.nanoTime();
        Main.sortOwn(test, 0, test.length - 1);
        long end = System.nanoTime();
        System.out.println("OWN SORT - Aikaa kului: "+ ((end-start)/1000000000)+" sek");

        long start1 = System.nanoTime();
        Arrays.sort(test1);
        long end1 = System.nanoTime();
        System.out.println("JAVA SORT - Aikaa kului: "+((end1-start1)/1000000000)+" sek");

    }

    public static void sortOwn(int[] arr, int a, int b) {
        if (b <= a) {
            return;
        }

        int k = (a+b) / 2;
        sortOwn(arr, a, k);
        sortOwn(arr, k+1, b);
        Main.mergeOwn(arr, a, k, b);
    }

    public static void mergeOwn(int[] arr, int a, int k, int b) {
        int a1 = k - a + 1;
        int b1 = b - k;
        int a1arr[] = new int [a1];
        int b1arr[] = new int [b1];

        for (int i = 0; i < a1; i++) {
            a1arr[i] = arr[a+i];
        }

        for (int i = 0; i < b1; i++) {
            b1arr[i] = arr[k+i+1];
        }
        int l = 0;
        int r = 0;

        for (int i = a; i < b + 1; i++) {
            if (l < a1 && r < b1) {
                if (a1arr[l] < b1arr[r]) {
                    arr[i] = a1arr[l];
                    l++;
                } else {
                    arr[i] = b1arr[r];
                    r++;
                }
            } else if (l < a1) {
                arr[i] = a1arr[l];
                l++;
            } else if (r < b1) {
                arr[i] = b1arr[r];
                r++;
            }
        }
    }
}
