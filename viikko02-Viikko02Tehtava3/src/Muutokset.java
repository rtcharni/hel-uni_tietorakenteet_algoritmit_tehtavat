import java.util.ArrayList;
import java.util.List;

public class Muutokset {
    int laske(int[] t) {
        int totalMoves = 0;
        List list = new ArrayList();
        //list.add(t[0]);

        for (int i = 1; i < t.length; i++) {
            //list.add(t[i]);

            if (t[i - 1] == t[i] && i != t.length - 1) {
                if (t[i - 1] > t[i + 1]) {
                    t[i] = t[i - 1] + 1;
                    totalMoves++;
                } else if (t[i - 1] < t[i + 1]) {
                    t[i] = t[i + 1] + 1;
                    totalMoves++;
                } else {
                    t[i] = t[i - 1] + 1;
                    totalMoves++;
                }
            } else if (i == t.length - 1 && t[i - 1] == t[i]) {
                t[i] = t[i - 1] + 1;
                totalMoves++;
            }
        }
        return totalMoves;
    }
}
