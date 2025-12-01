// Implement Dijkstra’s algorithm to find the shortest path from a source vertex to all other vertices in a weighted graph. Use both adjacency matrix and adjacency list representations for the graph. Ensure the algorithm handles negative weights appropriately.

import java.util.*;

class Edge {
    int dest, weight;
    Edge(int d, int w) { dest = d; weight = w; }
}

public class Q16 {

    static final int INF = 999999;

    // Dijkstra Using Adjacency Matrix

    static int minDistance(int[] dist, boolean[] visited, int V) {
        int min = INF, minIndex = -1;
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dist[i] <= min) {
                min = dist[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    static void dijkstraMatrix(int[][] graph, int src) {

        int V = graph.length;

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                if (graph[i][j] < 0)
                    throw new IllegalArgumentException(" Dijkstra does NOT support negative weight edges!");

        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited, V);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("\n Dijkstra (Adjacency Matrix):");
        for (int i = 0; i < V; i++)
            System.out.println(src + " → " + i + " = " + dist[i]);
    }

    static void dijkstraList(List<List<Edge>> graph, int src) {

        int V = graph.size();

        for (List<Edge> edges : graph)
            for (Edge e : edges)
                if (e.weight < 0)
                    throw new IllegalArgumentException(" Dijkstra does NOT support negative weight edges!");

        int[] dist = new int[V];
        Arrays.fill(dist, INF);

        dist[src] = 0;

        PriorityQueue<int[]> pq =
                new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        pq.add(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];

            if (d > dist[u]) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.dest;
                int weight = edge.weight;

                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                }
            }
        }

        System.out.println("\n Dijkstra (Adjacency List):");
        for (int i = 0; i < V; i++)
            System.out.println(src + " → " + i + " = " + dist[i]);
    }

    public static void main(String[] args) {

        System.out.println("RASHI YADAV "); 
        System.out.println("2401350003 ");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        int[][] matrix = new int[V][V];
        List<List<Edge>> list = new ArrayList<>();

        for (int i = 0; i < V; i++)
            list.add(new ArrayList<>());

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        System.out.println("\nEnter edges: u v weight");

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            matrix[u][v] = w;
            matrix[v][u] = w; 

            list.get(u).add(new Edge(v, w));
            list.get(v).add(new Edge(u, w));
        }

        System.out.print("\nEnter source vertex: ");
        int src = sc.nextInt();

        System.out.println("\n============== MENU ==============");
        System.out.println("1. Dijkstra Using Adjacency Matrix");
        System.out.println("2. Dijkstra Using Adjacency List");
        System.out.println("3. Exit");
        System.out.println("==================================");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        try {
            switch (choice) {
                case 1:
                    dijkstraMatrix(matrix, src);
                    break;

                case 2:
                    dijkstraList(list, src);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
        catch (IllegalArgumentException e) {
            System.out.println("\n ERROR: " + e.getMessage());
            System.out.println("👉 Use Bellman-Ford for negative weights.");
        }
    }
}
