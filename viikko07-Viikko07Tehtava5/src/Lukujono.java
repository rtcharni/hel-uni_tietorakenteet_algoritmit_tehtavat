import java.util.*;

public class Lukujono {
    PriorityQueue<Long> que = new PriorityQueue<>();


    public long laske(int n) {
        que.add((long)2);
        que.add((long)3);
        que.add((long)5);
        int removed = 0;
        long lastRemoved = 0;
        while (true) {
            long c = que.poll();
            if (c == lastRemoved) {
                continue;
            } else {
                lastRemoved = c;
                removed++;
                if (removed == n) {
                    return c;
                } else {
                    que.add(c * 2);
                    que.add(c*3);
                    que.add(c*5);
                }
            }
        }





    }
}
