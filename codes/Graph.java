package codes;
import java.util.*;

// Generic Graph class
class Graph<T> {
     Map<T, List<T>> adj;
  
    public Graph() {
      adj = new HashMap<>();
    }
  
    public void addEdge(T u, T v, boolean dir) {
      adj.putIfAbsent(u, new ArrayList<>());
      adj.get(u).add(v);
  
      if (!dir) { // For undirected graph
        adj.putIfAbsent(v, new ArrayList<>());
        adj.get(v).add(u);
      }
    }
  
    public void printGraph() {
      System.out.println("Your Graph:");
  
      for (T node : adj.keySet()) {
        System.out.print(node + " --> " );
        for (T neighbor : adj.get(node)) {
          System.out.print( neighbor+", ");
        }
        System.out.println();
      }
    }
  }
  
