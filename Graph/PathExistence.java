//problem statement:
//Given an undirected graph represented as an edge list and two nodes (source and destination), 
//determine if there is a valid path between the source and destination nodes.

//time complexity:O(V+E)
//space complexity:O(V) (for recursion stack and visited array)

//code
//DFS approach
import java.util.ArrayList;

public class PathExistence{
	public boolean validPath(int n, int[][] edges, int source, int destination) {
        //create the adjacency list
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        //fill the adjacency list
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            //add the neighbors of each node
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //take a visited array
        boolean[] visited=new boolean[n];

        return dfs(source, destination, graph, visited);
    }

    static boolean dfs(int src, int dest, ArrayList<ArrayList<Integer>> graph, boolean[] visited){
        if(src==dest) return true;

        visited[src]=true;
        for(int neigh: graph.get(src)){
            if(visited[neigh]==false){
                if(dfs(neigh,dest,graph,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    //main method
    public static void main(String[] args) {
        PathExistence pe=new PathExistence();
        int n=3;
        int[][] edges={{0,1},{1,2},{2,0}};
        int source=0;
        int destination=2;
        System.out.println(pe.validPath(n, edges, source, destination)); 
    }
}

//output:
//true