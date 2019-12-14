import java.util.*;

public class Ruudukko {
    int[] koko;
    int[] vanhempi;
    boolean[] lattia;
    int totalKomponentit;
    int totalRuudukoita;
    int n;
    
    public Ruudukko(int n) {
        this.n = n;
        totalRuudukoita = n * n;
        vanhempi = new int[totalRuudukoita+1];
        koko = new int[totalRuudukoita+1];
        lattia = new boolean[totalRuudukoita+1];
        totalKomponentit = 0;
        for (int i = 1; i <= totalRuudukoita; i++) {
            vanhempi[i] = i;
            koko[i] = 1;
        }
    }

    public int loydaRuutu(int y, int x) {
        int ruutu = n * (y - 1) + x;
        return ruutu;
        // 0 tai yli totalRuudukoita On yli laidan
    }
    
    
    public void teeLattia(int y, int x) {
        if (lattia[loydaRuutu(y, x)] == false) {
            totalKomponentit++;
            lattia[loydaRuutu(y, x)] = true;
            yhdistaKaikkiinYmparilla(loydaRuutu(y, x));
        }
    }
    
    public int laskeHuoneet() {
        return totalKomponentit;
    }

    int edustaja(int x) {
        while (x != vanhempi[x]) x = vanhempi[x];
        return x;
    }

    public void yhdista(int a, int b) {
        a = edustaja(a);
        b = edustaja(b);
        if (a == b) return;
        if (koko[a] > koko[b]) {
            koko[a] += koko[b];
            vanhempi[b] = a;
        } else {
            koko[b] += koko[a];
            vanhempi[a] = b;
        }
        totalKomponentit--;
    }

    void yhdistaKaikkiinYmparilla(int x) {
        if (x % n != 0) {
            if (lattia[x+1] == true) {
                yhdista(x, x+1);
            }
        }
        if (x % n != 1) {
            if (lattia[x-1] == true) {
                yhdista(x, x-1);
            }
        }
        if (x > n) {
            if (lattia[x-n] == true) {
                yhdista(x, x-n);
            }
        }
        if (x <= totalRuudukoita - n) {
            if (lattia[x+n] == true) {
                yhdista(x, x+n);
            }
        }
    }
}
