import java.util.LinkedList;
import java.util.Arrays;
public class MergeSort
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
   public static void addLast(int data)
   {
     Node newNode = new Node(data);
     if(head == null)
     {
      head = tail =newNode;
      return ;
     }
     tail.next = newNode;
     tail = newNode;
   }
   public static void printLink()
   {
    Node temp = head;
     while(temp != null)
     {System.out.println(temp.data);
      temp = temp.next;
     }
   }
   public static Node head;
   public static Node tail;
   public static void findMid(Node head)
   {
     Node slow = head;
     Node fast = head.next;
     while(fast != null && fast.next != null)
     {
      slow = slow.next;
      fast = fast.next.next;
     }
     return slow;
   }
   public staic void merge(Node p1,Node p2)
   {
     Node headTemp = new Node(-1);
     Node tailTemp = headTemp;
     if(p1.data < p2.data)
     {
       
     }

   }
   public static void mergeSort(Node head)
   {
    if(head == null || head.next = null)
    {
      return head;
    }
      Node mid = findMid(head);
      Node midNext = mid.next;
      mid.next = null;
      Node first = mergeSort(head);
      Node last = mergeSort(midNext);
      return merge(Node head1,Node head2);
   }

  public static void main (String args[])
    {
       addLast(1);
       addLast(2);
       addLast(4);
       addLast(5);
       addLast(6);
       addLast(7);
       addLast(8);
       printLink();


    }

}
