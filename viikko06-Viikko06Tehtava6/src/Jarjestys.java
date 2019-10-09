import java.util.*;

public class Jarjestys {
    int addI = 0;
    int preI = 0;
    int[] res;

    public int[] muodosta(int[] a, int[] b) {
        res = new int[a.length];
        generateJalki(b, a);
        return res;
    }

    void generateJalki(int[] s, int[] e) {
        int n = e.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(s[i], i);
        }
        calcAndAddToList(s, e, 0, n - 1, hm);
    }

    void calcAndAddToList(int[] s, int[] e, int inS, int inE, HashMap<Integer, Integer> hm) {
        if (inS > inE) {
            return;
        }
        int inIndex = hm.get(e[preI++]);
        calcAndAddToList(s, e, inS, inIndex - 1, hm);
        calcAndAddToList(s, e, inIndex + 1, inE, hm);
        res[addI++] = s[inIndex];
    }
}

