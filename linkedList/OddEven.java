public class OddEven
{
    // here creating node class
    static class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
            next = null;
        }
    }
    public static Node head ;
    public static Node tail ;
    public static void addFirst(int data)
    {
        Node newNode = new Node(data);
        // if linkedlist are empty;
        if(head == null)
        {
            head = tail = newNode;
            return ;
        }
        newNode.next = head;
        head = newNode;
    }
    public static void printLL()
    {
        Node temp = head;
        while(temp != null)
        {  System.out.println(temp.data);
           temp = temp.next;
        }
    }
    public static void seperateOddEven()
     {// here creating the referance point
        Node temp2 = tail;
       // head are odd; 
        while(head.data % 2 != 0)
        {
            Node temp = head;
            head = head.next;
            tail.next = temp;
            tail = temp;
            tail.next = null;
       }
       Node prev = head;
       Node curr = head.next;
       while(curr.data != temp2.data) 
       { // event case
         if(curr.data%2 == 0)
         {  prev = prev.next;
            curr = curr.next;
         }
        //  odd case 
        else 
        {
        Node temp3 = curr;
        //move curr and next 
        prev.next = curr.next;
        curr = curr.next;
        // here  add the element at the last
        tail.next = temp3;
        tail = temp3;
        tail.next = null;
          }
      }
    //   here writing the code for the last 
     if(curr.data % 2 != 0)
     {  Node temp3 = curr;
        //move curr and next 
        prev.next = curr.next;
        curr = curr.next;
        // here  add the element at the last
        tail.next = temp3;
        tail = temp3;
        tail.next = null;
     }

    }
    public static void main(String args[])
    { addFirst(5);
      addFirst(4);
      addFirst(3);
      addFirst(2);
      addFirst(1);
      seperateOddEven();
      printLL();

    }
}