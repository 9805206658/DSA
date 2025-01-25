// longest words with all prefixes;
import java.util.*;
public class LongestWord
{
    static class Node{
        Node children[] = new Node[26];
        boolean eow;
        public Node()
        { for(int i = 0;i<children.length; i++)
            { children[i] = null;  }
        }
    }
    public static Node root = new Node();


      public static void insert(String words)
    {
        Node curr = root;
        for(int i = 0; i<words.length(); i++)
        {   int idx = words.charAt(i)-'a';
        
            if(curr.children[idx] == null)
            { 
             curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }


    public static String result = "";
    public static void longestWord(Node root,StringBuilder temp)
    {
        if(root == null)
        { return ;}
        for(int i=0; i<26; i++)
        {
            if(root.children[i] != null && root.children[i].eow == true)
            {
                char ch = (char)(i+'a');
                temp.append(ch);
                if(temp.length()>result.length())
                {result = temp.toString();}
                longestWord(root.children[i],temp);
                temp.deleteCharAt(temp.length()-1);
            }
        }

    }
    public static void main(String args[])
    {
        String strs[] = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        for(int i = 0; i<strs.length; i++)
        { insert(strs[i]); }
        longestWord(root,new StringBuilder());
        System.out.println(result);
        // String str = "bikal";
        // System.out.println(""-'a');
        // char chars[] = str.toCharArray();
        // Arrays.sort(chars);
        // System.out.println(chars);
        // int it = ' '-'a';
        // System.out.println(it);

     }
}