import java.util.*;

public class Peli {
    HashSet<Integer> set;
    public Peli() {
        set = new HashSet<>();
        int i = 0;
        while (i <= 1000000000) {
            i *= 2;
            i++;
            set.add(i);
        }
    }

    public int voittaja(int n) {
        if (set.contains(n)) {
            return 2;
        } else {
            return 1;
        }
    }
}

