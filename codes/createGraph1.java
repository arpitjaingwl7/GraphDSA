package codes;

import java.util.*;

public class createGraph1 {

  public static void main(String[] args) {
    
    Graph<Integer> g1 = createUndirectedGraph();
    g1.printGraph();
  }

  // Function to create an undirected graph
  public static Graph<Integer> createUndirectedGraph() {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Number of Nodes ");
    int n = sc.nextInt();
    Graph<Integer> g1 = new Graph<>();

    System.out.println("Enter Number of Edges");
    int e = sc.nextInt();

    for (int i = 1; i <= e; i++) {
      System.out.println("Enter the " + i + "th edge");
      int u = sc.nextInt();
      int v = sc.nextInt();
      g1.addEdge(u, v, false);
    }

    sc.close();
    return g1;
  }

  // Function to create a directed graph
  public static Graph<Integer> createDirectedGraph() {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Number of Nodes ");
    int n = sc.nextInt();
    Graph<Integer> g1 = new Graph<>();

    System.out.println("Enter Number of Edges");
    int e = sc.nextInt();

    for (int i = 1; i <= e; i++) {
      System.out.println("Enter the " + i + "th edge");
      int u = sc.nextInt();
      int v = sc.nextInt();
      g1.addEdge(u, v, true);
    }

    sc.close();
    return g1;
  }
}

class Graph<T> {
  private Map<T, List<T>> adj;

  public Graph() {
    adj = new HashMap<>();
  }

  public void addEdge(T u, T v, boolean dir) {
    adj.putIfAbsent(u, new ArrayList<>());
    adj.get(u).add(v);

    if (!dir) {
      adj.putIfAbsent(v, new ArrayList<>());
      adj.get(v).add(u);
    }
  }

  public void printGraph() {
    System.out.println("Your Graph Is:");

    for (T node : adj.keySet()) {
      for (T neighbor : adj.get(node)) {
        System.out.println(node + " --> " + neighbor);
      }
    }
  }
}
