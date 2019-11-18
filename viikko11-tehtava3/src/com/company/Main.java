package com.company;
import java.util.*;

public class Main {
    static PriorityQueue<Yhteys> keko = new PriorityQueue<>();
    static ArrayList<Yhteys>[] verkko;
    static ArrayList<Kaari> kaaret = new ArrayList<>();
    static boolean[] kasitelty;
    static int[] etaisyys;
    static int[] etaisyys2;

    public static void main(String[] args) {
        alustaVerkko(10000000);
        alustaKaaret(10000000);
        long alkuBellman = System.nanoTime();
        BellmanFord(8000000);
        long loppuBellman = System.nanoTime();
        System.out.println("Bellman-Ford - Aikaa kului "+((loppuBellman-alkuBellman)/1e9)+" s");

        long alkuDi = System.nanoTime();
        Dijkstra(1, 8000000);
        long loppuDi = System.nanoTime();
        System.out.println("Dijkstra - Aikaa kului "+((loppuDi-alkuDi)/1e9)+" s");
    }

    static void alustaVerkko(int koko) {
        verkko = new ArrayList[koko+2];
        etaisyys = new int[koko+2];
        etaisyys2 = new int[koko+2];
        kasitelty = new boolean[koko+2];
        for (int i = 1; i <= koko; i++) {
            verkko[i] = new ArrayList<>();
            if (i == koko) {
                verkko[i].add(new Yhteys(i-1,i));
            } else {
                verkko[i].add(new Yhteys(i+1, i));
            }
        }
    }

    static void alustaKaaret(int koko) {
        for (int i = 1; i <= koko; i++) {
            kaaret.add(new Kaari(i,i+1, i));
        }
    }

    static int BellmanFord(int y) {
        while (true) {
            boolean muutos = false;
            for (Kaari kaari : kaaret) {
                var nyky = etaisyys2[kaari.loppu];
                var uusi = etaisyys2[kaari.alku]+kaari.paino;
                if (nyky == 0 || uusi < nyky) {
                    etaisyys2[kaari.loppu] = uusi;
                    muutos = true;
                }
            }
            if (muutos == false) {
                break;
            }
        }
        return etaisyys2[y] == 0 ? -1 : etaisyys2[y];
    }

    static int Dijkstra(int x, int y) {
        if (x == y) {
            return 0;
        }

        keko.add(new Yhteys(x, 0));
        while (!keko.isEmpty()) {
            Yhteys solmu = keko.poll();
            if (kasitelty[solmu.kohde] == true) {
                continue;
            }
            kasitelty[solmu.kohde] = true;
            for (Yhteys kaari : verkko[solmu.kohde]) {
                if (solmu.kohde == kaari.kohde) {
                    continue;
                }
                int nyky = etaisyys[kaari.kohde];
                int uusi = etaisyys[solmu.kohde]+kaari.paino;
                if (nyky == 0 || uusi < nyky) {
                    etaisyys[kaari.kohde] = uusi;
                    keko.add(new Yhteys(kaari.kohde, uusi));
                }
            }
        }
        return etaisyys[y] == 0 ? -1 : etaisyys[y];
    }
}

class Kaari {
    public int alku, loppu, paino;
    public Kaari(int alku, int loppu, int paino) {
        this.alku = alku;
        this.loppu = loppu;
        this.paino = paino;
    }
}

class Yhteys implements Comparable<Yhteys> {
    int kohde;
    int paino;

    public Yhteys(int kohde, int paino) {
        this.kohde = kohde;
        this.paino = paino;
    }

    public long getKohde() {
        return this.kohde;
    }
    public long getPaino() {
        return this.paino;
    }

    @Override
    public boolean equals(Object fromObj) {
        Yhteys dt = (Yhteys)fromObj;

//        if(Name == null) return false;
        if(dt.kohde == this.kohde&& dt.paino == this.paino) {
            return true;
        }
//        if(dt.Name.equals()) return true;

        return false;
    }

    @Override
    public int compareTo(Yhteys yht) {
        if(this.getPaino() > yht.getPaino()) {
            return 1;
        } else if (this.getPaino() < yht.getPaino()) {
            return -1;
        } else {
            return 0;
        }
    }
}

