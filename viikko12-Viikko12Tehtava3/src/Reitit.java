import java.util.*;

public class Reitit {
    ArrayList<Kaari> kaaret;
    int n;
    HashMap<Integer, Long> map;

    public Reitit(int n) {
        kaaret = new ArrayList<>();
        this.n = n;
        map = new HashMap<>();
        map.put(1, (long) 1);
    }

    public void lisaaKaari(int a, int b) {
        kaaret.add(new Kaari(a, b));
        if (map.containsKey(b)) {
            long valmiitaReittejä = map.get(b);
            if (map.containsKey(a)) {
                long uusiaReittejä = map.get(a) + valmiitaReittejä;
                map.put(b, uusiaReittejä);
            } else {
                map.put(b, valmiitaReittejä);
            }
        } else {
            if (map.containsKey(a)) {
                long reitit = map.get(a);
                map.put(b, reitit);
            } else {
                map.put(b, (long) 0);
            }
        }
    }

    public long polut(int polkuun) {
//        if (polkuun == 1) {
//            return 1;
//        }
//        long total = 0;
//        for(Kaari kaari : kaaret){
//            if (kaari.loppu == n) {
//                if (map.containsKey(kaari.loppu)) {
//                    total += map.get(kaari.loppu);
//                } else {
//
//                }
//            }
//        }
//        return total;
        return 0;
    }


    public long laske() {
        long total = 0;
        for (Kaari kaari : kaaret) {
            if (kaari.loppu == n) {

                if (map.containsKey(kaari.alku)) {
                    total += map.get(kaari.alku);
                }
            }
        }
        return total;
    }

}
