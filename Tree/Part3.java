import java.util.*;
public class Part3
{
     static class Node
     {  int data;
        Node left;
        Node right;
        public Node(int data)
        {   this.data = data;
            this.left = null;
            this.right = null;
        }
     }
     public static void kthLevel(Node root,int currLevel, int target)
     {
         if(currLevel == target)
         {System.out.println(root.data);}
         if(root == null)
         {return ; }
         kthLevel(root.left,currLevel+1,target);
         kthLevel(root.right,currLevel+1,target);
     }
    //  defining the findpath function
    public static boolean findPath(Node root,int n1, ArrayList<Node> path)
    {
        if(root == null)
         {return false;}
         path.add(root);
         if(root.data == n1)
         { return true;}

         Boolean leftPath = findPath(root.left,n1,path);
         Boolean rightPath = findPath(root.right,n1,path);

         if(leftPath || rightPath)
         { return true;}

         path.remove(path.size()-1);
         return false;
    }
    //  find out the lowest commont ancestor
     public static Node lca(Node root,int n1,int n2 )
     {  // defining the arrayList
      ArrayList<Node> path1 = new ArrayList<>();
      ArrayList<Node> path2 = new ArrayList<>();
      findPath(root,n1,path1);
      findPath(root,n2,path2);
    // after finding the path comare the commont ancestor
    int i=0;
     for(; i<path1.size() && i<path2.size();i++)
     {if(path1.get(i).data != path2.get(i).data)
        {break; }
     }
     return  path1.get(i-1);
    
 }
 //lca 2;
 public static Node lca2(Node root,int n1,int n2 )
 {
    if(root == null)
    {return null; }
    if(root.data == n1 || root.data == n2)
    { return root; }
    // get node lca from left sub tree;
    Node nodeLeft  =  lca2(root.left ,n1, n2);
    // get node lca from right sub tree;
    Node nodeRight =  lca2(root.right, n1, n2);
    if(nodeLeft == null)
    { return nodeRight;}
    if(nodeRight == null)
    { return nodeLeft;}
    return root;
 }

  
  public static int findDistance(Node root,int n)
  { // base case
     if(root == null)
      {return -1;}
     if(root.data == n)
      {return 0;}
    //   search left
     int leftDis = findDistance(root.left,n);
    //  search right
     int rightDis = findDistance(root.right,n);
    //  both distance -1;
    if(leftDis == -1 && rightDis == -1)
     { return -1;}
    //    one of distance -1  condition 
     else if(leftDis == -1)
     {return rightDis+1;}
     else 
     {return leftDis+1; }
}

// here printing the kth ancestor of the node
public static int findKth (Node root,int n,int k)
{    if(root == null)
     { return -1; }
     if(root.data == n)
     {return 0;}
    //  find left distance and right distance
     int rDis = findKth(root.left,n,k);
     int lDis = findKth(root.right,n,k);
     if(rDis == -1 && lDis == -1)
    {return -1; }
     int max = Math.max(rDis,lDis);
    //check distance match with root node or not  
     if(max+1 == k)
     {System.out.println(root.data); }
     return max+1;   
}
  
//   calculating the minDistance between to node;
  public static int minDis(Node root,int n1,int n2)
  {
    Node lca = lca2(root,n1,n2);
    int dis1 = findDistance(lca,n1);
    int dis2 = findDistance(lca,n2);
    return dis1+dis2;
  }

  // here defining the sum tree;
  public static int sumTree(Node root)
  {   if(root == null)
      { return 0;}
      int leftChild = sumTree(root.left);
      int rightChild = sumTree(root.right);
      int data = root.data;
      int newLeft = root.left == null? 0 : root.left.data;
      int newRight = root.right== null? 0 : root.right.data;
      root.data = newLeft+leftChild+newRight+rightChild;
      return data;
  }


  // maximum path sum;
    static int maxSum = Integer.MIN_VALUE;
    public static  int maxPathSum(Node root) {
        findMax(root);
        return maxSum; 
        }
    public static int findMax(Node root)
    {  if(root == null)
        { return 0; }
        int leftValue = Math.max(0,findMax(root.left));
        int rightValue = Math.max(0,findMax(root.right));
        int sum = Math.max(leftValue,rightValue)+root.data;
        maxSum = Math.max(leftValue+rightValue+root.data,maxSum);
        return sum;
    }
  public static void preOrder(Node root)
  {
      if(root == null)
      {
        return ;
      }
      System.out.println(root.data);
      preOrder(root.left);
      preOrder(root.right);

  }

    public static void main(String args[])
    {  // here creating the tree;
    //   1
    //   /\
    //  2  3
    //  /\  /\
    // 4  5 6 7
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(-30);
        root.left.left = new Node(-20);
        root.left.right = new Node(30);
        root.right.right = new Node(20);
        root.right.left =new Node (30);
        // System.out.println(minDis(root,5,6));
        // int k = 2;
        // kthLevel(root,1,k);
        // sumTree(root);
       // preOrder(root);
        System.out.println("the maximum sum is "+maxPathSum(root));
      // System.out.println("hellow world");
      
       }
}