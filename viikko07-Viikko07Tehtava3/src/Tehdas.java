import java.util.*;

public class Tehdas {

    public long laske(int[] t, int x) {
        PriorityQueue<Pair> que1 = new PriorityQueue<>();

        for (int i = 0; i < t.length; i++) {
             que1.add(new Pair(t[i], t[i]));
        }
        int ready = 0;
        while (true) {
            Pair c = que1.poll();
            ready++;
            if (ready == x) {
                return c.getNextCompletes();
            } else {
                c.setNextCompletes(c.getTimeToComplete() + c.getNextCompletes());
                que1.add(c);
            }
        }
    }

    
}

class Pair implements Comparable<Pair> {
    private long timeToComplete;
    private long nextCompletes;

    public Pair(long timeToComplete, long nextCompletes) {
        this.timeToComplete = timeToComplete;
        this.nextCompletes = nextCompletes;
    }

    public long getTimeToComplete() {
        return timeToComplete;
    }

    public void setTimeToComplete(long timeToComplete) {
        this.timeToComplete = timeToComplete;
    }

    public long getNextCompletes() {
        return nextCompletes;
    }

    public void setNextCompletes(long nextCompletes) {
        this.nextCompletes = nextCompletes;
    }

    public int compareTo(Pair pair) {
        if(this.getNextCompletes() > pair.getNextCompletes()) {
            return 1;
        } else if (this.getNextCompletes() < pair.getNextCompletes()) {
            return -1;
        } else {
            return 0;
        }
    }


}
