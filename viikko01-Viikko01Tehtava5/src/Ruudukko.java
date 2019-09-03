import java.util.*;

public class Ruudukko {
    int[][] muodosta(int n) {
        int [][] table = new int[n][n];
        // table[0][0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    table[i][j] = 0;
                } else {

                    int numToPut = 0;
                    while (true) {
                        start:
                        for (int k = 0; k < j; k++) {
                            if (numToPut == table[i][k]) {
                                numToPut++;
                                continue start;
                            }
                        }

                        for (int q = 0; q < i; q++) {
                            if (numToPut == table[q][j]) {
                                numToPut++;
                                continue start;
                            }
                        }

                        if (gotTillEnd == true) {
                            table[i][j] = numToPut;
                            break;
                        }
                    }
                }
            }
        }
        return table;
    }
}
