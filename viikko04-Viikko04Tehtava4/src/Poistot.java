import java.util.ArrayList;

public class Poistot {
    private int tulos = 0;

    int laske(int[] t) {
        this.tulos = 0;

        ArrayList list = new ArrayList();
        boolean jatka = false;
        boolean onlyOne = false;
        int last;
        if (t.length != 0) {
            last = t[0];
        } else {
            return 0;
        }

        if (t.length == 1) {
            list.add(t[0]);
            onlyOne = true;
        }

        for (int i = 1; i < t.length; i++) {
            if (onlyOne) {
                break;
            }

            if (t[i] == last) {
                if (i == t.length - 1) {
                    continue;
                }
                last = t[i + 1];
                i++;
                jatka = true;

                if (i == t.length - 1) {
                    list.add(t[i]);
                }
            } else {
                list.add(t[i - 1]);
                last = t[i];
                if (i == t.length - 1) {
                    list.add(t[i]);
                }
            }
        }

        if (!jatka) {
            System.out.println("oikea tulos" + list.size());
            this.tulos = list.size();
            return list.size();
        } else {
            laske(list.stream().mapToInt(i -> (int) i).toArray());
        }
        return this.tulos;
    }    
}
