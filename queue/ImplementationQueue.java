//implementation queue using thes stack
import java.util.*;
public class ImplementationQueue
{
    // static class Queue
    //  {  Stack<Integer> s1 = new Stack<>();
    //     Stack<Integer> s2 = new Stack<>();
    //     public boolean isEmpty()
    //     {
    //         return s1.isEmpty();
    //     }
    //     public void add(int data)
    //     {  // here transfer all data from s1 to s2;
    //         while(!s1.isEmpty())
    //         {s2.push(s1.pop());
    //         }
    //         if(s1.isEmpty())
    //         {s1.push(data); }
    //         // here transfer all data from s2 to s1;
    //         while (!s2.isEmpty())
    //         { s1.push(s2.pop());}
    //    }
    //    public int remove()
    //    {
    //     if(s1.isEmpty())
    //     {
    //         return -1;
    //     }
    //      int data=s1.pop();
    //    return data;
    //     }
    //    public int peek()
    //    {
    //     int data = s1.peek();
    //     return data;
    //    }
    // }


    // implementation of the stack using the queue
  //  static class Stack
  //   {
  //       Queue<Integer> q1 = new LinkedList<>();
  //       Queue<Integer> q2 = new LinkedList<>();
  //       public  boolean isEmpty()
  //       {return (q1.isEmpty() && q2.isEmpty()); }
  //       public void push(int data)
  //       {   if(isEmpty())
  //           { q1.add(data);}
  //           if(!q1.isEmpty())
  //           {q1.add(data);}
  //           else 
  //           {q2.add(data);}
  //       }
  //       public int pop()
  //       { int top = -1;
  //          if(isEmpty())
  //           {
  //            System.out.println("the stack is empty");
  //            return -1;
  //           }
  //           if(!q1.isEmpty())
  //           {  while(!q1.isEmpty())
  //               { top = q1.remove();
  //                 if(q1.isEmpty())
  //                 { break; }
  //                 q2.add(top);
  //               }
  //           }
  //           else 
  //           { while(!q2.isEmpty())
  //               { 
  //                 top = q2.remove();
  //                 if(q2.isEmpty())
  //                 {  break; 
  //                 }
  //                 q1.add(top);
  //               }
  //            }
            
  //           return top;
  //       }
  //       public int peek()
  //       {  int top = -1;
  //       // if the q1 is empty then remove data from the q2 and add q1;
  //           if(q1.isEmpty())
  //           {  while(!q2.isEmpty())
  //               { 
  //                 top = q2.remove();
  //                 q1.add(top);
  //               }
  //           }
  //           else 
  //           { while(!q1.isEmpty())
  //               { top = q1.remove();
  //                 q2.add(top);
  //               }
  //            }
  //           return top;
  //       }
  //   }

  
  // implementation of stack using dequeue
  static class Stack{
    Deque<Integer> dq = new LinkedList<>();
    // push operation
    public  boolean  isEmpty()
    {
     return dq.isEmpty();
    }
    public  void push(int data)
    {
      dq.addLast(data);
    }
    // pop opeation
    public  int pop()
    { return dq.removeLast();}
    // peek
    public  int peek()
    {
      return dq.getLast();
    }

  }
  static class Queue
  {
     Deque<Integer> dq = new LinkedList();
     public void add(int data)
     { dq.addLast(data);}
     public boolean isEmpty()
     {
      return dq.isEmpty();
     }
     public int remove()
     {
       return  dq.removeFirst();
     }
     public int peek()
     {
      return dq.getFirst();
     }
  }

  
// printing the non repeating number;
    public static void main(String args[])
    { 
       Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while(!q.isEmpty())
        {
          System.out.println(q.remove());
        }

        
        // System.out.println(s.peek());
        //  int sum = 'b'-'a';
       //  System.out.println("sum:"+sum);
      //  String str = "aabccxb";

      
      
       
     
    
     }
}