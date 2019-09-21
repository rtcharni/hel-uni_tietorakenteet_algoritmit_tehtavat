package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();

	    int size = 100000;
        int[] arr = new int[size];

        ArrayList list = new ArrayList<Integer>();

        long alku = System.nanoTime();

        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < size; i++) {
            int a = arr[i];
        }

        long loppu = System.nanoTime();
        System.out.println("Array 100000 write & read: " + ((loppu-alku)/1e6)+" MS");

        long alku1 = System.nanoTime();

        list.add(0);
        for (int i = 1; i < size; i++) {
            list.set(i, i);
        }
        for (int i = 0; i < size; i++) {
            list.get(i);
        }

        long loppu1 = System.nanoTime();
        System.out.println("ArrayList 100000 write & read: " + ((loppu1-alku1)/1e6)+" MS");
    }
}
