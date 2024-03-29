import java.util.*;

public class Polut {
    int total;

    public int laske(int n) {
        total = 0;
        boolean[][] taulu = new boolean[n][n];
        if (n == 1) {
            return 1;
        } else {
            haku(0, 0, taulu, n, 1);
            return total * 2;
        }
    }

    void haku(int y, int x, boolean[][] taulu, int n, int askel) {
        if (askel == n * n) {
            total++;
        } else {
            taulu[y][x] = true;
            if (y == 0 && x == 0) {
                haku(y + 1, x, taulu, n, askel + 1);
            } else {
                if (impossible(taulu, n, y, x)) {

                } else {
                    if (moveLeft(taulu, n, y, x)) {
                        //boolean[][] copy = deepCopy2(taulu);
                        //taulu[y][x - 1] = true;
                        haku(y, x - 1, taulu, n, askel + 1);
                    }
                    if (moveRight(taulu, n, y, x)) {
                        //boolean[][] copy = deepCopy2(taulu);
                        //taulu[y][x + 1] = true;
                        haku(y, x + 1, taulu, n, askel + 1);
                    }
                    if (moveUp(taulu, n, y, x)) {
                        //boolean[][] copy = deepCopy2(taulu);
                        //taulu[y - 1][x] = true;
                        haku(y - 1, x, taulu, n, askel + 1);
                    }
                    if (moveDown(taulu, n, y, x)) {
                        //boolean[][] copy = deepCopy2(taulu);
                        //taulu[y + 1][x] = true;
                        haku(y + 1, x, taulu, n, askel + 1);
                    }
                }
            }
            taulu[y][x] = false;

        }
    }

    boolean impossible(boolean[][] taulu, int length, int y, int x) {
        boolean left = moveLeft(taulu, length, y, x);
        boolean right = moveRight(taulu, length, y, x);
        boolean up = moveUp(taulu, length, y, x);
        boolean down = moveDown(taulu, length, y, x);

        if (left && right && !up && !down) {
            return true;
        } else if (!left && !right && up && down) {
            return true;
        }
        return false;
    }

    boolean moveLeft(boolean[][] taulu, int length, int y, int x) {
        if (x == 0) {
            return false;
        }
        if (taulu[y][x - 1] == true) {
            return false;
        }
        return true;
    }

    boolean moveRight(boolean[][] taulu, int length, int y, int x) {
        if (x == length - 1) {
            return false;
        }
        if (taulu[y][x + 1] == true) {
            return false;
        }
        return true;
    }

    boolean moveUp(boolean[][] taulu, int length, int y, int x) {
        if (y == 0) {
            return false;
        }
        if (taulu[y - 1][x] == true) {
            return false;
        }
        return true;
    }

    boolean moveDown(boolean[][] taulu, int length, int y, int x) {
        if (y == length - 1) {
            return false;
        }
        if (taulu[y + 1][x] == true) {
            return false;
        }
        return true;
    }

//    boolean ruudutTaynna(boolean[][] taulu, int length) {
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < length; j++) {
//                if (!taulu[i][j]) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

    boolean[][] deepCopy(boolean[][] matrix) {
        return java.util.Arrays.stream(matrix).map(el -> el.clone()).toArray($ -> matrix.clone());
    }

    boolean[][] deepCopy2(boolean[][] original) {
        if (original == null) {
            return null;
        }

        final boolean[][] result = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
        }
        return result;
    }
}
