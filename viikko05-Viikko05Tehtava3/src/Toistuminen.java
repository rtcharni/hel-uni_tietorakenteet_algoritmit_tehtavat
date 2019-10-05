import java.util.*;

public class Toistuminen {
    HashMap<Integer, Integer> map = new HashMap();
    HashSet<Integer> set = new HashSet();
    //List<Integer> list = new ArrayList();
    int index = 1;

    int uusiLuku(int x) {
        if (set.contains(x)) {
            // on luku
            int diff = index - map.get(x) - 1;
            map.put(x, index);
            index++;
            return diff;
//            int count = 0;
//            for (int i = list.size() - 1; i >= 0; i--) {
//                if (list.get(i) != x) {
//                    count++;
//                } else {
//                    list.add(x);
//                    return count;
//                }
//            }
        } else {
            // ei ole lukua
            set.add(x);
            //list.add(x);
            map.put(x, index);
            index++;
            return -1;
        }

    }
}
