package codes;

import java.util.*;

public class createGraph1 {

  public static void main(String[] args) {
 
    Graph g1=createUndirectedGraph();
    g1.printGraph();
  }

  // Fuction That create a undirected Graph
  public static Graph createUndirectedGraph() {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Number of Nodes ");
    int n = sc.nextInt();
    Graph g1 = new Graph(n);

    System.out.println("Enter Number of Endges");
    int e = sc.nextInt();

    for (int i = 1; i <= e; i++) {
      System.out.println("enter the " + i + "numberth edge");
      int u = sc.nextInt();
      int v = sc.nextInt();
      g1.addEdge(u, v, false);

    }
    sc.close();

    return g1;

  }

   // Fuction That create a Directed Graph

   public static Graph createDirectedGraph() {

    Scanner sc = new Scanner(System.in);

    System.out.println("Enter Number of Nodes ");
    int n = sc.nextInt();
    Graph g1 = new Graph(n);

    System.out.println("Enter Number of Endges");
    int e = sc.nextInt();

    for (int i = 1; i <= e; i++) {
      System.out.println("enter the " + i + "numberth edge");
      int u = sc.nextInt();
      int v = sc.nextInt();
      g1.addEdge(u, v, true);

    }
    sc.close();

    return g1;

  }


}

class Graph {
  HashMap<Integer, List<Integer>> adj;

  Graph(int nodes) {
    adj = new HashMap<>();
    for (int i = 0; i < nodes; i++) {
      adj.put(i, new ArrayList<>());
    }

  }

  public void addEdge(int u, int v, boolean dir) {
    // dir=true->directed
    // dir=false->non directed
    this.adj.get(u).add(v);
    if (!dir) {
      this.adj.get(v).add(u);
    }
  }

  public void printGraph() {

    System.out.println("Your Graph Is-");

    for (int i = 0; i < adj.size(); i++) {
      for (int j : adj.get(i)) {

        System.out.println(i + "-->" + j);
      }
    }

  }

}
