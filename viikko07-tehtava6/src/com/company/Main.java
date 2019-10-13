package com.company;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = 10000000;
        int k = 1000000;
        int[] taulu = new int[n];
        Random r = new Random(1337);
        for (int i = 0; i < n; i++) {
            taulu[i] = r.nextInt(10000000) + 1;
        }
        O_nk(taulu, k);
        O_n_log_n(taulu, k);
        O_nPLUSk_logN(taulu, k);
    }

    public static int O_nPLUSk_logN(int[] t, int k) {
        int[] tt = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            tt[i] = t[i];
        }
        long alku = System.nanoTime();
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i = 0; i < tt.length; i++) {
            que.add(tt[i]);
        }
        int summa = 0;
        for (int i = 0; i < k; i++) {
            summa += que.poll();
        }
        long loppu = System.nanoTime();
        System.out.println("O(n + k log n): Aikaa kului "+((loppu-alku)/1e9)+" s. Summa: "+summa);
        return summa;
    }

    public static int O_n_log_n(int[] t, int k) {
        int[] tt = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            tt[i] = t[i];
        }
        long alku = System.nanoTime();
        Arrays.sort(tt);
        int summa = 0;
        for (int i = 0; i < k; i++) {
            summa += tt[i];
        }
        long loppu = System.nanoTime();
        System.out.println("O(n log n): Aikaa kului "+((loppu-alku)/1e9)+" s. Summa: "+summa);
        return summa;
    }

    public static int O_nk(int[] t, int k) {
        int[] tt = new int[t.length];
        for (int i = 0; i < t.length; i++) {
            tt[i] = t[i];
        }
        long alku = System.nanoTime();

        int summa = 0;
        int pienin = 9999999;
        int smallIndex = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < tt.length; j++) {
                if(tt[j] < pienin) {
                    pienin = tt[j];
                    smallIndex = j;
                }
            }
            summa += pienin;
            pienin = 9999999;
            tt[smallIndex] = 9999999;
        }
        long loppu = System.nanoTime();
        System.out.println("O(nk): Aikaa kului "+((loppu-alku)/1e9)+" s. Summa: "+summa);
        return summa;
    }
}
