import java.util.*;
public class Part3
{
    // perfrom lcs through memorization
    public static int lcsMemo(String str1,String str2,int n,int m)
    {
        if(n == 0 && m == 0)
        {return  0; }
        if(str1.charAt(n-1) == str2.charAt(m-1))
        {  return lcsMemo(str1,str2,n-1,m-1)+1 ;}
        else
        {  return lcsMemo(str1,str2,n-1,m-1);}
    }
    // peform lcs through recursion
    public static int lcs(String str1,String str2,int n,int m,int dp[][])
    {
        if(n == 0 || m == 0)
        {return  0; }
        if(dp[n][m] != -1)
        { return dp[n][m]; }
        if(str1.charAt(n-1) == str2.charAt(m-1))
        { return dp[n][m] = lcs(str1,str2,n-1,m-1,dp)+1 ;}
        else
        { 
          return dp[n][m]  = Math.max(lcs(str1,str2,n,m-1,dp),lcs(str1,str2,n-1,m,dp));
        }
    }


   public static void lcsTab(String str1,String str2)
    {
        int len = str1.length()+1;
        int dp[][] = new int[len][len];
        // intialize 
        for(int i = 0; i < len; i++)
        {  dp[i][0] = 0; }

        for(int j = 0; j < len; j++)
        {  dp[0][j] = 0; }

        for(int i = 1; i < len; i++)
        {
            for(int j = 1; j < len; j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                {
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else
                {   dp[i][j] =dp[i-1][j-1];
                }
            }
        }
        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < len; j++)
            {
                System.out.print(dp[i][j]);
            }
            System.out.println();
        }
        System.out.println(dp[len-1][len-1]);
        
    }

    public static void main(String args[])
    {
        String str = "bbbab";
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        int n = str.length();
        // here creating the dp for the memorization
        int len = str.length()+1;
        int dp[][] = new int[len][len];
        for(int i = 0; i < len; i++)
        { for(int j = 0; j < len; j++)
            {dp[i][j] = -1; }
         }
         System.out.println(lcs(str,sb.toString(),n,n,dp));

          
    }
}


