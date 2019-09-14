import java.util.*;

public class PieninEro {
    int laske(int[] t) {
        Arrays.sort(t);
        int diff = 999999999;
        for (int i = 1; i < t.length; i++) {
            int newDiff = t[i] - t[i-1];
            if (newDiff < diff) {
                diff = newDiff;
            }
        }
        return diff;
    }
}
