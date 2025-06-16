 class Node
    {
        int val;
        Node next;
        public Node(int val)
        {   this.val = val;
            this.next = next;
        }     
    }
public class Practice
{
    public static void main(String args[])
    {
    Node head = new Node(30);
    head.next = new Node(40);
    head.next.next= new Node(50);
    Node temp = head;
    while(temp != null)
    {
       System.out.println("the val"+temp.val);
        temp = temp.next;

    }
   }

    
}






public class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        HashMap<Node, Node> oldToNew = new HashMap<>();
        
        Node curr = head;
        while (curr != null) {
            oldToNew.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        
        curr = head;
        while (curr != null) {
            oldToNew.get(curr).next = oldToNew.get(curr.next);
            oldToNew.get(curr).random = oldToNew.get(curr.random);
            curr = curr.next;
        }
        
        return oldToNew.get(head);
    }
}


