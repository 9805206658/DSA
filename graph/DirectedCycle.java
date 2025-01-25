import java.util.*;
public class DirectedCycle
{
    static class Edge{
        int src; 
        int des;
        public Edge(int src, int des)
        {
            this.src = src;
            this.des = des;
        }
    }
    // Detect cycle in directed graph
    public static boolean detectCycle(ArrayList<Edge>[] graph)
    {
        boolean[] vist = new boolean[graph.length];
        boolean[] stack = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++)
        { if(!vist[i])
            {  if( detectCycleUtil(graph,vist,stack,i))
                {return true;}
            }
        }
        return false;

    }
    public static boolean detectCycleUtil(ArrayList<Edge>[]graph,boolean vist[],boolean stack[],int curr)
    {
         vist[curr]= true;
          stack[curr] = true;
         for(int i = 0 ; i < graph[curr].size(); i++)
         {
            Edge edge = graph[curr].get(i);
             if(stack[edge.des])
             { return true;
             }
             if(!vist[edge.des] && detectCycleUtil(graph,vist,stack,edge.des))
             { return true;}
         }
         stack[curr] =false;
         return false;

    }

    public static void main(String args[])
    {
        ArrayList<Edge>graph[] = new ArrayList[4];
        for(int i = 0; i < graph.length; i++)
        {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));
        graph[2].add(new Edge(2,3));
        graph[1].add(new Edge(1,0));
        System.out.println(detectCycle(graph));
    }
}