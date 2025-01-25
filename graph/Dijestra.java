import java.util.*;
public class Dijestra
{
    static class Edge
    {
         int src;
         int des;
         int weight;
        public Edge(int src , int des , int weight)
        {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }
    }

    // here making the pair class 
    static class Pair implements Comparable<Pair>
    {   int node; 
        int des; 
        public Pair(int node , int des)
        {
            this.node = node;
            this.des = des;
        }
        @Override
        public int compareTo(Pair p2)
        {
            return this.des - p2.des;
        }

    }


    public static void DijestraAlgorithm(ArrayList<Edge> graph[],int src)
    {  // calculate distance for all node;
        int dist[] = new int[graph.length];
        for(int i = 0; i < dist.length; i++)
        {  if(i != src)
            { dist[i] = Integer.MAX_VALUE; }
        }
        // here creating the priority queue
        boolean vist[] = new boolean[graph.length];
        // here creating the min heap;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0));
        // here loop of the algorithm
        while(!pq.isEmpty())
        {
            Pair curr = pq.remove();
            vist[curr.node] = true;
            for(int i = 0; i < graph[curr.node].size(); i++)
            {
                Edge edge = graph[curr.node].get(i);
                if(!vist[edge.des])
                {   int u = edge.src;
                    int v = edge.des;
                    if(dist[u]+edge.weight < dist[v])
                    {
                        dist[v] = dist[u]+edge.weight;
                        pq.add(new Pair(v,dist[v]));
                     }
                 }

            }
        }
        // printing the minum distance for all the node 
        for(int i = 0; i < dist.length; i++)
        {
            System.out.println(dist[i]);
        }


    }
  
    public static void main(String args[])
    {
        int size = 6;
        ArrayList<Edge> graph[] = new ArrayList[size] ;
        for(int i = 0; i < graph.length; i++)
        {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,3,7));
        graph[1].add(new Edge(1,2,1));
   
        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));
        
        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
         DijestraAlgorithm(graph,0);
    
    }

}