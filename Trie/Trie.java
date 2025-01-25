public class Trie
{   static class Node
    {
        Node children[] = new Node[26];
        boolean eow ;
        public Node()
        { // intialize the node with the null value 
            for(int i = 0; i<children.length; i++)
            {children[i] = null; }
            eow = false;
        }

    }
    public static Node root = new Node();
      public static void insert(String words)
        {   Node curr = root;
            for(int level = 0; level<words.length(); level++)
            {
                char ch=words.charAt(level);
                if(curr.children[ch-'a'] == null)
                { curr.children[ch-'a'] = new Node(); }
               curr = curr.children[ch-'a'];
            }
             curr.eow = true;     
         } 
    
    public static boolean search(String str)
    {
        Node curr = root;
        for(int i = 0;i<str.length(); i++)
        {  int  idx = str.charAt(i)-'a';
            if(curr.children[idx] == null)
            {  return false; }
            curr = curr.children[idx];
        }
        if(curr.eow == true)   
        {  return true; }
         return false;
    }
    public static boolean wordBreak(String key)
    {
        if(key.length() == 0)
        {
            return true;
        }
        for(int i = 0;i<=key.length();i++)
        {if( search(key.substring(0,i)) && wordBreak(key.substring(i)))
           { return true; }
        }
        return false;

    }
    

    
    public static void main(String args[])
    {
        //  String words[] = {"the","a","there","their","any","thee"};
        //  for(int j = 0; j<words.length; j++)
        //  {
        //     insert(words[j]);
        //  }
        //  System.out.println(search("the"));
        //  System.out.println(search("any"));
        String words[] = {"i","like","sam","samsung","mobile","ice"};
        for(int i = 0; i < words.length; i++)
        {
            insert(words[i]);
        }
        String key="done";
        System.out.println(wordBreak(key));
    }
}