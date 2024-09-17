package codes;

import java.util.ArrayList;

public class CycleDetectionDirected {
    public static void main(String[] args) {

    }

    boolean flag = false;

    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        int vis[] = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] != 1) {
                dfs(V, adj, vis, i);
            }
        }
        return flag;

    }

    public void dfs(int V, ArrayList<ArrayList<Integer>> adj, int[] vis, int x) {
        if (flag) {
            return;
        }

        vis[x] = 1;

        for (int i : adj.get(x)) {
            if (vis[i] == 1) {
                flag = true;
                break;
            } else if (vis[i] == 0) {
                dfs(V, adj, vis, i);
            }

        }

        vis[x] = 2;

    }

}
