public class LinkedList
{
    public static class Node
    {   int data;
        Node next;
        public Node(int data)
        {   this.data = data;
            this.next = null;
        }
    }
     public static Node head;
     public static Node tail;
     public static int size;
     public void addFirst(int data)
     { // here creating the new node;
       Node newNode= new Node(data);
       size++;
        if(head == null)
        { head = tail = newNode; 
         return ;
        }// here linking head node
        newNode.next=head; // here linking head with new node
        head = newNode;
     }
     public void addLast(int data)
     {
        Node newNode = new Node(data);
        size++;
        if(head == null)
        { head = tail =newNode;
          return ;
        }
        tail.next =newNode;
        tail = newNode;
     }
     public void printNode()
     {
        Node temp = head;
        if(head == null)
        { System.out.println("the data linkedList goint to be null");
            return ;
        }
        while(temp != null)
        {  System.out.print(temp.data+"--->");
            temp = temp.next;
        }
        System.out.print(temp);
        System.out.println();
     }
     public void addMiddle(int index,int data)
     {
        Node newNode = new Node(data);
        size++;
        int i=0; 
        Node prevNode = head;
        // here getting the previous node;
        while(i < index)
        { prevNode = prevNode.next;
            i++;
        }
         newNode.next = prevNode.next;
         prevNode.next = newNode;
      }
      public int removeFirst()
      {
        if(size == 0)
        {
            System.out.println("the linkedlist is Empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1)
        {
            head = tail = null;
            int temp = head.data;
            size = 0;
            return  temp; 
      
        }
        int data = head.data;
        head = head.next;
        size --;
        return data;
     }
     
     public int removeLast()
     {if(size == 0)
        {   System.out.println("the linkedlist are empty");
            return Integer.MIN_VALUE;
        }
      else if(size == 1)
      { int data = head.data;
        head=tail= null;
        size =0;
        return data;
      }
      Node prev = head;
      int data = tail.data;
      for(int i = 0; i < size -2; i++)
      { prev = prev.next;}
      prev.next = null;
      tail = prev;
      return data;
   }
//    search the node using iterative approach
   public  int searchIterative(int key)
   { int i = 0;
     Node temp = head;
     while(temp != null)
     { if(temp.data == key)
        {return i; }
        temp = temp.next;
        i++;
     }
     return -1;}
    
// revese linked list 
    public void reverse()
    {
        Node prev = null;
        Node curr = tail = head;
        Node next = curr.next;
        while (next != null)
        {
            next = curr.next;
            curr.next = prev;
            prev =curr;
            curr = next;
        }
        head = prev;

    }

   public int helper(Node head,int key)
   {
   if(head == null)
    {return -1; }
    if(head.data == key)
    {return 0; }
    int idx = helper(head.next,key);
    if(idx == -1) 
    { return -1; }
    return idx+1;
   }

// search recursive
   public int searchRecursive(int key)
   {
    return helper(head,key);
  }


//   Find & remove nth node from the end;
public static void removeNthFromEnd(int n)
{
    // here finding out size  of the linkedlist
    int sz = 0;
    Node temp = head;
    if(n == sz)
    {  head=head.next;
        return ; 
    }
    while(temp != null)
    {
        temp = temp.next;
        sz++;
    }
    // here calculating the size node from the font part
    int posFont = sz-n+1;
     System.out.println("the size is "+ posFont);
    int i=0;
    Node prev = head;
    while (i<posFont-2 )
    {  prev=prev.next; 
        i++;
    }
    prev.next= prev.next.next;
    return ;
    
}


// here writing code for finding the mid using  fast and slow approach;
public Node findMid(Node head)
{
   Node fast = head;
   Node slow = head;
   while(fast != null && fast.next!=null)
   { slow = slow.next;
     fast = fast.next.next;
   }
return slow;
}

// check linkedList is palindrome or not;
public boolean isPalindrome()
{  // here writing corner case for the single node or empty linkedlist
    if(head.next == null || head == null)
    { return true; }
   //here finding the mid
    Node mid = findMid(head);
   //reverse the half of the linked list
    Node prev = null;
    Node curr = mid;
    Node next ;
    while (curr != null)
    {   next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    // here coparing the node 
    Node left = head; 
    Node right = prev;
    while(right != null)
    {   System.out.println("the data"+left.data);
        System.out.println("the data"+right.data);
        if(left.data != right.data)
        {return false; }
        left = left.next;
        right = right.next;
    }
    return true;
}
// here defining  the function that check the cycle using floyd's  algorithm
// here defining the two pointer slow and fast pointer 
// if slow and fast are equal then  there exist loop other  wise there not exist any loop
public  static boolean isCycle()
{   Node slow = head;
    Node fast = head;
    while(fast !=null && fast.next !=null)
    {    slow = slow.next;
         fast = fast.next.next;
         if(slow == fast)
        {return true;}
   }
    return false;
}

// here removing the cycle 
public static void removeCycle()
{// Identify cycle
  Node slow = head;
  Node fast = head;
  boolean isLoop = false;
  while (fast != null && fast.next != null)
  {
    slow = slow.next;
    fast = fast.next.next;
    if(slow == fast)
    { isLoop = true;
        break;}
 }
 if(isLoop = false)
 { return ;}
   // identify last node
 Node prev=fast;
 slow =head;

 while (slow != fast)
    {    
       slow = slow.next;
       fast = fast.next;
       prev = fast;
    }
  // remove the cycle
 prev.next=null;
}

// here defining the getMid function 
public static Node getMid(Node head)
{
    Node slow=head;
    Node fast = head;
    while(fast != null && fast.next != null)
    { slow = slow.next;
      fast = fast.next.next;
    }
    return fast;
}
// here defining the merge function 
public static Node merge(Node leftHead, Node rightHead)
{
    Node mergeLL = new Node(-1);
    Node temp = mergeLL;
    while(leftHead != null || rightHead != null)
    {
        if(leftHead.data <= rightHead.data)
        {temp.next = leftHead;
            leftHead = leftHead.next;
            temp = temp.next;
        }
        else 
        {temp.next = rightHead;
            rightHead = rightHead.next;
            temp = temp.next;
        }
    }
    // here reamining element in leftHead
    while(leftHead != null)
    {   temp.next =leftHead;
        leftHead = leftHead.next;
        temp = temp.next;
    }
    while(rightHead != null)
    {
        temp.next = rightHead;
        rightHead = rightHead.next;
        temp = temp.next;
    }
    return mergeLL;

}

// merge sort in linkedlist
public static Node mergeSort(Node head)
{
    if(head == null || head.next == null)
    { return head; }
    // here getting mid;
    Node mid = getMid(head);
    Node rightHead = mid.next;
    mid.next = null;
    Node rightNode = mergeSort(rightHead);
    Node leftNode = mergeSort(head.next);
    return merge(leftNode,rightNode);
}

public static void zigZag()
{
    // here finding the mid
    Node slow = head;
    Node fast = head;
    while(fast != null && fast.next != null)
    {
        slow = slow.next;
        fast = fast.next.next;
    }
    Node mid = slow;
    // here reverse the second half
    Node curr = mid.next;
    mid.next=null;
    Node prev = null;
    Node next;
    while(curr != null)
    {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
   }
//    here mergin the two half x
  Node left=head;
  Node right =prev;
  Node nextL,nextR;
  while(left != null && right !=null)
  {
     nextL = left.next;
    left.next = right;
    nextR = right.next;
    right.next = nextL;
    left = nextL;
    right = nextR;
  }

}

public static void main(String args[])
{
LinkedList ll= new LinkedList();
ll.addLast(1);
ll.addLast(2);
ll.addLast(3);
ll.addLast(4);
ll.addLast(5);
ll.zigZag();

ll.printNode();
//  here creating the cycle
// head = new Node(1);
// Node temp = new Node(2);
// head.next =temp;
// head.next.next = new Node(3);
// head.next.next.next = temp;
// System.out.println(isCycle());
// removeCycle();
// System.out.println(isCycle());

     //   ll.addMiddle(2,5);
    //   ll.reverse();
    // ll.removeNthFromEnd(8);
    //   ll.removeLast();
    //   System.out.println("the size of linkedlist" + ll.size);
    //   System.out.println("the iterative search"+ll.searchRecursive(5));
   
   }
} 
