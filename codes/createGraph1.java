package codes;

import java.util.*;

public class createGraph1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // Create an undirected graph
    Graph<Character> undirectedGraph = createUndirectedGraph(sc);
    undirectedGraph.printGraph();

    // // Create a directed graph
    // Graph<Integer> directedGraph = createDirectedGraph(sc);
    // directedGraph.printGraph();

    sc.close();
  }

  // Function to create an undirected graph
  public static <T> Graph<T> createUndirectedGraph(Scanner sc) {
    System.out.println("Enter Number of Nodes: ");
    int n = sc.nextInt(); // Not used in logic, but can be used for validation

    Graph<T> graph = new Graph<>();

    System.out.println("Enter Number of Edges: ");
    int e = sc.nextInt();

    for (int i = 1; i <= e; i++) {
      System.out.println("Enter the " + i + "th edge (u and v):");
      T u = (T) sc.next(); // Reading edges as generic type (assuming T is Integer or String)
      T v = (T) sc.next();
      graph.addEdge(u, v, false);
    }

    return graph;
  }

  // Function to create a directed graph
  public static <T> Graph<T> createDirectedGraph(Scanner sc) {
    System.out.println("Enter Number of Nodes: ");
    int n = sc.nextInt(); // Not used in logic, but can be used for validation

    Graph<T> graph = new Graph<>();

    System.out.println("Enter Number of Edges: ");
    int e = sc.nextInt();

    for (int i = 1; i <= e; i++) {
      System.out.println("Enter the " + i + "th edge (u and v):");
      T u = (T) sc.next();
      T v = (T) sc.next();
      graph.addEdge(u, v, true);
    }

    return graph;
  }
}

// Generic Graph class
class Graph<T> {
  private Map<T, List<T>> adj;

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
      System.out.println(5);
    }
  }
}
