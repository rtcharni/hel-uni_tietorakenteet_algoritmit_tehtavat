public class Alijonot {
    int[] pisin;

    public long laske(int[] t) {
        pisin = new int[t.length];
        laskeTaulukko(t.length, t);
        int biggest = 0;
        for (int i = 0; i < pisin.length; i++) {
//            System.out.println(pisin[i]);
            if (pisin[i] > biggest) {
                biggest = pisin[i];
            }

        }
        return biggest;
    }

    void laskeTaulukko(int n, int[] taulu) {
        for (int k = 0; k < n; k++) {
            pisin[k] = 1;
            for (int x = 0; x < k; x++) {
                if (Math.abs(taulu[x] - taulu[k]) == 1 && pisin[x]+1 > pisin[k]) {
                    pisin[k] = pisin[x]+1;
                }
            }
        }
    }
}

//for k = 0 to n-1
//        pisin[k] = 1
//        for x = 0 to k-1
//        if taulu[x] < taulu[k] and pisin[x]+1 > pisin[k]
//        pisin[k] = pisin[x]+1