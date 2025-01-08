public class Soloution
{
    public  static class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data =data;
            this.next =null;
        }
    }
    public static Node head;
    public static Node tail;
    // here writing the code printing the linkedlist
    public static void print()
    {
        Node temp = head;
        while(temp != null)
        {  System.out.print(temp.data+"-->");
            temp = temp.next;
        }
        System.out.print("null");
     }
    public Node getIntersectionNode(Node head,Node head2)
    {
        Node temp = head;
        while(temp != null)
        {  Node temp2 = head2;
            while(temp2 != null)
            {if(temp2.data == temp.data)
                {return temp2; }
                temp2= temp2.next;
            }
              temp = temp.next;
        } 
        return null;
    }
 // here n after m;
    public static void NAfterM(int n,int m)
    { Node temp =head;
       while(temp != null)
        { // move the  elelment n times;
            for(int i=0; i<n-1; i++)
            { temp= temp.next;}
             // delete the element m times;
            for(int j=0; j<m; j++)
            { Node temp1 = temp.next.next;
             temp.next = temp1;}
             temp= temp.next;
        } 
    }

    // here writing the code for push the element at the begining 
    public  void push(int x)
    {
        Node newNode = new Node(x);
        if(head == null)
        {
         head = tail = newNode;
         return ;
        }
        newNode.next= head;
        head = newNode;
    }

    // oddEven linkedlist
    public static void oddEven()
    {
      Node temp = head;
      Node headE =new Node(-1);
      Node headO =new Node(-1);
     
         
      }
    //   here merging the node;
    head=headE.next;
    Node temp2 = head;
    while(temp2.next != null)
    {
     temp2 = temp2.next;
    }
    temp2.next = headO.next;
    }
    // here writing the code for swapping the likedlist
   public static void swapping(int x ,int y)
   {
    // if the data is equal
     if(x == y)
     { return ; }
    //  here finidng the x node
    Node prevX=null ;
    Node currX = head;
    while(currX != null && currX.data != x)
    {   prevX = currX;
        currX = currX.next;
    }
    Node prevY = null;
    Node currY = head;
    while(currX != null &&  currY.data != y)
    {
        prevY = currY;
        currY = currY.next;
    }
    // if the data element are not available
    if(currX == null && currY == null)
    {
        return ;
    }
    // if the only one element are available
    if(prevX != null)
    prevX.next = currY;
    else 
     head = currX;
     if(prevY != null)
     prevY.next = currX;
     else 
     head = currY;

    //  here swapping the pointed element
    Node temp = currX.next;
    currX.next = currY.next;
    currY.next = temp;
     }

    public static void main(String args[])
    {
     
    Soloution s = new Soloution();
    s.push(5);
    s.push(4);
    s.push(3);
    s.push(2);
    s.push(1);
    //  head=new Node(1);
    //  head.next = new Node(2);
    //  head.next.next = new Node(3);
    //  head.next.next.next = new Node(4);
    //  head.next.next.next.next = new Node(5);
    //  head.next.next.next.next.next = new Node(6);
    //  head.next.next.next.next.next.next = new Node(7);
    //  head.next.next.next.next.next.next.next = new Node(8);
    //  head.next.next.next.next.next.next.next.next = new Node(9);
    //  head.next.next.next.next.next.next.next.next.next = new Node(10);
    //  head.next.next.next.next.next.next.next.next.next.next = null;
     print();
     oddEven();
     print();
       
    }

}