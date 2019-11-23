import java.util.*;

public class Kierrokset {
    ArrayList<Kaari> kaaret;
    int[] etaisyys;

    public Kierrokset() {
    }

    public ArrayList<Kaari> muodosta(int x) {
        kaaret = new ArrayList<>();
        etaisyys = new int[101];
        int INF = 999999999;
        for (int i = 2; i <= 100; i++) etaisyys[i] = INF;

        if (x == 1) {
            for (int i = 1; i <= 100; i++) {
                kaaret.add(new Kaari(i, i, 100));
            }
        } else {
            for (int i = 1; i < 100; i++) {
                kaaret.add(new Kaari(i, i + 1, 100));
            }
            int loops = 0;
            for (int i = 99; i >= 2; i--) {
                if (loops == x - 2) {
                    break;
                }
                int temp = i - 1;
                kaaret.add(new Kaari(temp, i, 50));
                loops++;
            }
        }


//        kaaret.add(new Kaari(5,6,50));
//        kaaret.add(new Kaari(4,5,50));
//        kaaret.add(new Kaari(3,4,50));
        ArrayList arr = BellmanFord(x);
//        testi(x);
        return arr;

    }

    ArrayList BellmanFord(int x) {
        ArrayList arr = new ArrayList();
        int kierros = 0;
        while (true) {
            kierros++;
            System.out.println(kierros);
            boolean muutos = false;
            for (Kaari kaari : kaaret) {
//                System.out.println("Käsittelen kaarta: " + kaari.toString());
//                int nyky = etaisyys[kaari.loppu];
//                int uusi = etaisyys[kaari.alku] + kaari.pituus;
                if (etaisyys[kaari.alku]+kaari.pituus < etaisyys[kaari.loppu]) {
                    System.out.println("Muutos: " + kaari.toString());
                    arr.add(kaari);
                    etaisyys[kaari.loppu] = etaisyys[kaari.alku]+kaari.pituus;
                    muutos = true;
                }
            }
            if (muutos == false) {
                break;
            }
        }
        return kaaret;
    }

    void testi(int x) {
        Kierrokset k = new Kierrokset();
        ArrayList<Kaari> kaaret = k.muodosta(x);
        int n = 100;
        boolean ok = true;
        if (kaaret.size() > 100000) ok = false;
        for (Kaari e : kaaret) {
            if (e.alku < 1 || e.alku > n) ok = false;
            if (e.loppu < 1 || e.loppu > n) ok = false;
            if (e.pituus < 1 || e.pituus > 1000) ok = false;
        }
        if (!ok) {
            System.out.println("Verkon muoto ei ole oikea, kun x="+x);
            return;
        }
        int INF = 999999999;
        int[] matka = new int[n+1];
        for (int i = 2; i <= n; i++) matka[i] = INF;
        int u = 0;
        while (true) {
            u++;
            boolean muutos = false;
            for (Kaari e : kaaret) {
                if (matka[e.alku]+e.pituus < matka[e.loppu]) {
                    matka[e.loppu] = matka[e.alku]+e.pituus;
                    muutos = true;
                }
            }
            if (!muutos) break;
        }
        if (u != x) System.out.println("Kierrosten määrä on väärä, kun x="+x);
    }
}




//kaaret.add(new Kaari(1,2,10));
//        kaaret.add(new Kaari(1,3,1));
//        kaaret.add(new Kaari(2,4,1));
//        kaaret.add(new Kaari(3,2,1));
