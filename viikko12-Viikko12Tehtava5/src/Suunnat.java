import java.util.*;

public class Suunnat {
    ArrayList<Kaari> kaaret;
    ArrayList<Integer>[] verkot;
    boolean[] vierailtu;
    ArrayList<Integer> topologinenLista;
    ArrayList<Integer> tämäKierros;
    boolean sykliLöytyi;
    int n;

    public Suunnat(int n) {
        sykliLöytyi = false;
        this.n = n;
        tämäKierros = new ArrayList<>();
        kaaret = new ArrayList<>();
        vierailtu = new boolean[n + 1];
        topologinenLista = new ArrayList<>();
        verkot = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            verkot[i] = new ArrayList<>();
        }
    }

    public void lisaaKaari(int a, int b) {
    }
    
    public ArrayList<Kaari> muodosta() {
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
