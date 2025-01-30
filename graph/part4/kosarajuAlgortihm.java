// kosarju's algortihm implementation
import java.util.*;
public class KosarajuAlgorithm
{
    static class Edge
    {
        int src;
        int dest;
        public Edge(int src,int dest)
        {
            this.src = src;
            this.dest = dest;
        }
    }
    public static void topSort(ArrayList<Edge>graph[],Stack<Integer> st, boolean vist[],int curr)
    {
        vist[curr] = true;
        for(int i = 0 ; i < graph[curr].size();i++)
        {
            Edge edge = graph[curr].get(i);
            if(!vist[edge.dest])
            { topSort(graph,st,vist,edge.dest);  }
        }
        st.add(curr);
    }
    public static void dfs(ArrayList<Edge>reverse[] ,boolean vist[],int curr)
    {
        System.out.print(curr);
        vist[curr] = true;
        for(int i = 0; i < reverse[curr].size(); i++)
        {
            Edge e = reverse[curr].get(i);
            if(!vist[e.dest])
            {
                dfs(reverse,vist,e.dest);
            }
        }
    }

    public static void kosarajuAlgorithm(ArrayList<Edge>graph[])
    {
        // peform topological sort
        int v = graph.length;
        Stack<Integer> st = new Stack<>();
        boolean vist[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++)
        {
            if(!vist[i])
            { topSort(graph,st,vist,i); }
        }
        // reverse the graph;
         ArrayList<Edge> reverse [] = new ArrayList[v];
         for(int i = 0; i < v; i++)
         {
            reverse[i] = new ArrayList<>();
         }
         for(int i = 0; i < v; i++)
         {
            for(int j = 0;  j< graph[i].size(); j++)
            {
                
                Edge edge = graph[i].get(j);
                int src = edge.src;
                int dest = edge.dest;
               reverse[dest].add(new Edge(dest,src));

            }
         }

        
        // set false vist array for reuse;
        for(int k = 0; k < vist.length; k++)
        {
            vist[k] = false;
        }
        // peform the dfs on the basic of the stack node;
         while(! st.isEmpty())
         {
            int ele = st.pop();
           
           if(!vist[ele])
           { 
             System.out.print("scc -->");
            dfs(reverse,vist,ele);
            }
           System.out.println();

         }



    }


    // create graph 
    public static void createGraph(ArrayList<Edge> graph[])
    {
          for(int i = 0; i < graph.length; i++)
        {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[1].add(new Edge(1,0));
        graph[2].add(new Edge(2,1));
        graph[3].add(new Edge(3,4));
    }
   public static void main(String args[])
    {
        // create the grahp
        int v = 5;
        ArrayList<Edge> graph[] =  new ArrayList[v];
        createGraph(graph);
         kosarajuAlgorithm(graph);

    }
}