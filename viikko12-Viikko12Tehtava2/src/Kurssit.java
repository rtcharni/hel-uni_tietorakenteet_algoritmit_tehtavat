import java.util.*;

public class Kurssit {
    ArrayList<String> kurssit = new ArrayList<>();
    HashMap<String, ArrayList<String>> vaatimukset = new HashMap<>();
    HashSet<String> käytyKurssit = new HashSet<>();
    ArrayList<String> tämäKierros = new ArrayList<>();
    ArrayList<String> järjestys = new ArrayList<>();
    boolean sykliLöytyi = false;

    public Kurssit() {
    }

    public void lisaaKurssi(String s) {
        if (!kurssit.contains(s)) {
            kurssit.add(s);
            vaatimukset.put(s, new ArrayList<>());
        } else {
        }
    }

    public void lisaaVaatimus(String a, String b) {
        vaatimukset.get(a).add(b);
    }

    public ArrayList<String> muodosta() {
        for (int i = 0; i < kurssit.size(); i++) {
            String kurssi = kurssit.get(i);
            syvyysHaku(vaatimukset.get(kurssi), kurssi);
            // komponentti käyty, tsekataan kaikki erikseen.
        }

        if (sykliLöytyi) {
            return null;
        } else {
            Collections.reverse(järjestys);
            return järjestys;
        }
    }

    void syvyysHaku(ArrayList<String> verkko, String kurssi) {
        if (tämäKierros.contains(kurssi)) {
            System.out.println("SYKLI!! Palautetaan NULL");
            sykliLöytyi = true;
            return;
        }
        if (käytyKurssit.contains(kurssi)) {
            return;
        }
        käytyKurssit.add(kurssi);
        tämäKierros.add(kurssi);

//        kaytyVerkot[verkkoNum] = true;
//        kaytyKoneet[verkkoNum] = true;
        for (String k : verkko) {
            syvyysHaku(vaatimukset.get(k), k);
//            if (!kaytyKoneet[s]) {
//                kaytyKoneet[s] = true;
//                syvyysHaku(verkot[s], s);
//            } else {
//                syvyysHaku(verkot[s], s);
//            }
        }
        järjestys.add(kurssi);
        tämäKierros.remove(kurssi);
    }

}
