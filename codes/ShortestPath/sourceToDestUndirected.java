package codes.ShortestPath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class sourceToDestUndirected {

    /**
     * This function finds the shortest path between two nodes (s and t) in an undirected graph.
     * 
     * @param edges 2D array where each entry represents an undirected edge between two nodes
     * @param n     Total number of nodes in the graph
     * @param m     Total number of edges in the graph
     * @param s     The source node (1-based index)
     * @param t     The destination node (1-based index)
     * @return A LinkedList containing the shortest path from source (s) to destination (t)
     */
    public static LinkedList<Integer> shortestPath(int[][] edges, int n, int m, int s, int t) {
        // LinkedList to store the shortest path from source to destination
        LinkedList<Integer> ans = new LinkedList<>();

        // 'vis' array to track visited nodes (0 = not visited, 1 = visited)
        int[] vis = new int[n];

        // 'par' array to store the parent node of each node (for path reconstruction)
        int[] par = new int[n];

        // 'adj' is the adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize adjacency list for 'n' nodes
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Initialize the queue for BFS traversal
        Queue<Integer> q = new ArrayDeque<>();

        // Populate the adjacency list with undirected edges
        // Subtract 1 from node values to convert from 1-based to 0-based indexing
        for (int[] i : edges) {
            adj.get(i[0] - 1).add(i[1] - 1);
            adj.get(i[1] - 1).add(i[0] - 1);
        }

        // Start BFS traversal from the source node 's'
        q.add(s - 1);  // Adjust source for 0-based indexing
        vis[s - 1] = 1;  // Mark the source node as visited
        par[s - 1] = -1;  // The source node has no parent

        // Perform BFS to explore the graph and build the parent array
        while (!q.isEmpty()) {
            int x = q.remove();  // Dequeue the current node

            // Traverse all adjacent nodes of the current node
            for (int i : adj.get(x)) {
                if (vis[i] != 1) {  // If the adjacent node hasn't been visited
                    q.add(i);  // Enqueue the adjacent node
                    vis[i] = 1;  // Mark it as visited
                    par[i] = x;  // Set its parent as the current node
                }
            }
        }

        // Reconstruct the path from destination 't' back to source 's'
        int i = t - 1;  // Start from the destination (adjust for 0-based index)
        while (i != s - 1) {  // Trace back until reaching the source
            ans.add(i + 1);  // Add the node to the path (adjust back to 1-based index)
            i = par[i];  // Move to the parent node
        }

        ans.add(i + 1);  // Finally, add the source node to the path

        // The path is currently in reverse order, so reverse it
        Collections.reverse(ans);

        // Return the shortest path from source to destination
        return ans;
    }
}
