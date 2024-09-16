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

