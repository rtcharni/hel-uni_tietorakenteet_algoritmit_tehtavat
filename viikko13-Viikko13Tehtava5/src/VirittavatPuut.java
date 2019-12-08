import java.util.*;

public class VirittavatPuut {
    int[] vanhempi;
    int[] koko;
    int totalKomponentit;
    ArrayList<Kaari> kaaret;

    public int laske(int n) {
        if (n == 1) return 1;
        int pow = n - 2;
        double total = Math.pow(n,pow);
        return (int) total;
    }

    public int vierittäväPuu() {
        int totalKustannus = 0;
        Collections.sort(kaaret);
        for (Kaari k : kaaret) {
            int a = edustaja(k.alku);
            int b = edustaja(k.loppu);
            if (a != b) {
                yhdista(a,b);
                totalKustannus += k.paino;
            }
        }
//        if (totalKomponentit > 1) return -1;
        return totalKustannus;
    }

    public int edustaja(int x) {
        while (x != vanhempi[x]) {
            x = vanhempi[x];
        }
        return x;
    }

    public void yhdista(int a, int b) {
        if (koko[a] < koko[b]) {
            vanhempi[a] = b;
            koko[b] += koko[a];
        } else {
            vanhempi[b] = a;
            koko[a] += koko[b];
        }
        totalKomponentit--;
    }

    public void lisaaTie(int a, int b, int x) {
        kaaret.add(new Kaari(a, b, x));
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
