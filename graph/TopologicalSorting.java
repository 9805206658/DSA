import java.util.*;
class Solution {
    public void removeDuplicates(int[] nums) { 
       int  k = 0;
        for(int i = 0; i < nums.length-2; i++)
        {  if(nums[i] == nums[i+1])
            { nums[i+1] = nums[i+2];
              nums[i+2] = '_';
             }
        }
     
      }
}


public class TopologicalSorting
{
    static class Edge{
        int src ;
        int des;
        public Edge(int src,int des)
        {
            this.src = src ;
            this.des = des;
        }
    }
    public static void topologicalSorting(ArrayList<Edge> graph[])
    {
        boolean vist[] = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < graph.length; i++)
        { if(!vist[i])
            { utilBfs(graph,vist,stack,i);  }
        }
      while(!stack.isEmpty())
      {
        System.out.println(stack.pop());
      }

    }
    public static void utilBfs(ArrayList<Edge> graph[],boolean vist[],Stack <Integer> stack,int curr)
    {
        vist[curr] = true;
        for(int i = 0; i < graph[curr].size(); i++)
        {
            Edge edge = graph[curr].get(i);
            if(!vist[edge.des])
            {utilBfs(graph,vist,stack,edge.des);
            }
         }
        stack.push(curr);

    }
    public static void main(String args[])
    {
    //     ArrayList<Edge>[] graph = new ArrayList[6];
    //     for(int i = 0; i < graph.length; i++)
    //     {
    //         graph[i] = new ArrayList<>();
    //     }
    //   graph[2].add(new Edge(2,3));
    //   graph[3].add(new Edge(3,1));
    //   graph[4].add(new Edge(4,0));
    //   graph[4].add(new Edge(4,1));
    //   graph[5].add(new Edge(5,0));
    //   graph[5].add(new Edge(5,2));
    //   topologicalSorting(graph);

   

 Solution sol = new Solution();
 int n[] = {1,1,2};
sol.removeDuplicates(n);
for(int i = 0; i < n.length; i++)
{
    System.out.println(n[i]);
}

    }
}