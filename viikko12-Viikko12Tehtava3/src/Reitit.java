import java.util.*;

public class Reitit {
    ArrayList<Kaari> kaaret;
    HashMap<Integer, ArrayList<Integer>> kaaretToisinPain;
    int n;
    HashMap<Integer, Long> map;

    public Reitit(int n) {
        kaaret = new ArrayList<>();
        kaaretToisinPain = new HashMap<>();
        this.n = n;
        map = new HashMap<>();
        map.put(1, (long) 1);
    }

    public void lisaaKaari(int a, int b) {
        kaaret.add(new Kaari(a, b));
        if (kaaretToisinPain.containsKey(b)) {
            ArrayList temp = kaaretToisinPain.get(b);
            temp.add(a);
            kaaretToisinPain.put(b, temp);
        } else {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(a);
            kaaretToisinPain.put(b, temp);
        }
    }

    long polut(int polkuun) {
        if (polkuun == 1) {
            return 1;
        }
        long total = 0;
        if (!kaaretToisinPain.containsKey(polkuun)) {
            return total;
        }
        for (Integer p : kaaretToisinPain.get(polkuun)) {
            if (map.containsKey(p)) {
                total += map.get(p);
            } else {
                long tempSum = polut(p);
                map.put(p, tempSum);
                total += polut(p);
            }
        }
        return total;
    }

    public long laske() {
        return polut(n);
    }

}
