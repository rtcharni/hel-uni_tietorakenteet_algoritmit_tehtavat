import java.util.*;

public class Latinalaiset {  
    int total;
    public int laske(int n) {
        total = 0;
        haku2(0, 0, new int[n][n], n);
        return total;
    }

    void haku2(int y, int x, int[][] taulu, int n) {
        if (y == n-1 && x == n-1) {
            total++;
        } else {
            for (int i = 1; i <= n; i++) {
                if (voiSijoittaa(i, y, x, taulu)) {
                    taulu[y][x] = i;
                    if (y == n - 1) {
                        haku2(0, x + 1, taulu, n);
                    } else {
                        haku2(y + 1, x, taulu, n);
                    }
                }
            }
        }
    }

    boolean voiSijoittaa(int sijoitettava, int y, int x, int[][] taulu) {
        for (int i = 0; i < y; i++) {
            if (taulu[i][x] == sijoitettava) {
                return false;
            }
        }
        for (int i = 0; i < x; i++) {
            if (taulu[y][i] == sijoitettava) {
                return false;
            }
        }
        return true;
    }
}
