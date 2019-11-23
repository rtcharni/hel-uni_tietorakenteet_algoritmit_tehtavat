import java.util.*;

public class Kierrokset {
    ArrayList<Kaari> kaaret;
    int[] etaisyys;

    public Kierrokset() {
    }

    public ArrayList<Kaari> muodosta(int x) {
        kaaret = new ArrayList<>();
        etaisyys = new int[101];
        if (x == 1) {
            for (int i = 1; i <= 100; i++) {
                kaaret.add(new Kaari(i, i, 100));
            }
        } else {
            for (int i = 1; i < 100; i++) {
                kaaret.add(new Kaari(i, i + 1, 100));
            }
            int loops = 0;
            for (int i = 99; i >= 2; i--) {
                if (loops == x - 2) {
                    break;
                }
                int temp = i - 1;
                kaaret.add(new Kaari(temp, i, 50));
                loops++;
            }
        }


//        kaaret.add(new Kaari(5,6,50));
//        kaaret.add(new Kaari(4,5,50));
//        kaaret.add(new Kaari(3,4,50));
        ArrayList arr = BellmanFord(x);
        return arr;

    }

    ArrayList BellmanFord(int x) {
        ArrayList arr = new ArrayList();
        int kierros = 1;
        while (true) {
            System.out.println(kierros);
            kierros++;
            boolean muutos = false;
            for (Kaari kaari : kaaret) {
//                System.out.println("Käsittelen kaarta: " + kaari.toString());
                int nyky = etaisyys[kaari.loppu];
                int uusi = etaisyys[kaari.alku] + kaari.pituus;
                if (x == 1) {
                    if (uusi < nyky) {
                        System.out.println("Muutos: " + kaari.toString());
                        arr.add(kaari);
                        etaisyys[kaari.loppu] = uusi;
                        muutos = true;
                    }
                } else {
                    if (nyky == 0 || uusi < nyky) {
                        System.out.println("Muutos: " + kaari.toString());
                        arr.add(kaari);
                        etaisyys[kaari.loppu] = uusi;
                        muutos = true;
                    }
                }
            }
            if (muutos == false) {
                break;
            }
        }
        return arr;
    }
}


//kaaret.add(new Kaari(1,2,10));
//        kaaret.add(new Kaari(1,3,1));
//        kaaret.add(new Kaari(2,4,1));
//        kaaret.add(new Kaari(3,2,1));
