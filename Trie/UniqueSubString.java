public class UniqueSubString
{
    static int size= 0;
    static class Node
    {
        Node children[] = new Node[26];
        boolean eow;
        public Node()
        {   for(int i = 0;i<children.length; i++)
            { children[i] = null;} 
            eow = false;
         }
    }
    public static Node root= new Node();
    public static void insert(String words)
    {
        Node curr = root;
        for(int i = 0; i<words.length(); i++)
        {   int idx = words.charAt(i)-'a';
        
            if(curr.children[idx] == null)
            { 
             curr.children[idx] = new Node();
             size++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    public static int countNode(Node root)
    {  if(root == null)
        { return 0;}
        int count =0;
        for(int i = 0; i<26; i++)
        { if(root.children[i]!=null)
            { count += countNode(root.children[i]);
            }
        }
        return count+1;
     }


    public static void main(String args[])
    {
        String str="ababa";
       for(int i = 0; i<str.length();i++)
       {
         insert(str.substring(i,str.length()));
       }
       System.out.println(countNode(root));
    }
}