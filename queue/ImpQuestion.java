import java.util.*;
public class ImpQuestion
{ 
    public static void printNonRepeating(String str)
    {
        Queue<Character> q = new LinkedList<>();
        int freq[] = new int[26];
        for(int i = 0; i<str.length(); i++)
        {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch-'a']++;
            while(!q.isEmpty() && freq[q.peek()-'a']>1)
            { q.remove(); }
            if(q.isEmpty())
            {
             System.out.print(-1+" ");
            }
            else{
             System.out.print(q.peek()+" ");
            }
        }

    }

    // interleave the queue
    public static void interLeave(Queue<Integer> q)
    {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();
         for(int i=0; i<size/2; i++)
         {firstHalf.add(q.remove());}
         while(!firstHalf.isEmpty())
         {
             q.add(firstHalf.remove());
             q.add(q.remove());
         }
    }
    public static void queueReversal(Queue<Integer> q)
    { 
        Stack<Integer> st = new Stack<>();
          while(!q.isEmpty())
          {st.push(q.remove()); }
         while(!st.isEmpty())
         { q.add(st.pop());}
    }
    public static void main(String args[])
    {
      Deque <Integer> dq = new LinkedList<>();
      dq.addLast(1);
      dq.addLast(2);
      dq.addFirst(5);
      dq.addFirst(6);
      while(!dq.isEmpty())
      {System.out.println(dq.removeFirst());
      }
    }
}