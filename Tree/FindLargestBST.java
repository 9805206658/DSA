public class FindLargestBST{
    static class Node
    {   int data;
        Node left;
        Node right;
        public Node(int data)
        {   this.data = data;
            this.left = null ;
            this.right = null;
        }
    }
     static class Info{
        boolean isBST;
        int size;
        int max;
        int min;
        public Info(boolean isBST,int size,int max,int min)
        {   this.isBST = isBST;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }
    static int maxSize =0;
    public static Info calculateLargestBST(Node root)
    {
        if(root == null)
        { return new Info(true,0,Integer.MIN_VALUE,Integer.MAX_VALUE);}
        Info leftInfo = calculateLargestBST(root.left);
        Info rightInfo = calculateLargestBST(root.right);
        int totalSize = leftInfo.size + rightInfo.size + 1;
        int maxValue = Math.max(root.data,Math.max(leftInfo.max,rightInfo.max));
        int minValue = Math.min(root.data,Math.min(leftInfo.min,rightInfo.min));

        if(root.data <= leftInfo.min && root.data >= rightInfo.max)
        { return new Info(false,totalSize,maxValue,minValue);
        }
        if(leftInfo.isBST && rightInfo.isBST)
        {   maxSize = Math.max(maxSize,totalSize);
            System.out.println("leftmin"+leftInfo.min);
            System.out.println("rightInfo"+rightInfo.max);
            return new Info(true,totalSize,maxValue,minValue);
        }
         return new Info(false,totalSize,maxValue,minValue);

    }
 public static void main(String args[])
 {
    Node root = new Node(50);
    root.left = new Node(30);
    root.left.left = new Node(5);
    root.left.right = new Node(20);

    root.right = new Node(60);
    root.right.left = new Node(45);
    root.right.right = new Node(70);
    root.right.right.left = new Node(65);
    root.right.right.right = new Node(80);
    calculateLargestBST(root); 
    System.out.println(maxSize);
 }
}          