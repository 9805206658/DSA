public class AvlTree
{  static class Node
    {   int data,height;
        Node left,right;
        public Node(int data)
        {
            this.data = data;
         height = 1;
            
        }
    }
    public static Node root;
    public static int height(Node root)
    {  if(root == null)
        {return 0;
        }
        return root.height;
    }
    public static Node rightRotate(Node y)
    {
        Node x = y.left;
        Node t2 = x.right;
        x.right = y;
        x.left = t2;
        // calculate height
        y.height = Math.max(height(y.left),height(y.right))+1;
        x.height = Math.max(height(x.left),height(x.right))+1;
        return x;
    }
    public static Node leftRotate(Node x)
    {
        Node y = x.right;
        Node t2 = y.left;
        y.left = x;
        y.right = t2;
        // claculate height;
        x.height = Math.max(height(x.left),height(x.right));
        y.height = Math.max(height(y.left),height(y.right));
        return y;
    }
    public static int getBalance(Node root)
    {
        if(root == null)
        { return 0; }
        return (height(root.left) - height(root.right));
    }
    public static Node insert(Node root,int key)
    {
        if(root == null)
        { return new Node(key);}
        if(key < root.data)
        { root.left = insert(root.left,key); }
        else if(key > root.data)
        { root.right = insert(root.right,key);}
        else 
        return root; // duplicate key not allowed;
        // calculate height
        root.height = 1+Math.max(height(root.left),height(root.right));
        // get root balance factor
        int bf = getBalance(root);

        // left left case
        if(bf > 1 && key < root.left.data)
        {rightRotate(root);}

        // right right case
        if(bf <-1 && key > root.right.data)
        {leftRotate(root); }
        // left right case
        if(bf >1 && key > root.left.data)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        // right left case
        if(bf < -1 && key < root.right.data)
        {   root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }

    public static void preOrder(Node root)
    {
        if(root == null)
        {
            System.out.print("null");
            return ;
        }
        System.out.println(root.data+"->");
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void main(String args[])
    {
        root = insert(root,10);
        root = insert(root,20);
        root = insert(root,30);
        root = insert(root,40);
        root = insert(root,50);
        // root = insert(root,25);
        preOrder(root);
       
    }
}