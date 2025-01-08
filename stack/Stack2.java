import java.util.*;
public class Stack2
{
    public static int[] nextSmallerRight(int nums[])
    {   Stack<Integer> st= new Stack<>();
        int ng[] = new int[nums.length];
        for(int i=nums.length-1; i>= 0; i--)
        {  while(!st.isEmpty() && nums[i]<nums[st.peek()])
            { st.pop(); }
            if(st.isEmpty())
            { ng[i] = nums.length-1;}
            else 
            { ng[i] = st.peek(); }
            st.push(i);
         }
      return ng;
     }

    public static int[] nextSmallerLeft(int nums[])
      {   Stack<Integer> st= new Stack<>();
        int ng[] = new int[nums.length];
        for(int i=0; i<nums.length; i++)
        {  while(!st.isEmpty() && nums[i]<nums[st.peek()])
            { st.pop(); }
            if(st.isEmpty())
            { ng[i] = -1;}
            else 
            { ng[i] = st.peek(); }
            st.push(i);
         }
         return ng;
       }

     public static void printArray(int nums[])
     {
        System.out.println();
        for(int i = 0; i<nums.length; i++)
        {   System.out.print(nums[i]);
        }
    }
    public static void maxReactangleArea(int nums[])
    {
        int numLeft[] = new int[nums.length];
        int numRight[] = new int[nums.length];
        numRight=nextSmallerRight(nums);
        numLeft=nextSmallerLeft(nums);
        int maxArea = 0;
        for(int i=0; i<nums.length; i++)
        {  int area = nums[i]*(numRight[i]-numLeft[i]-1);
            maxArea = Math.max(area,maxArea);
        }
        System.out.println("the max area is" + maxArea);
    }
   // max rectangular are in the historgram
    public static void main(String args[])
    { 
        int nums[]= {2,1,5,6,2,3};
        maxReactangleArea(nums);

     }
}