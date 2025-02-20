class Solution {

      public  void printArray(int arr[][])
       {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[0].length; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
      }
    public String longestPalindrome(String s) {
  
        //  create dp
        int n = s.length();
        int dp[][] = new int[n][n];
        int left = 0;
        int right = 0;
        int ans = 1;
        // 1 length character always palindrome
        for(int i = 0; i <n; i++ )
        {
            dp[i][i] =1;
        }
        // 2 length palindrome 
        for(int i = 0;i+1 < n; i++)
        { 
            int start = i;
            int end = i+1;
          if(s.charAt(start) == s.charAt(end))
            {
              dp[start][end] = 1;
               if(ans == 1)
               {  ans = 2;
                 left =start;
                 right = end;
               }

            }
        }
        // for length greater than 2;
        for(int len = 3; len <= n ; len ++) 
        {
            for(int i = 0; i+len-1 < n; i++)
            {   int start = i;
                int end = i+len-1;
                // checking palindrome after remove first and last index letter
                if((s.charAt(start) == s.charAt(end)) && dp[start+1][end-1] == 1)
                { 
                    dp[start][end] = 1;
                    if(len > ans)
                    {
                        ans = len ;
                        left = start;
                        right = end;
                    }
                 }
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int i = left; i <= right; i++)
        { sb.append(s.charAt(i));
        }
      printArray(dp);
        return sb.toString();     
    }

    
}








public class Part4
{
    public static void printArray(boolean arr[][])
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[0].length; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    // wildCard matching  problme 
    public static boolean isMatch(String s,String  p)
    {
        int row = s.length()+1;
        int col = p.length()+1;
        boolean dp[][] = new boolean[row][col];
        dp[0][0] = true;
        // set row false in which col = 0
        for(int i = 1; i < row; i++ )
        { dp[i][0] = false; }
        
        // set col where string is empty
        for(int j = 1; j < col ; j++)
        {   System.out.println(s.charAt(j-1));
            if(p.charAt(j-1) == '*')
            { dp[0][j] = dp[0][j-1]; }
        }


        for(int i = 1; i < row; i++)
        {
            for(int j = 1; j < col; j++)
            {
                // condition for ? string last character are simila
                if((s.charAt(i-1) == p.charAt(j-1)) || (p.charAt(j-1) == '?'))
                { dp[i][j] = dp[i-1][j-1];}
                // * case
                else if(p.charAt(j-1) == '*')
                { // ignore case + accept case 
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else
                {
                    dp[i][j] = false;
                }
            }
        }

                printArray(dp);
        return dp[row-1][col-1];
    }

// catalyan number printing
    public static int catalyanNumber(int n)
    {
        // base case 
        if(n == 1 || n == 0)
        {
            return 1;
        }
         int ans = 0;
        for(int i = 0; i <= n-1; i++)
        { 
           ans += catalyanNumber(i)*catalyanNumber(n-1-i);
        }
        return ans;
    }

// catalyan number printing with the memorization
   public static int catalyanNumberMemo(int n,int dp[])
   {
    if(n == 0 || n == 1)
    {
        return 1;
    }
    if(dp[n-1] != -1)
    { return dp[n]; }
    int ans = 0;
    for(int i = 0; i <= n-1; i++)
    {
        ans += catalyanNumberMemo(i,dp) * catalyanNumberMemo(n-i-1,dp);
    }
    return dp[n] = ans;
  }
  public static int catalyanNumberTab(int n)
  {
    // create the array
    int dp[] = new int[n+1];
    // intialization
    dp[0]=dp[1] = 1;
    for(int i = 2; i <= n; i++)
    { for(int j = 0; j < i; j++)
        {
            // assign the meaning
            dp[i] += dp[j]*dp[i-j-1];
        }
    }
    return  dp[n];
  }

    public static void main(String args[])
    {
    //    String str = "abcd";
    //    String pattern = "ab*?";
    //    System.out.println(isMatch(str,pattern));
    // int n = 3;
    // int dp[] = new int[n];
    // for(int i  = 0; i < n; i++)
    // { dp[i] = -1; }
    String str = "abbbd";
    Solution sol = new Solution();
    System.out.println(sol.longestPalindrome(str));
    // System.out.println( catalyanNumberTab(n));
    }
}