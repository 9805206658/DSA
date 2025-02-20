import java.util.*;
public class Part2
{
    public static int editDistance(String str1 , String str2)
    {
        int m = str1.length();
        int n = str2.length();
        int row = m+1;
        int col = n+1;
        int dp[][] = new int[row][col];
        for(int i = 0; i < row; i++)
        { for(int j = 0; j < col; j++)
            {   if(i == 0)
                { dp[i][j] = j; }
                if(j == 0)
                { dp[i][j] = i;}
            }
        }
        for(int i = 1; i < row; i++)
        { for(int j = 1; j < col; j++)
            { if(str1.charAt(i-1) == str2.charAt(j-1))
                { dp[i][j] = dp[i-1][j-1];}
                else{
                   int add = dp[i][j-1]+1;
                   int del = dp[i-1][j]+1;
                   int rep = dp[i-1][j-1]+1;
                   dp[i][j]= Math.min(add,Math.min(del,rep));
                }
            }
        }
        return dp[n][m];
     }

     public static void stringConversion(String str1 , String str2)
     {
        // here first finding longest common substing
        int row = str1.length()+1;
        int col = str2.length()+1;
        int dp[][]= new int[row][col];
        // set the row 0
        for(int i = 0; i < row; i++)
        { dp[i][0] = 0;}
        // set the col 0
        for(int j = 0; j < col; j++)
        {dp[0][j] = 0; }
        for(int i = 1; i < row; i++)
        {
            for(int j = 1; j < col; j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else 
                {   int rm1 = dp[i][j-1];
                    int rm2 = dp[i-1][j];
                    dp[i][j] = Math.max(rm1,rm2);
                }
            }
        }
        int lcs =dp[row-1][col-1];
        // no of deletion 
        System.out.println("the deletion"+(str1.length()-lcs));
        System.out.println("the insertion op "+(str2.length()-lcs));
        
        // no of insertion 
     }
     public  static int lps(String str1 ,String str2)
     {
        int m = str1.length()+1;
        int n = str2.length()+1;
        int prev[] = new int[m];
        int curr[] = new int[n];
        
        for(int i = 1; i < m; i++)
        {  for(int j = 1; j < n; j++)
            {  if(str1.charAt(i-1) == str2.charAt(j-1))
                { curr[j] = 1+ prev[j-1];o}
                else
                { curr[j] = Math.max(prev[j],curr[j-1]); }
            }
            prev = curr.clone();
        }
        return curr[n-1];
    }

    public static void main(String args[])
    {
        String str1 = "abbdbb";
        StringBuilder sb = new StringBuilder(str1);
        sb.reverse();
        String str2 = sb.toString();
        System.out.println(lps(str1,str2));   
    }
}