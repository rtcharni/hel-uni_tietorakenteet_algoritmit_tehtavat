package com.company;

import java.util.HashSet;
import java.util.Random;

public class Main {

    static Random random = new Random(1337);
    static HashSet<Integer> set = new HashSet<>();
    static int[] arr = new int[100000002];

    public static void main(String[] args) {

	    generateNumbers(100000000);

	    calculateSet(set);
	    calculateArr(arr);
    }

    static void generateNumbers(int num) {
        int randInt = random.nextInt(num) + 1;
        set.add(randInt);
        arr[randInt] = 1;
    }

    static void calculateSet(HashSet<Integer> set) {
        long alku = System.nanoTime();
        long tulos = set.size();
        long loppu = System.nanoTime();
        System.out.println("SET SIZE");
        System.out.println("Algoritmin tulos: "+tulos);
        System.out.println("Aikaa kului "+((loppu-alku)/1e9)+" s");
        System.out.println();
    }

    static void calculateArr(int[] arr) {
        long alku = System.nanoTime();
        long tulos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                tulos++;
            }
        }
        long loppu = System.nanoTime();
        System.out.println("ARRAY LOOP");
        System.out.println("Algoritmin tulos: "+tulos);
        System.out.println("Aikaa kului "+((loppu-alku)/1e9)+" s");
        System.out.println();
    }
}
