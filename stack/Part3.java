import java.util.*;
public class Part3
{
    public static Stack<Integer> pushAtBottom(Stack<Integer> s, int data)
    {   if(s.isEmpty() == true)
        { s.push(data);
        return null;
        }
         int top = s.pop();
         pushAtBottom(s,data);
         s.push(top);
         return s;
    }
    public static String reverseString(String str)
    {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while(idx != str.length())
        {
            s.push(str.charAt(idx));
            idx ++;
        }
        // here creating the string builder 
        StringBuilder sb = new StringBuilder("");
        while(!s.isEmpty())
        {
           char data =s.pop();
           sb.append(data);
        }
        return  sb.toString();
     }

    public static void printStack(Stack<Integer> s)
    {   while(!s.isEmpty())
        { System.out.println(s.pop());
        }
    }

    // here function for reverseStack
    public static void stackReverse(Stack<Integer> s)
    { if(s.isEmpty())
        {  return ; }
        int top = s.pop();
        stackReverse(s);
        pushAtBottom(s,top);
    }
  public static void caclulateSpan (int []stock, int []span)
  {
    //  here making the stack
    Stack<Integer> s = new Stack<>();
    span[0] = 1;
    s.push(0);
    // here calculationg the previous index
    for(int i=1; i<stock.length; i++)
    {
        int curr=stock[i];
       while(!s.isEmpty() && curr>stock[s.peek()])
        {s.pop();}
        if(s.isEmpty())
        { span[i] = i+1;}
        else 
        {span[i] = i-s.peek();}
        s.push(i);
    }


  }


// brute force approach for the next greate element
public static void nextGreaterElement(int []arr,int[]rightGreater)
{

 for(int i=0; i<arr.length; i++)
 {
     boolean isGreater = false;
    for(int j=i+1; j<arr.length; j++)
    {
        if(arr[j]>arr[i])
        {
            rightGreater[i]= arr[j];
            isGreater = true;
            break;
         }
    }
    if( !isGreater)
    {rightGreater[i] = -1 ;}
 }

}

     
    public static void main(String args[]) 
    {
        // System.out.println(reverseString("bikal"));
    //    int []stock = {100,80,60,70,60,85,100};
    //    int []span  = new int[7];
    //    caclulateSpan(stock,span);
    //    for(int i=0; i<span.length ; i++)
    //    {
    //     System.out.println(span[i]);
    //    }
     int []arr = {6,8,0,1,3};
     int []rightGreater =new int[arr.length];
     nextGreaterElement(arr,rightGreater);
     for(int i=0; i<rightGreater.length; i++)
     {
        System.out.println(rightGreater[i]);
     }
     
    }

}