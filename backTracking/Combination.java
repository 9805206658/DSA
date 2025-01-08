import java.util.*;
public class Combination
{ 
 public static void findPermutation(int nums[],int idx)
 {for(int i=idx; i<nums.length; i++)
   {
    System.out.print(nums[i]);
    findPermutation(nums,idx+1);
    System.out.println();
   }
 }
 public static void main(String args[])
  {  
    int data[] = {1,2,3};
    findPermutation(data,0);
    }
}