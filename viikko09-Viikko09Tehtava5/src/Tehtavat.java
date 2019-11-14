import java.util.*;

public class Tehtavat {
    long[][] t;

    public Tehtavat() {
        alustaTaulukko();
    }

    public void alustaTaulukko() {
        t = new long[15][86];
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 86; j++) {
                if(j < i*3 || j > i*6){
                    t[i][j] = 0;
                } else {
                    t[i][j] = -1;
                }
            }
        }
        t[1][3] = 1;
        t[1][4] = 1;
        t[1][5] = 1;
        t[1][6] = 1;
        for (int i = 84; i >= 42; i--) {
            t[14][i] = alusta(14, i);
        }
    }

    public long alusta(int vii, int teht) {
        if (t[vii][teht] != -1) {
            return t[vii][teht];
        } else {
            long sum = 0;
            for (int i = 3; i <= 6; i++) {
                long subsum = alusta(vii-1, teht-i);
                if (subsum > 0) {
                    sum += subsum;
//                    sum += 1;
                }
            }
            t[vii][teht] = sum;
            return sum;
        }
    }


    public long laske(int x) {
        return t[14][x];
    }

//    void alustaMatriisi(int x) {
//        for (int i = 0; i < x; i++) {
//            for (int j = 0; j < 14; j++) {
//                matriisi[i][j] = -1;
//            }
//        }
//    }

//    void laskeKaikki(int viikko, int tehdytTehtavat) {
//        if (viikko == 14) {
//            if (map.containsKey(tehdytTehtavat)) {
//                map.put(tehdytTehtavat, map.get(tehdytTehtavat) + 1);
//            } else {
//                map.put(tehdytTehtavat, (long) 1);
//            }
//            return;
//        }
//        laskeKaikki(viikko + 1, tehdytTehtavat + 3);
//        laskeKaikki(viikko + 1, tehdytTehtavat + 4);
//        laskeKaikki(viikko + 1, tehdytTehtavat + 5);
//        laskeKaikki(viikko + 1, tehdytTehtavat + 6);
//    }

//    long ylhaaltaAlas(int tehtavat, int viikko) {
//        if (viikko == 0) {
//            return 0;
//        }
//        if (matriisi[tehtavat][viikko] > -1) {
//            return matriisi[tehtavat][viikko];
//        } else {
//            long a = ylhaaltaAlas(tehtavat - 3, viikko - 1);
//            long b = ylhaaltaAlas(tehtavat - 4, viikko - 1);
//            long c = ylhaaltaAlas(tehtavat - 5, viikko - 1);
//            long d = ylhaaltaAlas(tehtavat - 6, viikko - 1);
//            long summa = a + b + c + d;
//            matriisi[tehtavat][viikko] = summa;
//            return summa;
//        }
//    }

//    void laskeViikot(int viikko, int tehtJaljellä) {
//        if (viikko == 14) {
//            return;
//        }
//        if (tehtJaljellä < 3) {
//            return;
//        }
//
//        int viikkojaJaljella = 14 - viikko;
//        int minTehtaviaPitaaOlla = viikkojaJaljella * 3;
//        if (tehtJaljellä < minTehtaviaPitaaOlla) {
//            return;
//        }
//
//        if (viikko == 13 && tehtJaljellä == 3) {
//            total++;
//            return;
//        } else if (viikko == 13 && tehtJaljellä == 4) {
//            total++;
//            return;
//        } else if (viikko == 13 && tehtJaljellä == 5) {
//            total++;
//            return;
//        } else if (viikko == 13 && tehtJaljellä == 6) {
//            total++;
//            return;
//        }
//
//        laskeViikot(viikko + 1, tehtJaljellä - 3);
//        laskeViikot(viikko + 1, tehtJaljellä - 4);
//        laskeViikot(viikko + 1, tehtJaljellä - 5);
//        laskeViikot(viikko + 1, tehtJaljellä - 6);
//    }
}