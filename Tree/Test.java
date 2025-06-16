// import java.util.*;
// public class Test{
//      static class Node
//     {   int data;
//         Node left;
//         Node right;
//         public Node(int data)
//         {
//             this.data = data;
//             this.left = null;
//             this.right = null;
//         }
//     }
//     static int mod = 1000000007;
//     static int total = 0;
//     static int max = Integer.MIN_VALUE;
//     static int min = Integer.MAX_VALUE;
//     public static int sum(Node root)
//     { if(root == null)
//       return 0;
//        root.data =sum(root.left)+sum(root.right)+root.data;
//       return root.data;
//     }
//     public static void traverse(Node root)
//     {
//          if(root==null)
//             return;
//             System.out.println("data:"+root.data);
//         max = Math.max(root.data*(total-root.data),max);
//         traverse(root.left);
//         traverse(root.right);
//     }
//     public static int readData( int n)
//     {
//         if(n == 0)
//         {return 1; }
        
//         System.out.println(min);
//         min = Math.min(min,n-1);
//         return  n*readData(n-1);
//     }
//     public static void main(String args[])
//     {
//         // System.out.println(value);
//         min = Integer.MAX_VALUE;
//         System.out.println(readData(5));
        
        
    
//     }
// }



public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}



class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(q.peek() != null) {
            root = q.poll();
            if(root.right !=null) q.offer(root.right);
            if(root.left !=null) q.offer(root.left);
        }
        return root.val;
    }
}