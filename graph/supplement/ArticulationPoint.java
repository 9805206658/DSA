import java.util.*;
public class ArticulationPoint
{
    static class Edge
   {
    int src,dest;
    public Edge(int s,int d )
    {
        this.src = src;
        this.dest = d;
    }

   }

   public static void dfs(ArrayList<Edge>graph[],int par,int curr,int time,int dt[],int low[],boolean vist[],boolean ap[])
   {
    vist[curr] = true;
    dt[curr] = low[curr] = time ++;
    int children = 0;
    for(int i = 0; i < graph[curr].size();i++)
    {
        Edge e = graph[curr].get(i);
        int nav = e.dest;
        if(nav == par)
        {
            continue;
        }
         else if(!vist[nav])
         {
           
            dfs(graph,curr,nav,time,dt,low,vist,ap);
            low[curr] = Math.min(low[curr],dt[nav]);
            // checking articualtion point 
            if(par != -1 && dt[curr] <= low[nav])
            {
               ap[curr] = true;
            }
            children++;
         }
         else 
         {
            // back edge 
            low[curr] = Math.min(low[curr],low[nav]);

         }
    }
    //checking the another articulation point 
    if(par == -1 && children > 1)
    {
        
        ap[curr] = true;
    }

   }
    public static void findAp(ArrayList<Edge>graph[],int V)
    {
        boolean vist[] = new boolean [V];
        int dt[] = new int[V];
        int low[] = new int[V];
        boolean ap[] =new boolean[V];
        int time = 0;
    
        for(int i =0; i < V; i++)
        {
             dfs(graph,-1,i,time,dt,low,vist,ap);

        }
        for(int i= 0; i< ap.length; i++)
        {
            if(ap[i])
            {
                System.out.println(i);
            }
        }
    }
    public static void main(String args[])
    {

      int size = 5;
        ArrayList<Edge>graph[] = new ArrayList[size];
        for(int i = 0; i<size; i++ )
        { graph[i] = new ArrayList<>();
        }
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
        findAp(graph,size);
    }
}