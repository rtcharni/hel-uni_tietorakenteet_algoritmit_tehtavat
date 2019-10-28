import java.util.*;

public class Merkkijonot {  
    int startChar = 65;
    ArrayList<String> list;
    public ArrayList<String> muodosta(int n, int k) {
        list = new ArrayList<>();
        haku("", n, k);
        return list;

    }

    void haku(String s, int n, int k) {
        if (s.length() == n) {
            list.add(s);
        } else {
            for (int i = startChar; i < startChar + k ; i++) {
                char temp = (char)i;
                haku(s + Character.toString(temp), n, k);
            }
        }
    }
}
