import java.util.*;
public class Part3
{
    static class Edge
    {   int src ;
        int des ;

        public Edge(int src,int des)
        {
            this.src = src;
            this.des = des;
      
        }
    }


    // code for topological sort
    public static void calculateIndegree( ArrayList<Edge>graph[] , int indegree[])
    {
        for(int i = 0; i < graph.length; i++)
        { for(int j = 0; j < graph[i].size(); j++)
            { Edge edge = graph[i].get(j);
               indegree[edge.des]++;
            }
        }
    }

   public static void topologicalSort(ArrayList<Edge> graph[])
   {
      int indegree[] = new int[graph.length ];
      calculateIndegree(graph , indegree);
      Queue<Integer> q = new LinkedList<>();
    //   here adding the element which indegree is 0;
    //  ver -> vertex;
     for(int i = 0; i < indegree.length; i++)
     {  int ver = i;
        if(indegree[i] == 0)
        {q.add(ver); }
     }

     while(!q.isEmpty())
     {
       int curr = q.remove();
        System.out.println(curr);
       for(int i = 0; i < graph[curr].size(); i++)
       {
         Edge edge = graph[curr].get(i);
         indegree[edge.des]--;
         if(indegree[edge.des] == 0)
         {
            q.add(edge.des);
         }
        }

     }
   }

// findi all the path from source to destination
public static void findPath(ArrayList<Edge> graph[],int src, int destination,String path)
{
    if(src == destination)
    {  System.out.println(path);
        return ;
    }
    for(int i = 0; i < graph[src].size(); i++)
    {
        Edge edge = graph[src].get(i);
        findPath(graph,edge.des,destination,path+edge.des);
    }
}

    public static void main(String args[])
    {
        // here creating the graph
       ArrayList<Edge>[] graph = new ArrayList[6];
        for(int i = 0; i < graph.length; i++)
        {
            graph[i] = new ArrayList<>();
        }
      graph[0].add(new Edge(0,3));
      graph[2].add(new Edge(2,3));
      graph[3].add(new Edge(3,1));
      graph[4].add(new Edge(4,0));
      graph[4].add(new Edge(4,1));
      graph[5].add(new Edge(5,0));
      graph[5].add(new Edge(5,2));
      int src = 5;
      int des = 1;
      findPath(graph,src,des,""+src);





        
    }
}