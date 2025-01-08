public class Part2
{
    static class Node 
    {
      int data;
      Node next;
      public Node(int data)
      {
        this.data = data;
        this.next = null;
      }
    }
    static class Stack 
     {
       public static Node head;
       public static Node tail;
        public  boolean isEmpty()
        { return head == null;
        }
        public void  push(int data)
        {  // here creating the node;
            Node newNode = new Node(data);
            if(isEmpty())
            { 
             head = newNode;
             return ;
            }
            newNode.next = head;
            head = newNode;
        }
        public int pop()
        {
            if(isEmpty())
            { return -1;  }
            int data = head.data;
            head = head.next;
            return data;

        }
        public int peek()
        {    if(isEmpty())
            { return -1;} 
            int data = head.data;
            return data;
        }

     }
     public static void main(String args[])
     {
        Stack s =new Stack();
         System.out.println(s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
       while(!s.isEmpty())
       {
        System.out.println(s.pop());
       }
       System.out.println(s.isEmpty());


     }
}