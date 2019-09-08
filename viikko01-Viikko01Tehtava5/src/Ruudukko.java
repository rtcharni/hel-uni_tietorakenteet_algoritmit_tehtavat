import java.util.*;

public class Ruudukko {
    int[][] muodosta(int n) {
        int [][] table = new int[n][n];
        // table[0][0] = 0;
        boolean[] helper = new boolean[100];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    //helper[0] = true;
                    table[i][j] = 0;
                } else {

                    for (int k = 0; k < j; k++) {
                        helper[ table[i][k] ] = true;
                    }
                    for (int k = 0; k < i; k++) {
                        helper[ table[k][j] ] = true;
                    }

                    for (int k = 0; k < helper.length; k++) {
                        if (!helper[k]) {
                            table[i][j] = k;
                            helper = new boolean[100];
                            break;
                        }
                    }



                    //table[i][j] = recursion(i, j, table, 0);
                }
            }
        }
        return table;
    }

    int recursion(int i, int j, int[][] table, int numToPut) {
        // int numToPut = 0;
        // while (true) {
            for (int k = 0; k < j; k++) {
                if (numToPut == table[i][k]) {
                    int newNum = numToPut + 1;
                    recursion(i, j, table, newNum);
                    // continue start;
                }
            }
            for (int q = 0; q < i; q++) {
                if (numToPut == table[q][j]) {
                    int newNum = numToPut + 1;
                    recursion(i, j, table, newNum);
                    // continue lol;
                }
            }

            return numToPut;

            // table[i][j] = numToPut;
            // numToPut = 0;
        // }
    }
}
