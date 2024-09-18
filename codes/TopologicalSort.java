package codes;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
public static void main(String[] args) {
    
}

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        
        Stack<Integer>st=new Stack<>();
        int []ans=new int[V];
        int[]vis=new int[V];
        
        for(int i=0;i<V;i++){
            if(vis[i]!=1){
                  dfs(adj,vis,i,st);  
            }
        
        }
        
        int x=0;
        while(st.size()!=0){
            ans[x]=st.pop();
            x++;
        }
        
        return ans;
        
    }
    public static void dfs( ArrayList<ArrayList<Integer>> adj,int[]vis,int x,Stack<Integer>st){
        
        vis[x]=1;
        
        
        for(int i:adj.get(x)){
            if(vis[i]!=1){
                dfs(adj,vis,i,st);
            }
        }
        st.push(x);
    }
}
