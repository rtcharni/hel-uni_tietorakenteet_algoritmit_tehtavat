import java.util.*;

public class Kunnostus {
    int[] vanhempi;
    int[] koko;
    int totalKomponentit;
    ArrayList<Kaari> kaaret;

    public Kunnostus(int n) {
        kaaret = new ArrayList<>();
        totalKomponentit = n;
        vanhempi = new int[n + 1];
        koko = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            koko[i] = 1;
            vanhempi[i] = i;
        }
    }

    public void lisaaTie(int a, int b, int x) {
        kaaret.add(new Kaari(a, b, x));
//        yhdista(a,b);
    }

    public int laske() {
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
        if (totalKomponentit > 1) return -1;
        return totalKustannus;
    }

    public int edustaja(int x) {
        while (x != vanhempi[x]) {
            x = vanhempi[x];
        }
        return x;
    }

    public void yhdista(int a, int b) {
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
