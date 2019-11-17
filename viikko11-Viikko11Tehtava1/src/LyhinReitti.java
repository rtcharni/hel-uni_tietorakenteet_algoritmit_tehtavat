import java.util.*;

public class LyhinReitti {
    PriorityQueue<Yhteys> keko;
    ArrayList<Yhteys>[] verkko;
    boolean[] kasitelty;
    int[] etaisyys;

    public LyhinReitti(int n) {
        keko = new PriorityQueue<>();
        verkko = new ArrayList[n+1];
        kasitelty = new boolean[n+1];
        etaisyys = new int[n+1];
        for (int i = 1; i <= n; i++) {
            verkko[i] = new ArrayList<>();
        }
    }
    
    public void lisaaTie(int a, int b, int p) {
//        if (!verkko[a].contains(new Yhteys(b, p))) {
            verkko[a].add(new Yhteys(b, p));
//        }
//        if (!verkko[b].contains(new Yhteys(a, p))) {
            verkko[b].add(new Yhteys(a, p));
//        }
    }
    
    public int laske(int x, int y) {
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
//                if (y == kaari.kohde) {
//                    return etaisyys[kaari.kohde];
//                }
            }
        }
        return etaisyys[y] == 0 ? -1 : etaisyys[y];
    }
}
//        keko.push((0,alku))
//        while not keko.empty()
//            solmu = keko.pop()[1]
//            if kasitelty[solmu]
//                continue
//            kasitelty[solmu] = true
//            for kaari in verkko[solmu]
//                nyky = etaisyys[kaari.loppu]
//                uusi = etaisyys[solmu]+kaari.paino
//                if uusi < nyky
//                    etaisyys[kaari.loppu] = uusi
//                    keko.push((uusi,kaari.loppu))
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
        if(dt.kohde == this.kohde) return true;
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