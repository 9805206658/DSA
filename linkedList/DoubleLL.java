public class DoubleLL
{
    public class Node
    {
        int data;
        Node next;
        Node prev;
        public Node(int data)
        {   this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
    public void addFirst(int data)
    {
    //   the node are going to be blank;
        Node newNode = new Node(data);
        if(head == null)
        {
            head = tail = newNode;
            return ;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
         size++;
    }
    public void print()
    {
        Node temp = head;
        while(temp != null)
        {   System.out.print(temp.data+"<-->");
            temp = temp.next;
        }
        System.out.print("null");

    }


     public int removeFirst()
     {
        //  here writing the corner case for removing the element;
        if(head == null)
        {
          System.out.println("the linkedList are empty");
          size --;
          return Integer.MIN_VALUE;
        }
        int value = head.data;
        head = head.next;
        head.prev = null;
        size --;
        return value;
    }

//    add node at last of the linkedlist
  public void addLast(int data)
   { Node newNode = new Node(data);
   if(head == null)
        {   head = tail = newNode;
            return ;
        } 
    tail.next = newNode ;
    newNode.prev = tail;
    tail = newNode;
    size ++;
   }
//  removing the element from the last;
public int removeLast()
{
    if(head == null)
    { return Integer.MIN_VALUE; }
      int value = tail.data;
     Node temp = tail.prev;
     temp.next =null;
     tail.prev = null;
     size --;
    return value;

}
public void reverseLinkedList()
{
   Node curr = head;
   Node prev = null;
   Node next;
   while(curr != null) 
   {
    next = curr.next;
    curr.next =prev;
    curr.prev = next;
    prev = curr;
    curr = next;
   }
  head = prev;

}
 public static void main(String args[])
    {
        DoubleLL  dll= new DoubleLL();
        dll.addFirst(3);
        dll.addFirst(4);
        dll.addFirst(5);
        dll.addFirst(6);
        dll.addFirst(7);
        dll.addLast(10);
        dll.print();
        System.out.println();
        // dll.removeLast();
        dll.reverseLinkedList();
        dll.print();
    }
   
}