import java.util.*;
public class Test{
     static class Node
    {   int data;
        Node left;
        Node right;
        public Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static int mod = 1000000007;
    static int total = 0;
    static int max = Integer.MIN_VALUE;
    public static int sum(Node root)
    { if(root == null)
      return 0;
       root.data =sum(root.left)+sum(root.right)+root.data;
      return root.data;
    }
    public static void traverse(Node root)
    {
         if(root==null)
            return;
            System.out.println("data:"+root.data);
        max = Math.max(root.data*(total-root.data),max);
        traverse(root.left);
        traverse(root.right);
    }
    public static void main(String args[])
    {
        StringBuilder sb= new StringBuilder();
        sb.append('b');
        sb.append('i');
        sb.append('k');
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());

        // here creating the tree;
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // total = sum(root);   
        // traverse(root);
        // System.out.println(max);
        
    
    }
}


