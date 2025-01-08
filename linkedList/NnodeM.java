public class NnodeM
{
    static class Node
    {
        int data ;
        Node next;
        public Node(int data)
        {   this.data = data;
            this.next = null;
        }
    }
    public static void addFirst(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        { head = tail = newNode;
          return ;}
        newNode.next = head;
        head = newNode;
    }
    public static void addLast(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        { head = tail = newNode;
            return ; }
        tail.next = newNode;
        tail = newNode;
    }
    public static void printLL(Node head)
    {  Node temp = head;
        while(temp != null)
        {  System.out.println(temp.data);
           temp = temp.next;
        }
     }
    public static Node head;
    public static Node tail;
    public static void mAfterN(Node head,int m, int n)
    {  
        Node temp = head;
       Node t;
        while(temp != null)
        {   
             for(int i = 1; i<m && temp !=null; i++)
            { temp= temp.next; }
            if(temp == null)
            { return;}
            t= temp.next;
            for(int j = 0; j<m && t.next != null ; j++)
            {   Node tmp = t;
                t= tmp.next;
            }// moving one step forward
            temp=t;
            System.out.println(temp.data);
        }
    }
    
   
    // here define the node for dipslaying n node after m node 
    public static void main(String args[])
    {    addLast(1);
         addLast(2);
         addLast(3);
         addLast(4);
         addLast(5);
         addLast(6);
         mAfterN(head,3,2) ;
         printLL(head);
         
    }
}