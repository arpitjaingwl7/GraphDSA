package codes;

import java.util.ArrayList;

public class cycleDetectionUndirected {
    static boolean flag=false;
    public static void main(String[] args) {
        
    }
     public void dfs(int V,ArrayList<ArrayList<Integer>> adj,int[]vis,int p,int x){
        
        vis[x]=1;
        if(flag==true){
            return;
        }
        // vis[x]=1;
        
        
        for(int i:adj.get(x)){
            if(vis[i]==1){
                if(p!=i){
                    flag=true;
                    break;
                }
                // else{
                //     return;
                // }
            }
            else{
                
                // vis[i]=1;
                dfs(V,adj,vis,x,i);
                
            }
        }
        
    }
}
