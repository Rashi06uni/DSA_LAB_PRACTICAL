//Implement  Prim's and Kruskal’s algorithm to find the minimum spanning tree of a graph. 

import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    Edge(int s, int d, int w) {
        src = s;
        dest = d;
        weight = w;
    }

    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class Pair {
    int node, weight;

    Pair(int n, int w) {
        node = n;
        weight = w;
    }
}

public class Q15 {

    int vertices;
    List<List<Pair>> adjList;   
    List<Edge> edges;           

    int[] parent, rank;         

    Q15(int v) {
        vertices = v;

        adjList = new ArrayList<>();
        edges = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adjList.add(new ArrayList<>());

        parent = new int[v];
        rank = new int[v];
        for (int i = 0; i < v; i++)
            parent[i] = i;
    }

    void addEdge(int u, int v, int w) {
        
        adjList.get(u).add(new Pair(v, w));
        adjList.get(v).add(new Pair(u, w));

        edges.add(new Edge(u, v, w));
    }

    // KRUSKAL FUNCTIONS

    int find(int node) {
        if (parent[node] != node)
            parent[node] = find(parent[node]);
        return parent[node];
    }

    void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        if (rootU != rootV) {
            if (rank[rootU] < rank[rootV])
                parent[rootU] = rootV;
            else if (rank[rootU] > rank[rootV])
                parent[rootV] = rootU;
            else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    void kruskalMST() {
        Collections.sort(edges);

        System.out.println("\n=== Kruskal's Minimum Spanning Tree ===");

        int totalCost = 0;

        for (Edge e : edges) {
            int uRoot = find(e.src);
            int vRoot = find(e.dest);

            if (uRoot != vRoot) {  
                System.out.println(e.src + " - " + e.dest + " : " + e.weight);
                totalCost += e.weight;
                union(uRoot, vRoot);
            }
        }

        System.out.println("Total Minimum Cost = " + totalCost);
    }

    // PRIM FUNCTIONS 

    void primMST(int start) {
        boolean[] visited = new boolean[vertices];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        pq.add(new Pair(start, 0));

        int totalCost = 0;

        System.out.println("\n=== Prim's Minimum Spanning Tree ===");

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (visited[p.node]) continue;

            visited[p.node] = true;
            totalCost += p.weight;

            System.out.println("Include Node " + p.node + " with Weight " + p.weight);

            for (Pair neighbor : adjList.get(p.node)) {
                if (!visited[neighbor.node]) {
                    pq.add(new Pair(neighbor.node, neighbor.weight));
                }
            }
        }

        System.out.println("Total Minimum Cost = " + totalCost);
    }

    public static void main(String[] args) {

        System.out.println("RASHI YADAV "); 
        System.out.println("2401350003 ");

        Q15 g = new Q15(5);

        g.addEdge(0, 1, 2);
        g.addEdge(0, 3, 6);
        g.addEdge(1, 2, 3);
        g.addEdge(1, 3, 8);
        g.addEdge(1, 4, 5);
        g.addEdge(2, 4, 7);
        g.addEdge(3, 4, 9);

        g.primMST(0);      
        g.kruskalMST();    
    }
}
