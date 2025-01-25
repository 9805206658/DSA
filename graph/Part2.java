import java.util.*;
public class Part2
{
    
    static class Edge
    { 
        int src ;
        int des ;
        int weight;
        public Edge (int src, int des, int weight)
        {
            this.src =src;
            this.des = des;
            this.weight = weight;
        }
    }

   public static void bfs(ArrayList<Edge> graph[] ) 
   {
    boolean vist[] = new boolean[graph.length];
    for(int i = 0; i < graph.length; i++)
    {   if(!vist[i])
       {
        bfsUtil(graph , i,vist);
       }
    }

   }

    public static void bfsUtil(ArrayList<Edge> graph[],int src,boolean vist[]) 
    {
        // here creating the queue
        Queue<Integer> q = new LinkedList<>();
       
        q.add(src);
       while(!q.isEmpty())
       { int ele = q.remove();
        if(!vist[ele] )
        {
            System.out.println(ele);
            vist[ele] = true;
        //  putting the adjacent element in the graph
          for(int i = 0; i < graph[ele].size(); i++)
          {
             Edge edge = graph[ele].get(i);
             q.add(edge.des);
          }
        }
       }

    }





    //  public static void bfs(ArrayList<Edge>[] graph)
    // {      Queue<Integer> q = new LinkedList<>();
    //        int len = graph.length;
    //        boolean vist[] = new boolean[len+1];
    //       for(int i = 0; i< graph.length; i++)
    //         { bfsUtil(graph,q,vist,i); }

    // }
    // public static void bfsUtil(ArrayList<Edge>[] graph,Queue<Integer> q,boolean []vist,int node)
    // {
    //    q.add(node);
    //     while(!q.isEmpty())
    //     {
    //      int currNode = q.remove();
    //      if(!vist[currNode])
    //      {
    //         vist[currNode] = true;
    //         for(int i = 0; i < graph[currNode].size(); i++)
    //         {q.add(graph[currNode].get(i).des);  }
    //      }
    //     }
    // }
   
    public static void dfs(ArrayList<Edge>[] graph)
    {
        int len = graph.length;
        boolean vist[] = new boolean[len+1];
         for(int i = 0; i < len ; i++)
         {
            if(!vist[i])
            {
                dfsUtil(graph,vist,i);
            }

         }

    }
    
    public static void dfsUtil(ArrayList<Edge> [] graph , boolean vist[],int node)
    {
        System.out.println(node);
        vist[node] = true;
        for(int i = 0; i < graph[node].size(); i++)
        { int currNode = graph[node].get(i).des;
            if(!vist[currNode])
            {dfsUtil(graph,vist,currNode); }
        }

    }



    // check either cyclear are exist or not in the graph
    public static boolean hasCycle(ArrayList<Edge>[] graph)
    {
        boolean vist[] = new boolean[graph.length];
        for(int i = 0; i < graph.length; i++)
        {
            if(!vist[i])
            {
               if( utilHascycle(graph,i,vist,-1))
               {
                return true;
               }
            }

        }
        return false;

    }
    public static boolean utilHascycle(ArrayList<Edge>[]graph,int curr,boolean vist[], int parent)
    {  vist[curr] = true;
        for(int i = 0; i<graph[curr].size(); i++)
        {  Edge e = graph[curr].get(i);
            if(!vist[e.des])
            { if(utilHascycle(graph,e.des,vist,curr))
                {return true; }
            }
            else if(vist[e.des] && e.des != parent)
            { return true;}
       }
       return false;
   }

// public static boolean hasCycleBfs(ArrayList<Edge> graph[])
// { boolean vist[] = new boolean[graph.length];
//    Arrays.fill(vist,false);
//     for(int i = 0; i < graph.length; i++)
//     { if(!vist[i])
//         { if(hasCycleUtilBfs(graph,vist,i) == true)
//            { return true; }
//         }
//     }
//     return false;

// }
// public static boolean hasCycleUtilBfs(ArrayList<Edge> graph[],boolean vist[],int ele)
// {
//     // here creating queue
//     int parent[] = new int[graph.length];
//     Arrays.fill(parent,-1);
//     Queue<Integer> q = new LinkedList<>();
//    q.add(ele);
//     while(!q.isEmpty())
//     {  int src = q.remove();
//         if(!vist[src])
//         {
//         vist[src] = true;
//          for(int i = 0; i < graph[src].size(); i++)
//          { Edge edge = graph[src].get(i);
//          System.out.println(edge.des);
//             if(!vist[edge.des])
//             {  vist[edge.des] = true;
//                 q.add(edge.des);
//                 parent[edge.des] = src;
//              }
//             else if(parent[src] !=  edge.des)
//             {return true ;  }
//            } 
//          }
//      }



//      for(int i = 0; i < parent.length; i++)
//      {  System.out.println(parent[i]);
//      }
//      System.out.println();
//      return false;
    // }
    public static void main(String args[])
    {


        //   (0)                2
        //      .         .(2). . . (4)
        //     5 .    1 .   .   1
        //        .   .     .
        //        (1) . . .(3)
        //             3



        int size = 5; 
        ArrayList<Edge> [] graph = new ArrayList[size];
        for(int i = 0; i< graph.length; i++)
        {
            graph[i] = new ArrayList<>();
        }
        // testing on the  directed graph
        // graph[0].add(new Edge(0,3,0));
        // graph[0].add(new Edge(0,2,0));
        // // graph[2].add(new Edge(2,3,0));
        // graph[1].add(new Edge(1,0,0));


        graph[0].add(new Edge(0,1,5));
        
        graph[1].add(new Edge(1,2,3));
        graph[2].add(new Edge(2,1,1));
        
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));

        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,1));
        
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));

        graph[4].add(new Edge(4,2,2));
       bfs(graph) ;
        

    }
}