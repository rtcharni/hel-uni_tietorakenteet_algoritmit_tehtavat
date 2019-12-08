package com.company;

import java.util.*;

public class Main {
    static int[] vanhempi;
    static int[] koko;
    static int totalKomponentit;
    static ArrayList<Kaari> kaaret;
    static boolean[] kasitelty;
    static PriorityQueue<Kaari> keko;
    static ArrayList<Kaari>[] verkko;

    public static void main(String[] args) {
        int n = 20000000;
        alusta(n);
        for (int i = 1; i < n; i++) {
            lisaaKaari(i,i+1,1);
        }

        long alku = System.nanoTime();
        Kruskal();
        long loppu = System.nanoTime();
        System.out.println("KRUSKAL: Aikaa kului "+((loppu-alku)/1e9)+" s");

        int V = n;
        Prim.Graph graph = new Prim.Graph(V);
        Prim e = new Prim();
        for (int i = 0; i < V-1; i++) {
            e.addEdge(graph, i, i+1, 1);
        }

        alku = System.nanoTime();
        e.prims_mst(graph);
        loppu = System.nanoTime();
        System.out.println("PRIM: Aikaa kului "+((loppu-alku)/1e9)+" s");

    }

    static void lisaaKaari(int alku, int loppu, int paino) {
        kaaret.add(new Kaari(alku, loppu, paino));
    }

    static void alusta(int n) {
        keko = new PriorityQueue<>();
        kasitelty = new boolean[n+1];
        vanhempi = new int[n + 1];
        koko = new int[n + 1];
        totalKomponentit = n;
        kaaret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            koko[i] = 1;
            vanhempi[i] = i;
        }
    }

    static int Dijkstra(int aloitusSolmu) {
//        if (x == y) {
//            return 0;
//        }
        int kustannus = 0;
//        keko.add(new Kaari(0, x, 0));
        keko.add(new Kaari(0, aloitusSolmu, 0));
        while (!keko.isEmpty()) {
            Kaari solmu = keko.poll();
            if (kasitelty[solmu.loppu] == true) {
                continue;
            } // muuta?!?!
            kasitelty[solmu.loppu] = true;
            for (Kaari kaari : verkko[solmu.loppu]) {

//                if (solmu.kohde == kaari.kohde) {
//                    continue;
//                }
//                int nyky = etaisyys[kaari.kohde];
//                int uusi = etaisyys[solmu.kohde]+kaari.paino;
//                if (nyky == 0 || uusi < nyky) {
//                    etaisyys[kaari.kohde] = uusi;
//                    keko.add(new Yhteys(kaari.kohde, uusi));
//                }
            }
        }
//        return etaisyys[y] == 0 ? -1 : etaisyys[y];
        return 0;
    }

    static int Kruskal() {
        int totalKustannus = 0;
        Collections.sort(kaaret);
        for (Kaari k : kaaret) {
            int a = edustaja(k.alku);
            int b = edustaja(k.loppu);
            if (a != b) {
                yhdista(a, b);
                totalKustannus += k.paino;
            }
        }
        if (totalKomponentit > 1) return -1;
        return totalKustannus;
    }

    static int edustaja(int x) {
        while (x != vanhempi[x]) {
            x = vanhempi[x];
        }
        return x;
    }

    static void yhdista(int a, int b) {
//        a = edustaja(a);
//        b = edustaja(b);
//        if (a == b) {
//            return;
//        }
        if (koko[a] < koko[b]) {
            vanhempi[a] = b;
            koko[b] += koko[a];
        } else {
            vanhempi[b] = a;
            koko[a] += koko[b];
        }
        totalKomponentit--;
    }
}


class Kaari implements Comparable<Kaari> {
    int alku, loppu, paino;

    public Kaari(int alku, int loppu, int paino) {
        this.alku = alku;
        this.loppu = loppu;
        this.paino = paino;
    }

    public Integer getPaino() {
        return this.paino;
    }

    @Override
    public int compareTo(Kaari o) {
        return this.getPaino().compareTo(o.getPaino());
    }
}