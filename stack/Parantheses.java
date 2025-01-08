import java.util.Stack;
public class Parantheses
{
    public static boolean validParantheses(String s)
    { Stack<Character> st = new Stack<>();
        for(int i= 0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
            {
                st.push(s.charAt(i));
            }
             if(st.isEmpty())
                {
                    return false;
                }
            if((s.charAt(i) == ')' && st.peek()=='(' ) || (s.charAt(i) == '}' && st.peek()=='{' ) || (s.charAt(i) == ']' && st.peek()=='[' ) )
            {
               st.pop();
            } 
        }
        if(st.isEmpty())
        {
            return true;
        }
       return false;
    }

    public static boolean duplicateParantheses(String str)
    {
        Stack<Character> st= new Stack<>();
        for(int i = 0; i < str.length(); i++)
        {  
            if(str.charAt(i) == ')')
            {  int count = 0;
               while(st.pop() != '(')
               { count++;} 
               if(count>0)
               { return true; }
               else 
               { 
                return false;
               }
            }
            else 
            {st.push(str.charAt(i)); }
        }
        return false;
    }
    public static void main(String args[])
    {
        // String str = "[{()]]";
        // System.out.println(validParantheses(str));
        String str = " ((a+b)+(c+d))";
        System.out.println(duplicateParantheses(str));
    }
}