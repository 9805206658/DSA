import java.util.*;
public class BinaryTreesB
{  static class Node 
    {   int data;
        Node right;
        Node left;
        public Node(int data)
        {   this.data = data;
            this.right = null;
            this.left = null;
        }
    }
    static class BinaryTree
    {   static int idx = -1 ;
        public static Node buildTree(int nodes[])
        {   idx++;
            System.out.println(idx);
            if(nodes[idx] == -1)
            {return null;}
            Node newNode = new Node(nodes[idx]);
            // here creating the right subtree and left subTree
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
         }
         public static void preOrderTraversal(Node root)
         { if(root == null)
            {  System.out.print(-1+" ");
                return ;
            }
            // print root node;
            System.out.print(root.data+" ");
            // print left node;
            // preOrderTraversal(root.left);
            // print right node
            preOrderTraversal(root.right);
         }
        //  inorder traversal;
        public static void inOrder(Node root)
        {  if(root == null)
            { return;}
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
         }

    //    post orderTraversal
         public static void postOrder(Node root)
        {  if(root == null)
            { return;}
            inOrder(root.left);
            inOrder(root.right);
            System.out.print(root.data+" ");
         }

        // level order Traversal;
         public static void levelOrder(Node root)
         {
            Queue<Node> q = new LinkedList<>();
             if(root == null)
             { return ;}
             q.add(root);
             q.add(null);
             while(!q.isEmpty())
             {  Node currNode = q.remove();
                if(currNode==null)
                {   System.out.println();
                    if(q.isEmpty())
                    { break;}
                    else
                    { q.add(null);}
                }
                else
                {
                 System.out.print(currNode.data+" ");
                 if(currNode.left != null)
                 { q.add(currNode.left); }
                 if(currNode.right != null)
                 {  q.add(currNode.right);  }
                }
              } 
             }
         }
        //  height of the tree
       public static int height(Node root)
        {  if(root == null)
            { return 0;}
            int left = height(root.left);
            int right = height(root.left);
             return Math.max(left,right)+1;
        }
        public static int countNode(Node root)
        {  if(root == null)
           { return 0; }
           int leftNode = countNode(root.left);
           int rightNode = countNode(root.right);
           return leftNode + rightNode+1;
         }
        //  sum of the node;
         public static int sumOfNode(Node root)
         {  if(root == null)
            { return 0;}
            int leftNode = sumOfNode(root.left);
            int rightNode = sumOfNode(root.right);
            return leftNode + rightNode + root.data;
        }
        // calculating the daimeter of the tree
        // public static int diameter(Node root)
        // {  if(root == null)
        //     { return 0;}
        //     int ldim = diameter(root.left);
        //     int rdim = diameter(root.right);
        //     int lht = height(root.left);
        //     int rht = height(root.right);
        //     int selfdim = lht+rht+1;
        //     return Math.max(selfdim,Math.max(ldim,rdim));
        // }
    static class Info
    {   int dim = 0;
        int height = 0;
        public Info(int dim,int height)
        {   this.dim = dim;
            this.height = height;
        }
     }
     public static Info diameter(Node root)
     {  if(root == null)
        { return new Info(0,0);}
        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);
        // calculating height
         int height = Math.max(leftInfo.height,rightInfo.height)+1;
         int dim = Math.max(Math.max(leftInfo.dim,rightInfo.dim),leftInfo.height+rightInfo.height+1);
        return new Info(height,dim);
     }

     public static boolean isIdentical(Node node,Node subRoot)
     {
        if(node == null && subRoot == null)
        {return true;}
        else if(node == null || subRoot == null || node.data != subRoot.data)
        {return false; }
        if(!isIdentical(node.left,subRoot.left))
        { return false;}
         if(!isIdentical(node.right,subRoot.right))
        {return false; }
        return true; 
     }

     public  static boolean isSubtree(Node root, Node subTree)
      {
        if(root == null )
        {return false; }
        // identifying the subNode
        if(root.data == subTree.data)
        {  
            System.out.println("enter");
            if(isIdentical(root,subTree))
            { return true; }
        }
        return isSubtree(root.left,subTree)|| isSubtree(root.right,subTree);
      }

    static class Nodehd
    {// hd mean horizental distanc;
        int hd;
        Node node;
        public Nodehd(int hd,Node node)
        {   this.hd = hd;
            this.node = node;
        }
    }

    public static void topView(Node root)
    {  // here creating the queue
        Queue<Nodehd> q = new LinkedList<>();
        HashMap<Integer,Node> hm = new HashMap<>();
        q.add(new Nodehd(0,root));
        q.add(null);
        int min = 0;
        int max = 0;
        while(!q.isEmpty())
        {  Nodehd curr = q.remove();
            if(curr == null)
            { 
                if(q.isEmpty())
                {break; }
                else
                {q.add(null); }
            }
        
            else 
            {  if(!hm.containsKey(curr.hd))
                { hm.put(curr.hd,curr.node);}
                if(curr.node.left !=null)
                { q.add(new Nodehd(curr.hd-1,curr.node.left));
                 min = Math.min(min,curr.hd-1);
                }
                if(curr.node.right != null)
                { q.add(new Nodehd(curr.hd+1,curr.node.right)); 
                   max =Math.max(max,curr.hd+1);
                }
                
            }
        }
   for(int i = min; i<max; i++)
     {System.out.println(hm.get(i).data);}}

    
    public static void main(String args[])
    { 
        
         // here creating the tree
    //         //   1
    //         //  / \
    //         // 2   3
    //      //   / \   \
    //     //    4  5   6
              
        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);
        int a= 1^1;
    System.out.println("the xor"+a);
    //      //    2   
    //      //   / \   
    //     //    4  5   
    //     Node subTree = new Node(2);
    //     subTree.left = new Node(4);
    //     subTree.right = new Node(5);
    //     // System.out.println(isSubtree(root,subTree));
    //     topView(root);


     }
}