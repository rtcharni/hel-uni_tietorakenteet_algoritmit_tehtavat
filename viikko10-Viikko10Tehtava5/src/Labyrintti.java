import java.util.*;

public class Labyrintti {
    boolean[][] seinat;
    boolean[][] vierailtu;
    int lahtoY;
    int lahtoX;
    int loppuY;
    int loppuX;
    Queue<int[]> que = new LinkedList<>();
    String[][] etaisyys;
    boolean[][] ruudutKayty;

    public String etsi(char[][] laby) {
        luoSeinatJaMuut(laby);
        syvyysHaku(lahtoY, lahtoX, laby.length);
        if (vierailtu[loppuY][loppuX] == false) {
            return null;
        }
        // Leveyshaku, lyhyin reitti!
        String askeleet = leveysHaku(lahtoY, lahtoX, loppuY, loppuX, laby);
        System.out.println("Askeleet: " + askeleet);
        return askeleet;
    }

    String leveysHaku(int alkuY, int alkuX, int loppuY, int loppuX, char[][] laby) {
        etaisyys = new String[laby.length][laby[0].length];
        ruudutKayty = new boolean[laby.length][laby[0].length];

        que.add(new int[]{alkuY, alkuX});
        ruudutKayty[alkuY][alkuX] = true;
        etaisyys[alkuY][alkuX] = "";
        while (!que.isEmpty()) {
            int[] solmu = que.remove();
            if (voiYlos(solmu[0]-1, solmu[1], laby.length)) {
                que.add(new int[]{solmu[0]-1, solmu[1]});
                ruudutKayty[solmu[0]-1][solmu[1]] = true;
                etaisyys[solmu[0]-1][solmu[1]] = etaisyys[solmu[0]][solmu[1]] + "Y";
                if (loppuY == solmu[0]-1 && loppuX == solmu[1]) {
                    return etaisyys[solmu[0]][solmu[1]] + "Y"; // + 1 !!!!!!!!!!!!
                }
            }
            if (voiAlas(solmu[0]+1, solmu[1], laby.length)) {
                que.add(new int[]{solmu[0]+1, solmu[1]});
                ruudutKayty[solmu[0]+1][solmu[1]] = true;
                etaisyys[solmu[0]+1][solmu[1]] = etaisyys[solmu[0]][solmu[1]] + "A";
                if (loppuY == solmu[0]+1 && loppuX == solmu[1]) {
                    return etaisyys[solmu[0]][solmu[1]] + "A"; // + 1 !!!!!!!!!!!!
                }
            }
            if (voiVasen(solmu[0], solmu[1]-1, laby[0].length)) {
                que.add(new int[]{solmu[0], solmu[1]-1});
                ruudutKayty[solmu[0]][solmu[1]-1] = true;
                etaisyys[solmu[0]][solmu[1]-1] = etaisyys[solmu[0]][solmu[1]] + "V";
                if (loppuY == solmu[0] && loppuX == solmu[1]-1) {
                    return etaisyys[solmu[0]][solmu[1]] + "V"; // + 1 !!!!!!!!!!!!
                }
            }
            if (voiOikea(solmu[0], solmu[1]+1, laby[0].length)) {
                que.add(new int[]{solmu[0], solmu[1]+1});
                ruudutKayty[solmu[0]][solmu[1]+1] = true;
                etaisyys[solmu[0]][solmu[1]+1] = etaisyys[solmu[0]][solmu[1]] + "O";
                if (loppuY == solmu[0] && loppuX == solmu[1]+1) {
                    return etaisyys[solmu[0]][solmu[1]] + "O"; // + 1 !!!!!!!!!!!!
                }
            }
        }
        return null;
    }

    void luoSeinatJaMuut(char[][] laby) {
        vierailtu = new boolean[laby.length][laby[0].length];
        seinat = new boolean[laby.length][laby[0].length];
        for (int i = 0; i < laby.length; i++) {
            for (int j = 0; j < laby[0].length; j++) {
                if (laby[i][j] == '#') {
                    seinat[i][j] = true;
                } else if (laby[i][j] == 'x') {
                    lahtoY = i;
                    lahtoX = j;
                } else if (laby[i][j] == 'y') {
                    loppuY = i;
                    loppuX = j;
                }
            }
        }
    }

    void syvyysHaku(int y, int x, int n) {
        if (y < 0 || x < 0 || y >= n || x >= n) {
            return;
        }
        if (seinat[y][x] || vierailtu[y][x]) {
            return;
        }
        vierailtu[y][x] = true;
        syvyysHaku(y + 1, x, n);
        syvyysHaku(y - 1, x, n);
        syvyysHaku(y, x + 1, n);
        syvyysHaku(y, x - 1, n);
    }

    boolean voiYlos(int y, int x, int n) {
        if (y < 0) {
            return false;
        }
        if (seinat[y][x] || ruudutKayty[y][x]) { // || ruudutKayty[y][x]
            return false;
        }
        return true;
    }
    boolean voiAlas(int y, int x, int n) {
        if (y >= n) {
            return false;
        }
        if (seinat[y][x] || ruudutKayty[y][x]) { // || ruudutKayty[y][x]
            return false;
        }
        return true;
    }
    boolean voiVasen(int y, int x, int n) {
        if (x < 0) {
            return false;
        }
        if (seinat[y][x] || ruudutKayty[y][x]) { // || ruudutKayty[y][x]
            return false;
        }
        return true;
    }
    boolean voiOikea(int y, int x, int n) {
        if (x >= n) {
            return false;
        }
        if (seinat[y][x] || ruudutKayty[y][x]) { // || ruudutKayty[y][x]
            return false;
        }
        return true;
    }
}
