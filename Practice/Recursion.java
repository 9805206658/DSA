import java.util.*;
public class Recursion{

    // remove duplicate character from the string 
    String str = "ssttdd"; 
    // std ans 
    // here repeat character e ;
    public static void removeDuplicate(String str,int index,HashMap<Character,Integer> hm,StringBuilder sb )
    {
        if(index == str.length())
        {  System.out.println( sb.toString());
            return ;

        }

        if(hm.containsKey(str.charAt(index)) == true)
        {removeDuplicate(str,index+1,hm,sb);}
        else 
        { hm.put(str.charAt(index),1);
            removeDuplicate(str,index+1,hm,sb.append(str.charAt(index)));
        }
    }
    public static void toh(char src,char mid,char des,int n,int count )
    {
        if(n == 1)
        {
            System.out.println("mover from"+src+"->" + des);
            count++;
            System.out.println(count);
            return ;
        }
        count++;
     toh(src,mid,des,n-1,count);
          System.out.println("mover from"+src+"->" + des);
        toh(src,des,mid,n-1,count);

         
    }
    
    public  static void main(String args[])
    {
        HashMap<Character,Integer> hm = new HashMap<>();
        StringBuilder sb =new StringBuilder();
        String str = "ssttdd";
       toh('S','M','D',3,0);

    }

    // count subString 
    


}