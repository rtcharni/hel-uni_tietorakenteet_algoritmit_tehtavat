import java.util.*;

public class Ruudukko {
    boolean[][] lattia;
    Piste[][] edustajat;
    int[][] koko;
    int totalKomponentit;
    int totalRuudukoita;
    int n;
    
    public Ruudukko(int n) {
        this.n = n;
        lattia = new boolean[n+1][n+1];
        totalRuudukoita = n * n;
        totalKomponentit = 0;
        edustajat = new Piste[n + 1][n + 1];
        koko = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                koko[i][j] = 1;
                edustajat[i][j] = new Piste(i,j);
            }
        }
    }
    
    
    public void teeLattia(int y, int x) {
        if (lattia[y][x] == false) {
            totalKomponentit++;
            lattia[y][x] = true;
            yhdistaKaikkiinYmparilla(y,x);
        }
    }
    
    public int laskeHuoneet() {
        return totalKomponentit;
    }

    public Piste löydäEdustaja(int y, int x) {
//        Piste p = new Piste(y,x);
//        while (!(p.equals(edustajat[y][x]))) {
//            p = edustajat[p.y][p.x];
//        }
//        return p;
        return edustajat[y][x];
    }

    public void yhdista(int y, int x, int y2, int x2) {
        Piste p = löydäEdustaja(y,x);
        Piste p2 = löydäEdustaja(y2,x2);
        if (p.equals(p2)) {
            return;
        }

        if (koko[p.y][p.x] < koko[p2.y][p2.x]) {
            edustajat[p.y][p.x] = p2; // new Piste(p2.y,p2.x);
            koko[p2.y][p2.x] += koko[p.y][p.x];
        } else {
            edustajat[p2.y][p2.x] = p; // new Piste(p.y,p.x);
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
            Piste p = edustajat[y][x-1];
            if (!yhdistetytEdustajat.contains(p)) {
                yhdistetytEdustajat.add(p);
                yhdista(y,x, y, x-1);
            }
//            yhdista(y,x, y, x-1);
        }
        // oikea
        if (x < n && lattia[y][x+1] == true) {
            Piste p = edustajat[y][x+1];
            if (!yhdistetytEdustajat.contains(p)) {
                yhdistetytEdustajat.add(p);
                yhdista(y,x, y, x+1);
            }
//            yhdista(y,x, y, x+1);
        }
        // ylos
        if (y > 1 && lattia[y-1][x] == true) {
            Piste p = edustajat[y-1][x];
            if (!yhdistetytEdustajat.contains(p)) {
                yhdistetytEdustajat.add(p);
                yhdista(y,x, y-1, x);
            }
//            yhdista(y,x, y-1, x);
        }
        // alas
        if (y < n && lattia[y+1][x] == true) {
            Piste p = edustajat[y+1][x];
            if (!yhdistetytEdustajat.contains(p)) {
                yhdistetytEdustajat.add(p);
                yhdista(y,x, y+1, x);
            }
//            yhdista(y,x, y+1, x);
        }
    }
}

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
