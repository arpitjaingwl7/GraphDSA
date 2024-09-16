package codes;
import java.util.*;

public class bfs2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph<Integer>g1= createGraph1.createUndirectedGraph(sc);
        g1.printGraph();
        bfs(g1,0);

    }
    public static void bfs(Graph g1, int initialPoint){

        Map<Integer,List<Integer>> adj=g1.adj;

        Queue<Integer>q=new ArrayDeque<>();
        int[] vis=new int [adj.size()];
        
        q.add(initialPoint);

        // while(q.size()>0){
        //     int x=q.remove();
        //     vis[x]=1;
        //     System.out.println(x);

        //     for(int i=0;i<adj.get(x).size();i++){
        //         int j=adj.get(x).get(i);
        //         if(vis[j]!=0){
        //             q.add(j);
        //         }
        //     }
        // }
        System.out.println("adj "+adj.get(0));
        System.out.println("adjList"+ adj);

    }
}
