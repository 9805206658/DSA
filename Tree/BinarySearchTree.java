import java.util.*;
public class BinarySearchTree
{
    static class  Node
    {   int data;
        Node left;
        Node right;
        public Node(int data)
        {   this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node buildBST(Node root,int val)
    {
        if(root == null)
        { root= new Node(val);
          return root;
        }
        if(root.data > val)
        {  // left subtree;
         root.left =buildBST(root.left,val);
        }
        else 
        { root.right = buildBST(root.right,val); }
        return root;
       
    }
    public static void inOrder(Node root )
    {  if(root == null)
        { return;}
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }
    public static boolean searchBST(Node root,int key)
    { 
        if(root == null)
        { return false;
        }
        if(root.data == key)
        {
            return true;
        }
        if(key < root.data)
        { 
          return searchBST(root.left,key);
         }
        else 
        { return searchBST(root.right,key);}
        
    }
    // delete node on bst
    public static Node delete(Node root,int val)
    {   if(val > root.data)
        { // search the node in left side
          root.right = delete(root.right,val);
         }
        else if(val < root.data)
        {   // search the node in right side replace the node;
            root.left = delete(root.left,val);
        }
        else 
        {  // leaf node condition
            if(root.left == null && root.right == null)
            { return null;}
            // have one child
            if(root.right == null)
            { return root.left;}
            else if(root.left == null)
            {return root.right ;}
            // have two childre
            System.out.println("the root:"+root.data);
            Node io = findInorderSuccessor(root.right);
             root.data = io.data;
             root.right=delete (root.right,io.data);
             }
             return root;     
         }

         public static void printInRange(Node root,int k1,int k2)
         {
            // first case
            if(root == null) 
            {
                return ;
            }
            if( root.data >= k1 && root.data <= k2)
            {
                printInRange(root.left,k1,k2);
                System.out.println(root.data);
                printInRange(root.right,k1,k2);
            }
            else if(root.data > k2)
            {
                printInRange(root.right,k1,k2);
            }
            else
            {
                printInRange(root.left,k1,k2);
            }
         }

         public static Node findInorderSuccessor(Node root)
         {  while(root.left != null)
            { root = root.left;}
            return root;
         }
         public static void printPath(ArrayList<Integer> path)
         {
            for(int i = 0; i<path.size(); i++)
            {
                System.out.print(path.get(i)+"->");
            }
            System.out.println("null");

         }
         public static void printRoot2Leaf(Node root,ArrayList<Integer>path)
         {  // leaf node condition
           if(root == null)
           {return ; }
            path.add(root.data);
            if(root.left == null && root.right == null)
            { printPath(path);
            }
            printRoot2Leaf(root.left,path);
            printRoot2Leaf(root.right,path);
             path.remove(path.size()-1);
            // backtracking
         }
        
    public static void main(String args[])
    {
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        // Node root = null;
        // int data[]={1,8,5,2,6,10,11,14};
        // for(int i = 0; i< data.length; i++)
        // {root = buildBST(root,data[i]);
        //  };
        // // printInRange(root,4,10) ;
        // printRoot2Leaf(root,new ArrayList<>());
        System.out.println(sb.charAt(0));
    }
}