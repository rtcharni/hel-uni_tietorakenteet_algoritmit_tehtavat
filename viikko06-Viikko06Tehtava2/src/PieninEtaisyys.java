import java.util.*;

public class PieninEtaisyys {
    TreeSet<Integer> set = new TreeSet<>();
    //TreeMap map = new TreeMap();
    int smallest = 999999999;

    public void lisaa(int x) {
        set.add(x);
        int low;
        int high;
        if (set.first() != x) {
            low = Math.abs(set.lower(x) - x);
            smallest = low < smallest ? low : smallest;
        }
        if (set.last() != x) {
            high = Math.abs(set.higher(x) - x);
            smallest = high < smallest ? high : smallest;
        }

    }

    public int laske() {
        return smallest;
    }
}
