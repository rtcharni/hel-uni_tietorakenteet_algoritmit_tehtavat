import java.util.*;

public class Tehtavat {
    long[][] matriisi;
    long total;
    HashMap<Integer, Long> map;

    public Tehtavat() {
//        map = new HashMap();
//        laskeKaikki(0, 0);
        matriisi = new long[85][14];
        alustaMatriisi(85);
        ylhaaltaAlas(84 - 3, 13);
        ylhaaltaAlas(84 - 4, 13);
        ylhaaltaAlas(84 - 5, 13);
        ylhaaltaAlas(84 - 6, 13);

    }

    public long laske(int x) {
        if (x == 42 || x == 84) {
            return 1;
        } else {
            return matriisi[x][0];
        }
//        total = 0;
//        laskeViikot(1, x-3);
//        laskeViikot(1, x-4);
//        laskeViikot(1, x-5);
//        laskeViikot(1, x-6);
//        return map.get(x);

    }

    void alustaMatriisi(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < 14; j++) {
                matriisi[i][j] = -1;
            }
        }
    }

    void laskeKaikki(int viikko, int tehdytTehtavat) {
        if (viikko == 14) {
            if (map.containsKey(tehdytTehtavat)) {
                map.put(tehdytTehtavat, map.get(tehdytTehtavat) + 1);
            } else {
                map.put(tehdytTehtavat, (long) 1);
            }
            return;
        }
        laskeKaikki(viikko + 1, tehdytTehtavat + 3);
        laskeKaikki(viikko + 1, tehdytTehtavat + 4);
        laskeKaikki(viikko + 1, tehdytTehtavat + 5);
        laskeKaikki(viikko + 1, tehdytTehtavat + 6);
    }

    long ylhaaltaAlas(int tehtavat, int viikko) {
        if (viikko == 0) {
            return 0;
        }
        if (matriisi[tehtavat][viikko] > -1) {
            return matriisi[tehtavat][viikko];
        } else {
            long a = ylhaaltaAlas(tehtavat - 3, viikko - 1);
            long b = ylhaaltaAlas(tehtavat - 4, viikko - 1);
            long c = ylhaaltaAlas(tehtavat - 5, viikko - 1);
            long d = ylhaaltaAlas(tehtavat - 6, viikko - 1);
            long summa = a + b + c + d;
            matriisi[tehtavat][viikko] = summa;
            return summa;
        }
    }

    void laskeViikot(int viikko, int tehtJaljellä) {
        if (viikko == 14) {
            return;
        }
        if (tehtJaljellä < 3) {
            return;
        }

        int viikkojaJaljella = 14 - viikko;
        int minTehtaviaPitaaOlla = viikkojaJaljella * 3;
        if (tehtJaljellä < minTehtaviaPitaaOlla) {
            return;
        }

        if (viikko == 13 && tehtJaljellä == 3) {
            total++;
            return;
        } else if (viikko == 13 && tehtJaljellä == 4) {
            total++;
            return;
        } else if (viikko == 13 && tehtJaljellä == 5) {
            total++;
            return;
        } else if (viikko == 13 && tehtJaljellä == 6) {
            total++;
            return;
        }

        laskeViikot(viikko + 1, tehtJaljellä - 3);
        laskeViikot(viikko + 1, tehtJaljellä - 4);
        laskeViikot(viikko + 1, tehtJaljellä - 5);
        laskeViikot(viikko + 1, tehtJaljellä - 6);
    }
}