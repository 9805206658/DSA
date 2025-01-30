import java.util.*;
// implementation of krushkal algorithms
public class  Krushkal
{
     static int size = 4;
    static int parent[] = new int[size];
    static int rank[] = new int[size];
    static class Edge implements Comparable<Edge>
    {
        int src ;
        int des ;
        int wt;
        public Edge(int src,int des,int wt)
        {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
        // here sorting the edges on the basic of cost 
        public int compareTo(Edge e)
        {
            return this.wt - e.wt;
        }
    }
//    implementation of set union function 
   
    public static void init()
    {
      for(int i = 0; i < size ;i++ )
      {
        parent[i] = i;
      }
    }
    public static int findParent(int A)
    {
        if(parent[A] == A)
        {return A;}
        return  parent[A]=findParent(parent[A]);
    }
    public static void union(int A ,int B)
    {
        int parA = findParent(A);
        int parB = findParent(B);
        if(rank[parA] == rank[parB])
        {
          parent[parB] = parA;
          rank[parA] ++;
        }
        else if(rank[parA] > rank[parB])
        {parent[parB] = parA; }
        else 
        { parent[parA] = parB;}
    }
// findShortestPath
public static void findShortestPath(ArrayList<Edge> graph,int v)
{
    Collections.sort(graph);
    init();
    int finalCost = 0;
    int count = 0;
    for(int i = 0; count < v-1; i++)
    {  Edge e = graph.get(i);
         int parA = findParent(e.src);
         int parB = findParent(e.des);
         if(parA != parB)
         {
            union(parA,parB); 
            finalCost += e.wt;
            count++;
         }
    }
    System.out.println("the final cost is"+finalCost);
}
public static void main(String args[])
 {
        // creating the grpah
        ArrayList<Edge> graph = new ArrayList<>();
        graph.add(new Edge(0,1,10));
        graph.add(new Edge(0,2,15));
        graph.add(new Edge(0,3,30));
        graph.add(new Edge(1,3,40));
        graph.add(new Edge(2,3,50));
        findShortestPath(graph,4);      
    }
}