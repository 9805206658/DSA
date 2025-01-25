import java.util.*;
public class Bipartile
{
    static class Edge
    {
        int src ;
        int des ;
        public Edge(int src, int des)
        {   this.src = src;
            this.des = des;
        }
    }
    public static boolean isBipartic(ArrayList<Edge> graph[])
    {
        int color[] = new int[graph.length];
        for(int i = 0; i < graph.length; i++)
        { color[i] = -1;}
         Queue<Integer> q = new LinkedList<>();
      
        for(int i = 0; i < graph.length; i++)
        {
            if(color[i] == -1)
            {
            q.add(i);
            color[i] = 0;
            while(!q.isEmpty())
            {
                int curr = q.remove();
                for(int j = 0; j<graph[curr].size(); j++)
                {
                    Edge edge = graph[curr].get(j);
                    // if the color not set
                    if(color[edge.des] == -1)
                    { color[edge.des]=color[curr] == 0? 1: 0 ;
                      q.add(edge.des);
                     }
                    // both neightbour have the same color
                    else if(color[edge.des] == color[curr])
                    {
                         q.add(edge.des);
                        return false; 

                    }
                   
               }
            }
            }

        }
        return true;


    }
    public static void main(String args[])
    {
        //  `     (0)
        //        .  .
        //       .     .
       //      (1)      (2)
    //           .      .
    //            .  . . 
    //           (3)   (4)
        
        ArrayList<Edge> [] graph  = new ArrayList[5];
        for(int i = 0; i< graph.length; i++)
        {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,3));
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));
        // graph[0].add(new Edge(0,1));
        // graph[0].add(new Edge(0,2));

        // graph[1].add(new Edge(1,0));
        // graph[1].add(new Edge(1,3));

        //  graph[3].add(new Edge(3,1));
        // graph[3].add(new Edge(3,4));

        // graph[4].add(new Edge(4,3));
        // graph[4].add(new Edge(4,2)); 
        System.out.println(isBipartic(graph)) ;


    }
}