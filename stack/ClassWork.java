import java.util.*;
public class ClassWork
{
 static class Node
 {
    char data ;
    Node next;
    public Node(char data)
    {  this.data = data;
       this.next =  null;
    }
 }
 public static void addLast(char data)
     {
        Node newNode = new Node(data);
        if(head == null)
        { head = tail =newNode;
          return ;
        }
        tail.next =newNode;
        tail = newNode;
     }
public static void printLL(Node head)
{   Node temp = head;
    while(temp != null)
    {   System.out.println(temp.data);
        temp = temp.next;
    }
}
 public static Node head;
 public static Node tail;
 public static String shorthPath(String str)
 {
   Stack<String> st = new Stack<>();
    StringBuilder sb = new StringBuilder();
      String [] strs = str.split("/");
        for(int i= 0; i<strs.length; i++)
        {st.push(strs[i]); }
        while(!st.isEmpty())
        {  
         String myStr = st.peek();
         if(myStr.compareTo("..") == 0)
            {   st.pop();
                st.pop();
            }
            else if((myStr.compareTo(".") == 0) || (myStr.compareTo("")==0) )
            { st.pop(); }
            else 
            {  String strr="/"+st.peek();
                System.out.println(myStr);
                sb.insert(0,strr);
                st.pop();
            }
       }
   return sb.toString();

 }
 public static void main(String args[])
    { 

     String str= "9ikal shrestha";
      System.out.println(Character.isDigit(str.charAt(0)));
      System.out.println('9'-'0')  ;
    }
}