import java.util.*;

public class Komponentit {
    int[] vanhempi;
    int[] koko;
    int total;

    public Komponentit(int n) {
        total = n;
        vanhempi = new int[n + 1];
        koko = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            koko[i] = 1;
            vanhempi[i] = i;
        }
    }

    public int laske() {
        return total;
    }

    public boolean sama(int a, int b) {
        return edustaja(a) == edustaja(b);
    }

    public int edustaja(int x) {
        while (x != vanhempi[x]) {
            x = vanhempi[x];
        }
        return x;
    }

    public void yhdista(int a, int b) {
        a = edustaja(a);
        b = edustaja(b);
        if (a == b) {
            return;
        }
        if (koko[a] < koko[b]) {
            vanhempi[a] = b;
            koko[b] += koko[a];
        } else {
            vanhempi[b] = a;
            koko[a] += koko[b];
        }
        total--;
    }
}
