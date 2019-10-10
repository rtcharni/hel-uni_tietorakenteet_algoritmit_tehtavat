import java.util.*;

public class Tehtavat {
    TreeMap<Integer, PriorityQueue<String>> map = new TreeMap<>();

//    TreeMap<Integer, String[]> map = new TreeMap();
    //TreeSet<Integer> set = new TreeSet();
    //PriorityQueue que = new PriorityQueue();

    public void lisaa(String nimi, int kiireellisyys) {

        if (map.containsKey(kiireellisyys)) {
            PriorityQueue<String> q = map.get(kiireellisyys);
            q.add(nimi);
            map.put(kiireellisyys, q);
        } else {
            PriorityQueue<String> q = new PriorityQueue<>();
            q.add(nimi);
            map.put(kiireellisyys, q);
        }
        //set.add(kiireellisyys);

    }
    
    public String hae() {
        int last = map.lastKey();
        //int kiir = set.last();
        String nimi = map.get(last).poll();
        if (map.get(last).size() == 0) {
            map.remove(last);
        }
        return nimi;
    }
}
