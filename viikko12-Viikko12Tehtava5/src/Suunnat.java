import java.util.*;

public class Suunnat {
    ArrayList<Kaari> kaaret;
    ArrayList<Integer>[] verkot;
    int n;
    boolean[] oltuJo;
    boolean[][] matriisi;
    boolean lisättySamaan;
    int[][] olemassa;
    int[][] lisatty;

    public Suunnat(int n) {
        olemassa = new int[n+1][n+1];
        lisatty = new int[n+1][n+1];
        lisättySamaan = false;
        matriisi = new boolean[n + 1][n + 1];
        oltuJo = new boolean[n + 1];
        this.n = n;
        kaaret = new ArrayList<>();
        verkot = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            verkot[i] = new ArrayList<>();
        }
    }

    public void lisaaKaari(int a, int b) {
        verkot[a].add(b);
        verkot[b].add(a);
        olemassa[a][b]++;
        olemassa[b][a]++;
        if (a == b) {
            lisättySamaan = true;
        }
    }

    public ArrayList<Kaari> muodosta() {
        if (lisättySamaan) {
            return null;
        }
        for (int i = 1; i <= n; i++) {
            if (verkot[i].size() > 0 && oltuJo[i] == false) {
                oltuJo[i] = true;
                syvyysHaku2(verkot[i], i);
            }
        }
        return kaaret;
    }

    void syvyysHaku2(ArrayList<Integer> verkko, int verkkoNum) {
        for (Integer k : verkko) {
            if (!oltuJo[k]) {
                kaaret.add(new Kaari(verkkoNum, k));
                matriisi[verkkoNum][k] = true;
//                verkot[k].remove(Integer.valueOf(verkkoNum));
                lisatty[verkkoNum][k]++ ;
                lisatty[k][verkkoNum]++ ;
                oltuJo[k] = true;
                syvyysHaku2(verkot[k], k);
            } else {
                if (olemassa[verkkoNum][k] == lisatty[verkkoNum][k]) {
                    continue;
                }
                if (matriisi[verkkoNum][k]) {
                    kaaret.add(new Kaari(verkkoNum, k));
//                    verkot[k].remove(Integer.valueOf(verkkoNum));
                    lisatty[verkkoNum][k]++ ;
                    lisatty[k][verkkoNum]++ ;
                } else {
                    kaaret.add(new Kaari(k, verkkoNum));
                    matriisi[k][verkkoNum] = true;
//                    verkot[k].remove(Integer.valueOf(verkkoNum));
                    lisatty[verkkoNum][k]++ ;
                    lisatty[k][verkkoNum]++ ;
                }
            }
        }
    }
}
