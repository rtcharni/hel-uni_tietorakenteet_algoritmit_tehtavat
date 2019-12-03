import java.util.*;

public class Suunnat {
    ArrayList<Kaari> lopullisetKaaret;
    ArrayList<Kaari> kaaret;
    ArrayList<Integer>[] verkot;
    boolean[] vierailtu;
    boolean[] vierailtu2;
    ArrayList<Integer> topologinenLista;
    ArrayList<Integer> tämäKierros;
    boolean sykliLöytyi;
    int n;
    boolean[] oltuJo;
    boolean[][] matriisi;
    boolean lisättySamaan;

    public Suunnat(int n) {
        lisättySamaan = false;
        matriisi = new boolean[n + 1][n + 1];
        oltuJo = new boolean[n + 1];
        sykliLöytyi = false;
        this.n = n;
        tämäKierros = new ArrayList<>();
        kaaret = new ArrayList<>();
        vierailtu = new boolean[n + 1];
        vierailtu2 = new boolean[n + 1];
        topologinenLista = new ArrayList<>();
        verkot = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            verkot[i] = new ArrayList<>();
        }
    }

    public void lisaaKaari(int a, int b) {
//        if (!verkot[a].contains(b)) {
        verkot[a].add(b);
        verkot[b].add(a);
        if (a == b) {
            lisättySamaan = true;
        }
//        }
    }

    public ArrayList<Kaari> muodosta() {
        if (lisättySamaan) {
            return null;
        }
//        oltuJo[2] = true;
//        syvyysHaku2(verkot[2], 2);
        for (int i = 1; i <= n; i++) {
            if (verkot[i].size() > 0 && oltuJo[i] == false) {
                oltuJo[i] = true;
                syvyysHaku2(verkot[i], i);
            }
        }

//        if (sykliLöytyi == true) return null;
        return kaaret;

    }

    void syvyysHaku2(ArrayList<Integer> verkko, int verkkoNum) {
        for (Integer k : verkko) {
            if (!oltuJo[k]) {
                kaaret.add(new Kaari(verkkoNum, k));
                matriisi[verkkoNum][k] = true;
                verkot[k].remove(Integer.valueOf(verkkoNum));
                oltuJo[k] = true;
                syvyysHaku2(verkot[k], k);
            } else {
                if (matriisi[verkkoNum][k]) {
                    kaaret.add(new Kaari(verkkoNum, k));
                    verkot[k].remove(Integer.valueOf(verkkoNum));
                } else {
                    kaaret.add(new Kaari(k, verkkoNum));
                    matriisi[k][verkkoNum] = true;
                    verkot[k].remove(Integer.valueOf(verkkoNum));
                }
            }
        }
    }

    void syvyysHaku(ArrayList<Integer> verkko, int verkkoNum) {
        if (tämäKierros.contains(verkkoNum)) {
            System.out.println("SYKLI LÖYTYI!!");
            sykliLöytyi = true;
            return;
        }
        if (vierailtu[verkkoNum] == true) {
            return;
        }
        vierailtu[verkkoNum] = true;
        tämäKierros.add(verkkoNum);
        for (Integer k : verkko) {
            syvyysHaku(verkot[k], k);

        }
        topologinenLista.add(verkkoNum);
        tämäKierros.remove(verkko);
    }
}
