import java.util.*;
public class Part4
{
     public static String decode(String str)
     {
        Stack<Integer> stackInt = new Stack<>();
        Stack<Character> stackChar = new Stack<>();
        String temp="" ,result="";
        for(int i = 0; i < str.length(); i++)
        {
            int count = 0;
            if(Character.isDigit(str.charAt(i)))
            {  while(Character.isDigit(str.charAt(i)) )
                { count = count * 10 + str.charAt(i)-'0';
                    i++;
                }
                i--;
                stackInt.push(count);
            }
            else if(str.charAt(i) == ']')
            {
               
                if(!stackInt.isEmpty())
                { count = stackInt.pop();}
                while(!stackChar.isEmpty()&& (stackChar.peek() != ']'))
                {   temp = temp + stackChar.peek();
                    stackChar.pop();
                 }
                if(!stackChar.isEmpty() && stackChar.peek() == '[')
                {stackChar.pop();}
                for(int j=0; j<count; i++)
                { result = result+temp; }
                for(int j=0; j<result.length();j++ )
                { stackChar.push(result.charAt(i)); }
             }
            else if(str.charAt(i) == '[')
            {
                if(Character.isDigit(str.charAt(i-1)))
                stackChar.push(str.charAt(i));
                else 
                { stackChar.push(str.charAt(i));
                    stackInt.push(1);
                }
           }
            else 
            {stackChar.push(str.charAt(i));}
          
         }
           while(!stackChar.isEmpty())
            {
                result = stackChar.peek()+result;
                stackChar.pop();
            }
            return result;
    }

// trapping rain watere 
public static void printArray(int data[])
{
    System.out.println("the array");
    for(int i=0; i<data.length; i++)
    {
        System.out.print(data[i]);
    }
    System.out.println();
}
public static void trappingRainWater(int height[])
{
    int size=height.length;
         int maxLeft[]=new int[size];
         int maxRight[]=new int[size];
         int maxR=Integer.MIN_VALUE;
          int maxl=Integer.MIN_VALUE;
          int totalWater= 0;
       for(int i=0;i<size;i++)
         { if(height[i]>maxl)
            { maxl=height[i] ;}
            maxLeft[i]=maxl;
            int curr=(size-i)-1; 
            if(height[curr]>maxR)
            {  maxR=height[curr];}
            maxRight[curr]=maxR;
         }
       for(int i=0;i<size;i++)
        {   int trapWater=Math.min(maxLeft[i],maxRight[i])-height[i];
        System.out.print(trapWater);
            totalWater+=trapWater;
          }
        
       System.out.println("the total water"+totalWater);
 }
 
 public static void trapWaterStack(int data[])
 {
    Stack<Integer> stLeft = new Stack<>();
    stLeft.push(data[0]);
    Stack<Integer> stRight = new Stack<>();
    stRight.push(data[data.length-1]);
    for(int i = 1 ; i<data.length && !stLeft.isEmpty(); i++)
    {   if(data[i]>stLeft.peek()) 
        {stLeft.push(data[i]); } 
        else 
        { stLeft.push(stLeft.peek()); }
         int curr = data.length-i-1;
        if(data[curr]>stRight.peek()) 
        {stRight.push(data[curr]);}
        else 
        {  stRight.push(stRight.peek()); }
    }
    int totalWater = 0;
    for(int i= 0; i<data.length; i++)
    {
        int trapWater = Math.min(stLeft.pop(),stRight.pop())-data[i];
        totalWater += trapWater;
    }
    System.out.println(totalWater);
 }
 public static int tp(int data[])
 {
    Stack<Integer> stack = new Stack<>();
    int n = data.length;
    int ans = 0;
    for(int i = 0; i<n ; i++)
    {
        System.out.println("the i:"+i);
        while((!stack.isEmpty())&& (data[stack.peek()] < data[i]))
        {
            int pop_height = data[stack.peek()];
            System.out.println("the ph:"+pop_height);
            stack.pop();
            if(stack.isEmpty())
            {break; }
            int dis = i - stack.peek() - 1;
            int min_height = Math.min(data[stack.peek()],data[i])-pop_height;
            ans += dis*min_height;
            System.out.println(ans);
        }
        stack.push(i);
    }
    return ans;
 }

    public static void main(String args[])
    {  int data[] = {7,0,4,2,5,0,6,4,0,5};
        System.out.println(tp(data));
     }
}