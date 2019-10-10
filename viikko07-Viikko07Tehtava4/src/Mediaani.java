import java.util.*;

public class Mediaani {
    PriorityQueue<Integer> min = new PriorityQueue<>();
    PriorityQueue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());

    public void lisaa(int x) {
        min.add(x);
        max.add(min.poll());
        if(min.size()<max.size()){
            min.add(max.poll());
        }
    }
    
    public int mediaani() {
        if (min.size() > max.size()) {
            return min.peek();
        } else {
            return max.peek();
        }
    }
}
