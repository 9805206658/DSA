import java.util.*;
public class PracticeQuestion
{  static class Node
    {
        int data ;
        Node left ;
        Node right;
        public Node(int data)
        {
            this.data = data;
            left = right = null;
        }
    }
    static Node ele = null;
    static int diff =Integer.MAX_VALUE;
    public static void closetEleBST(Node root,int target)
    {
        if(root == null)
        { return ; }
        int abs= Math.abs(root.data - target);
        if(abs<diff)
        { 
           ele = root;
           diff= abs;
        }
        closetEleBST(root.left,target);
        closetEleBST(root.right,target);
    }
    public static void main(String args[])
    {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(20);
        closetEleBST(root,19);
        System.out.println(ele.data);
    
    }
}