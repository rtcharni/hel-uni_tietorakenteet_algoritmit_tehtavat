import java.util.*;

public class SamatLuvut {
    TreeSet<Integer> set = new TreeSet<>();
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public void lisaa(int x) {
        set.add(x);
        if (map.containsKey(x)) {
            int n = map.get(x) + 1;
            map.put(x, n);
        } else {
            map.put(x, 1);
        }
    }

    public void poista(int x) {
        if (map.containsKey(x)) {
            int howMany = map.get(x);
            if (howMany == 1) {
                map.remove(x);
                set.remove(x);
            } else {
                map.put(x, howMany - 1);
            }
        }
    }
    
    public int pienin() {
        return set.first();
    }
}
