package com.company;
import java.util.*;
import java.lang.*;

public class Main {

    public static int[][] makeGraph(int n, int kaaret) {
        int[][] graph = new int[n+1][n+1];
        Random r = new Random(1337);
        for (int i = 1; i <= kaaret; i++) {
            int a = r.nextInt(n)+1;
            int b = r.nextInt(n)+1;
            int p = r.nextInt(500);
            graph[a][b] = p;
        }
        return graph;
    }

    public static void main(String[] args) {
        long alku = System.nanoTime();
        long DFS = FordFulkersonDFS.calculate(makeGraph(5000, 50000), 1, 5000);
        long loppu = System.nanoTime();
        System.out.println("Ford DFS, Algoritmin tulos: "+DFS);
        System.out.println("Aikaa kului "+((loppu-alku)/1e9)+" s");


        FordFulkersonBFS bfs = new FordFulkersonBFS(5001);
        alku = System.nanoTime();
        long BFS = bfs.calculate(makeGraph(5000, 50000), 1, 5000);
        loppu = System.nanoTime();
        System.out.println("Ford BFS, Algoritmin tulos: "+BFS);
        System.out.println("Aikaa kului "+((loppu-alku)/1e9)+" s");
    }
}

class FordFulkersonDFS {
    static int visitedToken = 1;

    public static int calculate(int[][] caps, int source, int sink) {
        int n = caps.length;
        int[] visited = new int[n];

        for (int maxFlow = 0; ; ) {
            int flow = dfs(caps, visited, source, sink, Integer.MAX_VALUE);
            visitedToken++;
            maxFlow += flow;
            if (flow == 0) {
                return maxFlow;
            }
        }
    }

    private static int dfs(int[][] caps, int[] visited, int node, int sink, int flow) {
        if (node == sink) return flow;
        int[] cap = caps[node];
        visited[node] = visitedToken;

        for (int i = 0; i < cap.length; i++) {
            if (visited[i] != visitedToken && cap[i] > 0) {
                if (cap[i] < flow) flow = cap[i];
                int dfsFlow = dfs(caps, visited, i, sink, flow);
                if (dfsFlow > 0) {
                    caps[node][i] -= dfsFlow;
                    caps[i][node] += dfsFlow;
                    return dfsFlow;
                }
            }
        }
        return 0;
    }
}

class FordFulkersonBFS {
    int V;
    FordFulkersonBFS(int numOfNodes) {
        this.V = numOfNodes;
    }
    boolean bfs(int rGraph[][], int s, int t, int parent[]) {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; ++i)
            visited[i] = false;

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(s);
        visited[s] = true;
        parent[s] = -1;

        while (queue.size() != 0) {
            int u = queue.poll();
            for (int v = 0; v < V; v++) {
                if (visited[v] == false && rGraph[u][v] > 0) {
                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;
                }
            }
        }
        return (visited[t] == true);
    }

    int calculate(int graph[][], int s, int t) {
        int u, v;
        int rGraph[][] = new int[V][V];
        for (u = 0; u < V; u++)
            for (v = 0; v < V; v++)
                rGraph[u][v] = graph[u][v];

        int parent[] = new int[V];
        int max_flow = 0;
        while (bfs(rGraph, s, t, parent)) {
            int path_flow = Integer.MAX_VALUE;
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                path_flow = Math.min(path_flow, rGraph[u][v]);
            }
            for (v = t; v != s; v = parent[v]) {
                u = parent[v];
                rGraph[u][v] -= path_flow;
                rGraph[v][u] += path_flow;
            }

            max_flow += path_flow;
        }

        return max_flow;
    }
}