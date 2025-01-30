import java.util.*;
public class Possible
{
    public static void calculateIndegree(ArrayList<Integer> graph[],int indegree[])
    {
        for(int i = 0; i < graph.length; i++)
        {
            for(int num : graph[i])
            {
                indegree[num]++;
            }


        }

    }
    public static  boolean isComplete(ArrayList<Integer> graph[])
    {
        int indegree[] = new int[graph.length];
        calculateIndegree(graph,indegree);
        for(int i = 0; i < graph.length; i++)
        {
            int j = 0;
            for(; j <graph.length;j++)
            { if(indegree[j] == 0)
                {  break; }
            }
            if(j == graph.length)
            {
                return false;
            }
            indegree[j] = -1;
            for(int conn : graph[j])
            {
                indegree[conn]--;
            }
        }
        return true;
        
    }
    public static void main(String args[])
    {
        int size = 3;
        ArrayList<Integer>graph[] = new ArrayList[size];
        for(int i = 0; i < size; i++)
        {  graph[i] = new ArrayList<>();}
        graph[0].add(1);
     
        System.out.println(isComplete(graph));

        
        
    }
}