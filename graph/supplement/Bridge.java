import java.util.*;
public class Bridge
{
    
    static class Edge
    {
        int src, dest;
        public Edge(int src,int dest)
        {
            this.src =src;
            this.dest = dest;
        }
    }
    public static void dfs(ArrayList<Edge> graph[],int curr,int par, int time,int low[],int dt[],boolean vist[])
    {
       
         vist[curr] = true;
         low[curr] = time;
         dt[curr] = time;
         for(int i = 0; i < graph[curr].size();i++)
         {
            Edge e = graph[curr].get(i);
            int nav = e.dest;
            if(par == nav)
            { continue;}
            else if(!vist[nav])
            {
                dfs(graph,nav,curr,time++,low,dt,vist);
                low[curr] = Math.min(low[curr],low[nav]);
                if(dt[curr] < low[nav])
                {
                 System.out.println("enter");
                    System.out.println("the bridge"+curr+"----"+nav);
                }
            }
            else 
            { 
                low[curr] = Math.min(low[curr],dt[nav]);
            }
         }
        
    }

    public static void  findBridge(ArrayList<Edge>graph[])
    {
        boolean vist[] = new boolean[graph.length];
        int low[] = new int[graph.length];
        int dt[] = new int[graph.length];
        int time = 0;
      for(int i = 0; i < graph.length; i++)
        {
            if(!vist[i])
            {
                 dfs(graph,i,-1,time++,low,dt,vist);
            }
        }
        

    }
    public static void main(String args[])
    {
        // here creating the graph
        int size = 5;
        ArrayList<Edge>graph[] = new ArrayList[size];
        for(int i = 0; i<size; i++ )
        {
            graph[i] = new ArrayList<>();
        }
        // graph[0].add(new Edge(0,1));
        // graph[0].add(new Edge(0,2));
        // graph[0].add(new Edge(0,3));

        // graph[1].add(new Edge(1,2));
        // graph[1].add(new Edge(1,0));

        // graph[2].add(new Edge(2,0));
        // graph[2].add(new Edge(2,1));

        // graph[3].add(new Edge(3,5));
        // graph[3].add(new Edge(3,0));
        // graph[3].add(new Edge(3,4));

        // graph[4].add(new Edge(4,3));
        // graph[4].add(new Edge(4,5));
        
        // graph[5].add(new Edge(5,3));
        // graph[5].add(new Edge(5,4));



          graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,0));

        graph[4].add(new Edge(4,3));
     
        
     
        findBridge(graph);

    }
}