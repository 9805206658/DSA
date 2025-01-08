import java.util.*;
public class ImplementLL
{
    // static class Node
    // { int data;
    //     Node next;
    //     public Node(int data)
    //     {   this.data = data;
    //         this.next = null;
    //     }
    // }
    // static class Queue
    // {
    //    public static Node head;
    //    public static Node tail;
    //     public Queue()
    //     {
    //       head = null;
    //       tail = null;  
    //     }
    //     public static boolean isEmpty()
    //     {  if(head == null)
    //         { return true; }
    //         return false;
    //     }

    //     public static void add(int data)
    //     {   Node newNode = new Node(data);
    //         if(head == null)
    //         { head = tail = newNode; }
    //         tail.next = newNode;
    //         tail = newNode;
    //     }
    //     public static int remove()
    //     {  if(isEmpty())
    //         {System.out.println("the queue is empty");}
    //         // for the single element
    //          int data = head.data;
    //         if(head.next == null)
    //         { head = tail = null; }
    //         else 
    //         {
    //             head = head.next;
    //         }
    //         return data;
    //     }
    //     public static int peek()
    //     {     if(isEmpty())
    //           {System.out.println("the queue is empty");}
    //           return head.data;
    //      }
    //  }
    


     public static void main(String args[])
     {
        Queue <Integer> q = new ArrayDeque<>();
        q.add(10);
        q.add(20);
        q.add(30);
         while(!q.isEmpty())
         {
            System.out.println(q.remove());
         }
     }
    
}