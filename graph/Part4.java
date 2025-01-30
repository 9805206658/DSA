import java.util.*;
public class Part4
{ static class Edge
    {
        int src;
        int des;
        int weight;
        public Edge(int s,int d,int weight)
        {
            this.src = s;
            this.des = d;
            this.weight = weight;
        }
    }
    // belman ford algorithm which are useful when the weight given the negative form 
    public static void belmanFord(ArrayList<Edge>graph[],int start)
    {
        // creating the distance array;
        int dist[] = new int[graph.length];
        // intializing the distance 
        for(int i = 0; i < graph.length; i++)
        {
           if(i != start)
           {
            dist[i] = Integer.MAX_VALUE;

           }
        }

        // looping for n-1 vertex;
        for(int i = 0; i < graph.length - 1; i++)
        {
            for(int j = 0; j < graph[i].size() ; j++)
            {
                 Edge edge = graph[i].get(j);
                 int u = edge.src;
                 int v = edge.des;
                 int w = edge.weight;
                 if(dist[u] != Integer.MAX_VALUE && dist[u]+ w < dist[v])
                 {
                    dist[v] = dist[u]+w;
                 }
            }

        }
        // here printing  the all possible distance;
        for(int i = 0; i < dist.length; i++)
        {
            System.out.println(dist[i]);
        }
    }



     public static void belmanFordD(ArrayList<Edge>graph,int ver,int start)
    {
        // creating the distance array;
        int dist[] = new int[graph.size()];
        // intializing the distance 
        for(int i = 0; i < graph.size(); i++)
        {
           if(i != start)
           {
            dist[i] = Integer.MAX_VALUE;

           }
        }

      
      for(int i = 0; i < ver-1; i++)
      {
           for(int j = 0; j < graph.size() ; j++)
            {
                 Edge edge = graph.get(j);
                 int u = edge.src;
                 int v = edge.des;
                 int w = edge.weight;
                 if(dist[u] != Integer.MAX_VALUE && dist[u]+ w < dist[v])
                 {
                    dist[v] = dist[u]+w;
                 }
            }
      }

    
        // here printing  the all possible distance;
        for(int i = 0; i < dist.length; i++)
        {
            System.out.println(dist[i]);
        }
    }




//    prims algorith code 



    public static void main(String args[])
    {
        // here creating the graph
        int v = 5;
        // ArrayList<Edge> graph[] = new ArrayList[v];
        ArrayList<Edge> graph = new ArrayList<>();
        // for(int i = 0; i < graph.length; i++)
        // {
        //     graph[i] = new ArrayList<>();
        // }   
        graph.add(new Edge(0,1,2));
        graph.add(new Edge(0,2,4));

        graph.add(new Edge(1,2,-4));
        graph.add(new Edge(2,3,2));

        graph.add(new Edge(3,4,4));
        graph.add(new Edge(4,1,-1));

        belmanFordD(graph,v,0);
    }
}