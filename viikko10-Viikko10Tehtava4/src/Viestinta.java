import java.util.*;

public class Viestinta {
    Queue<Integer> que = new LinkedList<>();
    ArrayList<Integer>[] verkot;
    boolean[] koneetKayty;
    boolean[] verkotKayty;
    int[] etaisyys;
    int total;
    int n;
    boolean[][] yhteydet;
    boolean haettu = false;
    
    public Viestinta(int n) {
        yhteydet = new boolean[n+1][n+1];
        etaisyys = new int[n+1];
        this.n = n;
        verkot = new ArrayList[n+1];
        koneetKayty = new boolean[n+1];
        verkotKayty = new boolean[n+1];
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
    
    public boolean tarkasta(int x, int y) {
        if (haettu == false) {
            haeKaikki();
        }
        return yhteydet[x][y];
    }
    void haeKaikki() {
//        total = 0;
        for (int i = 1; i <= n; i++) {
            if (koneetKayty[i] == false) {
                haku(verkot[i], i);
                yhdistaKaikki();
//                total++;
            }
        }
        haettu = true;
//        return total;
    }

    void haku(ArrayList<Integer> verkko, int verkkoNum) {
        if (verkotKayty[verkkoNum]) {
            return;
        }
        verkotKayty[verkkoNum] = true;
        koneetKayty[verkkoNum] = true;
        for (Integer s : verkko) {
            if (!koneetKayty[s]) {
                koneetKayty[s] = true;
                haku(verkot[s], s);
            } else {
                haku(verkot[s], s);
            }
        }
    }

    void yhdistaKaikki() {
        for (int i = 1; i < koneetKayty.length; i++) {
            if (koneetKayty[i] == false) {
                continue;
            }
            for (int j = 1; j < koneetKayty.length; j++) {
                if (koneetKayty[j] == false) {
                    continue;
                }
                yhteydet[i][j] = true;
            }
        }
        for (int i = 0; i < koneetKayty.length; i++) {
            koneetKayty[i] = false;
        }
    }
}
