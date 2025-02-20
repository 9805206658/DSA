import java.util.*;
public class Part1
{
    // longest common  substring 
    public static int LongestCommonSubstring(String str1, String str2)
    {
        // creating the 2d array
        int row = str1.length()+1;
        int col = str2.length()+1;
        int dp[][] = new int[row][col];
        int ans = 0;
        for(int i = 0; i < row; i++)
        {
            dp[i][0] = 0;
        }
        for(int j = 0; j < col; j++)
        {
            dp[0][j] = 0;
        }
        for(int i = 1; i < row; i++)
        {
            for(int j = 1; j < col ; j++)
            {
               if(str1.charAt(i-1) == str2.charAt(j-1))
               {
                System.out.println("ans:"+dp[i-1][j-1]);
                ans = Math.max(ans,dp[i-1][j-1]+1);
                dp[i][j] = ans;
                
               }
               else
               {
                dp[i][j] = 0;
               }
            }
        }
        return ans;
     }

// longest increasing subsequence
     public static void LIS(int num1[],int num2[])
     {
    //    here creating dp 
       int row = num1.length+1;
       int col = num2.length+1;
       int dp[][] = new int[row][col];
        for(int i = 0; i < row; i++)
        { dp[i][0] = 0;}
        for(int j = 0; j < col; j++)
        { dp[0][j] = 0; }
       for(int i = 1; i < row; i++)
       { for(int j = 1; j < col ; j++)
        {
          if(num1[i-1] == num2[j-1])
          {dp[i][j] = 1+ dp[i-1][j-1]; }
          else
          {  int n1 = dp[i-1][j];
             int n2 = dp[i][j-1];
             dp[i][j] = Math.max(n1,n2);
          }
        }
    }
    System.out.println("Longest common subsequence"+dp[row-1][col-1]);
  }
  j

    public static void main(String args[])
    {
        String str1 = "abcde";
        String str2 = "abgce";
        int arr[] = {50,3,10,7,40,80};
        int arr2[] = new int[arr.length+1];
        // here generate the unque element 
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < arr.length; i++)
        { hs.add(arr[i]);}
        int i = 0;
        // here creating the array and sort it 
        for(int num:hs)
        {  
           arr2[i] = num;
           i++;
        }
        Arrays.sort(arr2);
        LIS(arr,arr2);
    }
}