import java.util.*;

public class Ruudukko {
    int[][] arvot;

    public long laske(int[][] t) {
        arvot = new int[t.length][t.length];
        laskeReittiArvot(t.length, t);
        return arvot[t.length - 1][t.length - 1];
    }

    void laskeReittiArvot(int n, int[][] taulu) {
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (y == 0 && x == 0) {
                    arvot[y][x] = taulu[0][0];
                } else {
                    int nykyinen = taulu[y][x];
                    int vasen = 0;
                    int ylos = 0;
                    if (fromLeft(x)) {
                        vasen = arvot[y][x - 1];
                    }
                    if (fromUp(y)) {
                        ylos = arvot[y - 1][x];
                    }

                    if (nykyinen + vasen > nykyinen + ylos) {
                        arvot[y][x] = nykyinen + vasen;
                    } else {
                        arvot[y][x] = nykyinen + ylos;
                    }
                }
            }
        }
    }

    boolean fromLeft(int x) {
        if (x == 0) {
            return false;
        }
        return true;
    }

    boolean fromUp(int y) {
        if (y == 0) {
            return false;
        }
        return true;
    }
}

//for y = 1 to n
//        for x = 1 to n
//        if este[y][x]
//        reitit[y][x] = 0
//        else if y == 1 and x == 1
//        reitit[y][x] = 1
//        else
//        reitit[y][x] = reitit[y-1][x]+reitit[y][x-1]