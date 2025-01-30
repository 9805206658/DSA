import java.util.*;
public class PrimsAlgorithm
{
     static class Edge {
        int src;
        int des;
        int weight;
    public Edge(int src,int des,int weight)
        {
            this.src = src ;
            this.des = des;
            this.weight = weight;
        } 
    }

    static class Pair  implements Comparable<Pair>
    {
        int v;
        int cost;
        public Pair(int v,int cost)
        {
            this.v = v;
            this.cost = cost;

        }
        @Override
        public int compareTo(Pair p2)
        {
            return this.cost - p2.cost;

        }
    }

  public static void prims(ArrayList<Edge> graph[])
  {
    boolean vist[] = new boolean[graph.length];
    int cost = 0;
    PriorityQueue<Pair> pq = new PriorityQueue<>();
    pq.add(new Pair(0,0));
    while(!pq.isEmpty())
    { Pair p = pq.remove();
        if(!vist[p.v])
        {
        vist[p.v] = true;
         cost += p.cost;
       for(int i = 0; i < graph[p.v].size(); i++)
        {  
            Edge neigh = graph[p.v].get(i);
          pq.add(new Pair(neigh.des,neigh.weight));
            
        }
        }
      
    }
    System.out.println(cost);
  }

    public static void main(String args[])
    {

        int size = 4;
        ArrayList<Edge>graph[] = new ArrayList[size];
        for(int i = 0; i < graph.length; i++)
        {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,3,40));
        graph[1].add(new Edge(1,0,10));

        graph[2].add(new Edge(2,3,50));
        graph[2].add(new Edge(2,0,15));

        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,0,30));
        // graph[3].add(new Edge(3,2,50));
        prims(graph);
        

    }
}
