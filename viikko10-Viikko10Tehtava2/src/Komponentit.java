import java.util.*;

public class Komponentit {
    ArrayList<Integer>[] verkot;
    boolean[] kaytyKoneet;
    boolean[] kaytyVerkot;
    int total;
    int n;

    public Komponentit(int n) {
        this.n = n;
        verkot = new ArrayList[n+1];
        kaytyKoneet = new boolean[n+1];
        kaytyVerkot = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            verkot[i] = new ArrayList<>();
        }
    }
    
    public void lisaaYhteys(int a, int b) {
        if (!verkot[a].contains(b)) {
            verkot[a].add(b);
            if (!verkot[b].contains(a)) {
                verkot[b].add(a);
            }
        }
    }
    
    public int laske() {
        total = 0;
        for (int i = 1; i <= n; i++) {
            if (kaytyKoneet[i] == false) {
                haku(verkot[i], i);
                total++;
            }
        }
        return total;
    }

    void haku(ArrayList<Integer> verkko, int verkkoNum) {
        if (kaytyVerkot[verkkoNum]) {
            return;
        }
        kaytyVerkot[verkkoNum] = true;
        kaytyKoneet[verkkoNum] = true;
        for (Integer s : verkko) {
            if (!kaytyKoneet[s]) {
                kaytyKoneet[s] = true;
                haku(verkot[s], s);
            } else {
                haku(verkot[s], s);
            }
        }
    }

    void konePuuttuu() {

    }
}

//    procedure haku(solmu)
//if vierailtu[solmu]
//        return
//        vierailtu[solmu] = true
//        for naapuri in verkko[solmu]
//        haku(naapuri)