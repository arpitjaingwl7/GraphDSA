package codes;

import java.util.*;

public class CycleDetectionUsingTopoSortDirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] inDegree = new int[V];
        int x = 0;

        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                inDegree[j]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (q.size() != 0) {
            int temp = q.remove();
            x++;

            for (int i : adj.get(temp)) {
                inDegree[i]--;
                if (inDegree[i] == 0) {
                    q.add(i);
                }
            }
        }

        return x != V;
    }
}