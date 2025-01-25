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
    static int min = Integer.MAX_VALUE;
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
    public static int readData( int n)
    {
        if(n == 0)
        {return 1; }
        
        System.out.println(min);
        min = Math.min(min,n-1);
        return  n*readData(n-1);
    }
    public static void main(String args[])
    {
        // System.out.println(value);
        min = Integer.MAX_VALUE;
        System.out.println(readData(5));
        
        
    
    }
}


