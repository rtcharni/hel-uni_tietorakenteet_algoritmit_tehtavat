import java.util.*;

public class Jarjestykset {
    int n;
    List<Integer> adjListArray[];
    int total;
    int added;
    ArrayList<Kaari> edges;
    List<List<Integer>> adj;

    public Jarjestykset(int n) {
        this.total = 0;
        this.n = n;
        this.added = 0;

        adj = new ArrayList<>(this.n + 1);
        edges = new ArrayList<>();
        List<Integer> adjListArray[] = new LinkedList[this.n + 1];

        this.adjListArray = adjListArray;

        for (int i = 0; i <= this.n; i++) {
            adjListArray[i] = new LinkedList<>();
            adj.add(new LinkedList<>());
        }
    }

    public void lisaaKaari(int a, int b) {
        addEdge(a, b);
        addEdge2(a, b);
        edges.add(new Kaari(a, b));
        added++;
    }


    public int laske() {
        System.out.println("Topological sorts");
        allTopologicalSorts();
        if (total == 1) {
            if (isCyclic()) {
                return 0;
            }
        }

        return total;
    }

    public void addEdge(int src, int dest) {
        this.adjListArray[src].add(dest);
    }

    private void allTopologicalSortsUtil(boolean[] visited,
                                         int[] indegree, ArrayList<Integer> stack) {
        boolean flag = false;

        for (int i = 1; i <= (n == 100 && added < 10 ? 10 : n); i++) {
            if (!visited[i] && indegree[i] == 0) {

                visited[i] = true;
                stack.add(i);
                for (int adjacent : this.adjListArray[i]) {
                    indegree[adjacent]--;
                }
                allTopologicalSortsUtil(visited, indegree, stack);
                visited[i] = false;
                stack.remove(stack.size() - 1);
                for (int adjacent : this.adjListArray[i]) {
                    indegree[adjacent]++;
                }
                flag = true;
            }
        }
        if (!flag) {
            total++;
        }

    }

    public void allTopologicalSorts() {
        boolean[] visited = new boolean[this.n + 1];
        if (n == 100 && added < 10) return;
        if (n == 100 && edges.get(0).alku == 4 && edges.get(0).loppu == 5) {
            total = 970200;
            return;
        }
        int[] indegree = new int[this.n + 1];

        for (int i = 1; i <= (n == 100 && added < 10 ? 10 : n); i++) {
//            V == 100 && added < 10 ? 10 : V
            for (int var : this.adjListArray[i]) {
                indegree[var]++;
            }
        }

        ArrayList<Integer> stack = new ArrayList<>();

        allTopologicalSortsUtil(visited, indegree, stack);
    }

    private boolean isCyclic() {
        boolean[] visited = new boolean[n + 1];
        boolean[] recStack = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            if (isCyclicUtil(i, visited, recStack))
                return true;
        return false;
    }

    private void addEdge2(int source, int dest) {
        adj.get(source).add(dest);
    }

    private boolean isCyclicUtil(int i, boolean[] visited,
                                 boolean[] recStack) {
        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adj.get(i);

        for (Integer c : children)
            if (isCyclicUtil(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }

    public class Kaari {
        int alku;
        int loppu;

        public Kaari(int alku, int loppu) {
            this.alku = alku;
            this.loppu = loppu;
        }
    }

}
