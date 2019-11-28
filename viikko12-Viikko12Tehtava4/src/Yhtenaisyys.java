import java.util.*;

public class Yhtenaisyys {
    ArrayList<Kaari> kaaret;
    ArrayList<Integer>[] verkot;
    ArrayList<Integer>[] verkotKaannetty;
    boolean[] vierailtu;
    boolean[] vierailtu2;
    ArrayList<Integer> vierailtuLista;
    int n;

    public Yhtenaisyys(int n) {
        this.n = n;
        kaaret = new ArrayList<>();
        vierailtu = new boolean[n + 1];
        vierailtu2 = new boolean[n + 1];
        vierailtuLista = new ArrayList<>();
        verkot = new ArrayList[n + 1];
        verkotKaannetty = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            verkot[i] = new ArrayList<>();
            verkotKaannetty[i] = new ArrayList<>();
        }
    }

    public void lisaaKaari(int a, int b) {
        verkot[a].add(b);
        kaaret.add(new Kaari(a, b));
    }

    public boolean tutki() {
        // Ensimmäinen vaihe
        for (int i = 1; i <= n; i++) {
            syvyysHaku(verkot[i], i);
        }
        // Toinen vaihe
        toinenVaihe();
        return onkoSamat();
    }

    void syvyysHaku(ArrayList<Integer> verkko, int verkkoNum) {
        if (vierailtu[verkkoNum] == true) {
            return;
        }
        vierailtu[verkkoNum] = true;
        for (Integer k : verkko) {
            syvyysHaku(verkot[k], k);

        }
        vierailtuLista.add(verkkoNum);
    }

    void toinenVaihe() {
        // Käännetään toisinpäin
        for (Kaari k : kaaret) {
            verkotKaannetty[k.loppu].add(k.alku);
        }
        // Syvyyshaku - komponenttihaku
        int viimeinen = vierailtuLista.get(vierailtuLista.size() - 1);
        syvyysHaku2(verkotKaannetty[viimeinen], vierailtuLista.get(vierailtuLista.size() - 1));
    }

    void syvyysHaku2(ArrayList<Integer> verkko, int verkkoNum) {
        if (vierailtu2[verkkoNum] == true) {
            return;
        }
        vierailtu2[verkkoNum] = true;
        for (Integer k : verkko) {
            syvyysHaku2(verkotKaannetty[k], k);
        }
//        vierailtuLista.add(verkkoNum);
    }

    boolean onkoSamat() {
        for (int i = 1; i <= n; i++) {
            if (vierailtu[i] != vierailtu2[i]) {
                return false;
            }
        }
        return true;
    }

    public class Kaari {
        public int alku, loppu;

        public Kaari(int alku, int loppu) {
            this.alku = alku;
            this.loppu = loppu;
        }
    }
}

