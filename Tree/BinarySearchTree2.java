
import java.util.*;
public class BinarySearchTree2
{  static class  Node
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
        { root.left =buildBST(root.left,val);}
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
    public static Node createBST(int data[],int start,int end)
    {   if(start > end)
        {return null; }
        int mid = (start+end)/2;
        Node root = new Node(data[mid]);
        root.left = createBST(data , start,mid-1);
        root.right = createBST(data , mid+1,end);
        return root;
    }

    // here creating the class for storing information 
    static class Info 
    {
        boolean isBST ;
        int min ;
        int max ;
        int size;
        public  Info(boolean isBST,int min,int max,int size)
        {   this.isBST = isBST;
            this.min = min;
            this.max = max;
            this.size = size;
        }
    }
    static int maxSize = Integer.MIN_VALUE;
    public static Info findLargestBST(Node root)
    {   if(root == null)
        {return new Info(true,Integer.MIN_VALUE,Integer.MAX_VALUE,0); }
        Info leftInfo = findLargestBST(root.left);
        Info rightInfo = findLargestBST(root.right);
        int minCal = Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));
        int maxCal = Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
         int sizeCal =leftInfo.size + rightInfo.size + 1;
        //  System.out.println(sizeCal);
         if(root.data >= leftInfo.max || root.data <= rightInfo.min)
        { return new Info(false,minCal,maxCal,sizeCal);}
         System.out.println(leftInfo.isBST);
        System.out.println(rightInfo.isBST);
        if(leftInfo.isBST && rightInfo.isBST)
        { 
            System.out.println("enter");
            maxSize = Math.max(maxSize,sizeCal);
          return new Info(true,minCal,maxCal,sizeCal); }
        return new Info(false,minCal,maxCal,sizeCal); 
    } 
    // code mergin the 2bst;
    public static void preOrder(Node root)
    {
        if(root == null)
        { return ;
        }
        System.out.print(root.data+"->");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root,ArrayList<Integer> l)
    {   if(root == null)
        { return ;}
        inOrder(root.left,l);
        l.add(root.data);
        inOrder(root.right,l);
    }
    public static Node createBST(ArrayList<Integer> l,int left,int right)
    {   if(left > right)
        {return null; }
        int mid = (left+right )/2;
        Node root = new Node(l.get(mid));
        root.left = createBST(l,left,mid-1);
        root.right = createBST(l,mid+1,right);
         return root;
    }
    public static Node merge2BST(Node root1,Node root2)
    {    // preOrder sequence of root1;
        ArrayList<Integer> al1 = new ArrayList<>();
        ArrayList<Integer> al2 = new ArrayList<>();
        ArrayList<Integer> finalArr = new ArrayList<>();
        inOrder(root1,al1);
        inOrder(root2,al2);
        int i = 0; 
        int j = 0;
        while(i < al1.size() && j < al2.size())
        {  if(al1.get(i) < al2.get(j))
            { finalArr.add(al1.get(i));
                i++;
            }
            else 
            {  finalArr.add(al2.get(j));
                j++;
            }
        }
        // adding remaining element;
        while(i < al1.size())
        {
            finalArr.add(al1.get(i));
            i++;
        }
        while(j < al2.size())
        {
            finalArr.add(al2.get(j));
            j++;
        }
        return createBST(finalArr,0,finalArr.size()-1);
    }
    public static void main(String args[])
    {
        // here writing the code find largest bst
        
        
        // // tree 1;
        // Node root1 = new Node(2);
        // root1.left = new Node(1);
        // root1.right = new Node(4);

        // // tree2 ;
        // Node root2 = new Node(9);
        // root2.left = new Node(3);
        // root2.right = new Node(12);
        // Node mergeNode = merge2BST(root1,root2);
        // preOrder(mergeNode);
    }
}