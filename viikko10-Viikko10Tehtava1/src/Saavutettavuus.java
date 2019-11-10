import java.util.*;

public class Saavutettavuus {
    ArrayList<Integer>[] verkot;
    boolean[] koneet;
    boolean[] verkotKayty;
    int total;
    int n;
    public Saavutettavuus(int n) {
        this.n = n;
        verkot = new ArrayList[n+2];
        koneet = new boolean[n+2];
        verkotKayty = new boolean[n+2];

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
    
    public int laske(int x) {
        if (n < 2) {
            return 0;
        }
        total = 0;

        recCheck(verkot[x], x);
        return total == 0 ? 0 : total -1;
//        for (Integer s : verkot[x]) {
//            // käsittele solmu s
//            if (!koneet[s]) {
//                total++;
//                recCheck(verkot[s], koneet);
//            } else {
//                recCheck(verkot[s], koneet);
//            }
//        }
    }

    void recCheck(ArrayList<Integer> verkko, int verkkoNum) {
        if (verkotKayty[verkkoNum]) {
            return;
        }
        verkotKayty[verkkoNum] = true;
        for (Integer s : verkko) {
            if (!koneet[s]) {
                total++;
                koneet[s] = true;
                recCheck(verkot[s], s);
            } else {
                recCheck(verkot[s], s);
            }
        }

    }
}
