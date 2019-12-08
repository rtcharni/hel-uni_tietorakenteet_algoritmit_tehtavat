import java.util.*;

public class Ruudukko {
    boolean[][] lattia;
    Piste[][] vanhempi;
    int[][] koko;
    int totalKomponentit;
    int totalRuudukoita;
    int n;
    
    public Ruudukko(int n) {
        this.n = n;
        lattia = new boolean[n+1][n+1];
        totalRuudukoita = n * n;
        totalKomponentit = 0;
        vanhempi = new Piste[n + 1][n + 1];
        koko = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                koko[i][j] = 1;
                vanhempi[i][j] = new Piste(i,j);
            }
        }
    }
    
    
    public void teeLattia(int y, int x) {
        if (lattia[y][x] == false) {
            // tee lattia, yhdistä viereisiin lattioihin
//            koko[y][x] = 1;
            totalKomponentit++;
            lattia[y][x] = true;
            yhdistaKaikkiinYmparilla(y,x);
        }
    }
    
    public int laskeHuoneet() {
        return totalKomponentit;
    }

    public Piste edustaja(int x, int xx) {
        Piste p = new Piste(x,xx);
//        while (x != vanhempi[x]) {
//            x = vanhempi[x];
//        }

        while (!(p.equals(vanhempi[x][xx]))) {
            p = vanhempi[p.y][p.x];
        }
        return p;
    }

    public boolean onkoSamaEdustaja(int y, int x, int yy, int xx) {
        return vanhempi[y][x].equals(vanhempi[yy][xx]);
    }

    public void yhdista(int a, int aa, int b, int bb) {
        Piste p = edustaja(a,aa);
        Piste p2 = edustaja(b,bb);
        if (p.equals(p2)) {
            return;
        }
//        a = edustaja(a);
//        b = edustaja(b);
//        if (a == b) {
//            return;
//        }
        if (koko[p.y][p.x] < koko[p2.y][p2.x]) {
            vanhempi[p.y][p.x] = new Piste(p2.y,p2.x);
            koko[p2.y][p2.x] += koko[p.y][p.x];
        } else {
            vanhempi[p2.y][p2.x] = new Piste(p.y,p.x);
            koko[p.y][p.x] += koko[p2.y][p2.x];
        }
        if (totalKomponentit == 1) {
            return;
        }
        totalKomponentit--;
    }

    void yhdistaKaikkiinYmparilla(int y, int x) {
        // vasen
        ArrayList<Piste> yhdistetytEdustajat = new ArrayList<>();
        if (x > 1 && lattia[y][x-1] == true) {
            Piste p = vanhempi[y][x-1];
            if (!yhdistetytEdustajat.contains(p)) {
                yhdistetytEdustajat.add(p);
                yhdista(y,x, y, x-1);
            }
//            yhdista(y,x, y, x-1);
        }
        // oikea
        if (x < n && lattia[y][x+1] == true) {
            Piste p = vanhempi[y][x+1];
            if (!yhdistetytEdustajat.contains(p)) {
                yhdistetytEdustajat.add(p);
                yhdista(y,x, y, x+1);
            }
//            yhdista(y,x, y, x+1);
        }
        // ylos
        if (y > 1 && lattia[y-1][x] == true) {
            Piste p = vanhempi[y-1][x];
            if (!yhdistetytEdustajat.contains(p)) {
                yhdistetytEdustajat.add(p);
                yhdista(y,x, y-1, x);
            }
//            yhdista(y,x, y-1, x);
        }
        // alas
        if (y < n && lattia[y+1][x] == true) {
            Piste p = vanhempi[y+1][x];
            if (!yhdistetytEdustajat.contains(p)) {
                yhdistetytEdustajat.add(p);
                yhdista(y,x, y+1, x);
            }
//            yhdista(y,x, y+1, x);
        }
    }

}
//2435038764

class Piste {
    int y, x;
    public Piste(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piste piste = (Piste) o;
        return y == piste.y &&
                x == piste.x;
    }

    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}
