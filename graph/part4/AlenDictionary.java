import java.util.*;
public class AlenDictionary
{


    public static void main(String args[])
    {
        String words[] = { "baa","abcd","abca","cab","cad"};
        // here creating hash map  for storing indegree and  neighbour;
        HashMap<Character,Integer> indegree = new HashMap<>();
        HashMap<Character,ArrayList<Character>> graph = new HashMap<>();
        // initialize;
        for(char ch = 'a'; ch < 'z'; ch++)
        {   indegree.put(ch,0);
            graph.put(ch,new ArrayList<Character>());
        }

        // here traversing each string for storing  indegree value in the 
        for(int i = 0; i < words.length-1; i++)
        {
           String words1 = words[i];
           String words2 = words[i+1];
           for(int j = 0; j < Math.min(words1.length(),words2.length()); j++)
           {
            char ch1 = words1.charAt(j);
            char ch2 = words2.charAt(j);
             if(ch1 != ch2)
             {
                graph.get(ch1).add(ch2);
                indegree.put(ch2,indegree.get(ch2)+1);
             }

           }
        }
        Queue<Character> q = new LinkedList<>();

        // here finding the order 
        for(char ch= 'a'; ch < 'z'; ch++)
        { if(indegree.get(ch) == 0)
             {  q.add(ch); }
        }
      StringBuilder sb = new StringBuilder();
        while(!q.isEmpty())
        { char curr = q.remove();
             sb.append(curr);
             for(char conn:graph.get(curr))
             {
              indegree.put(conn,indegree.get(conn)-1);
              if(indegree.get(conn) == 0)
              { q.add(conn); }
             }
         }
         System.out.println(sb.toString());        
    }
}