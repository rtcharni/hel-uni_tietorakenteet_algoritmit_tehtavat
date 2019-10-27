import java.util.*;

public class Merkkijonot {
    ArrayList<String> list;
    public ArrayList<String> muodosta(int n) {
        list = new ArrayList();
        haku("", n);

        return list;

    }

    void haku(String s, int n) {
        if (s.length() == n) {
            list.add(s);
        } else {
            //for (int i = 1; i <= 2 ; i++) {
                haku(s + "A", n);
                haku(s + "B", n);
            //}
        }


    }
}
