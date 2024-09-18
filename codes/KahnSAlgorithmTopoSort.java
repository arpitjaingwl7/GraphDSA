package codes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class KahnSAlgorithmTopoSort {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {

        int[] ans = new int[V];
        int[] inDegree = new int[V];

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
        int ind = 0;

        while (q.size() != 0) {

            int x = q.remove();
            ans[ind] = x;
            ind++;

            for (int j : adj.get(x)) {

                inDegree[j]--;
                if (inDegree[j] == 0) {
                    q.add(j);
                }
            }

        }
        return ans;
    }

}
