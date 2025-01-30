import java.util.*;
public class PracticeSet2
{
     static boolean check = false;
     // static int E = 8;
    //  static  int V = 7;
     static class Edge 
     {
      int src ;
      int des ;
      // public Edge(int src,int des)
      // {  this.src = src;
      //    this.des = des;
      // }
     }
    public static void addEdge(ArrayList<ArrayList<Integer>> g , int u ,int v)
    {
        g.get(u).add(v);
    }
    // public static void dfsUtil(ArrayList<ArrayList<Integer>> g,int curr, boolean vist[])
    // {
    //     vist[curr] = true;
    //     for(int v : g.get(curr))
    //     {if(!vist[v])
    //         { dfsUtil(g,v,vist);}
    //     }
    // }
    // public static void findMother(ArrayList<ArrayList<Integer>> g)
    // {
    //     // here visting the all the node 
    //     boolean vist[] = new boolean[g.size()];
    //     int v = -1;
    //     for(int i = 0; i < V;i++ )
    //     {
    //         if(!vist[i])
    //         {
    //             dfsUtil(g,i,vist);
    //             v= i;
    //             System.out.println("enter");
    //         }

    //     }
    //     if( v == -1)
    //     {
    //         System.out.println("the are not mother exist");
    //     }
    //     else 
    //     {
    //         boolean check[] = new boolean[V];
    //         dfsUtil(g,v,check);
    //         for(boolean c : check)
    //         {
    //             if(!c)
    //             {
    //                 v= -1;
    //                 System.out.println("the mother node not exist");
    //                 break;
    //             }
    //         }
    //         System.out.println(v);
    //       }
//  ArrayList<ArrayList<Integer>> g = new ArrayList<>();
//         for(int i = 0; i < V ; i++)
//         { g.add(new ArrayList<>()); }
        
//           addEdge(g,0,1);
//           addEdge(g,0,2);
//           addEdge(g,4,1);
//           addEdge(g,5,6);
//           addEdge(g,5,2);
//           addEdge(g,6,4);
// findMother(g);
// }
// implementation of the unon find algortihm

 static int size = 3;
//  static int rank [] = new int[size];
 static int parent [] = new int[size];

 public static void init()
 { for(int i = 0; i < size; i++)
    { parent[i] = i; }
 }

 public static int find(int n)
 {  if(n == parent[n])
      { return n;}
  return parent[n]= find(parent[n]);

 }
 public static void union( int A,int B)
 {
  parent[A] = B;
   
 }
 
 public static  boolean isCycle(Edge[] graph)
 {
    for(int i = 0; i < size;i++)
      {  int srcPar = find(graph[i].src);
          int desPar = find(graph[i].des);
          if(srcPar == desPar)
          { return true;}
          union(srcPar,desPar);      
      }
      return false;
}
 public static void main(String args[])
    {

   
      Edge graph[] = new Edge[size];
      for(int i = 0; i< size;i++)
      {
         graph[i] =  new Edge();
      }
      graph[0].src = 0;
      graph[0].des = 1;

      graph[1].src = 1;
      graph[1].src = 2;

      graph[2].src = 0;
      graph[2].src = 2;

      init();
    
      if(isCycle(graph))
      {
        System.out.println("cylce exist in the graph");
      }
      else 
      {
         System.out.println("cylce not exist in the graph");

      }
     

       
    }
}