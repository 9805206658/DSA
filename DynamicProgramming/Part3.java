import java.util.*;
public class Part3{ 

    // longest common subsequences  find out the length
    public static int LCS(String str1 ,String str2,int n, int m,int db[][])
    {
        if(n == 0 || m == 0)
        {
            return 0;
        }
        if(db[n][m] != -1)
        {
            return db[n][m];
        }
        if(str1.charAt(n-1) == str2.charAt(m-1))
        {
            return db[n][m]=1+LCS(str1,str2,n-1,m-1,db);
        }
        else
        {
            int ans1 = LCS(str1,str2,n-1,m,db);
            int ans2 = LCS(str1,str2,n,m-1,db);
            return  db[n][m] = Math.max(ans1,ans2);
        }

    }
    // longest common subsequence through tabulation 
    public static void lcsTab(String str1, String str2)
    {
        // creating the 2d array
        int row = str1.length()+1;
        int col = str2.length()+1;
        int dp[][] = new int[row][col];
        // assining value in row ;
        for(int i = 0; i < row; i++)
        {dp[i][0] = 0;}
        for(int j = 0; j < col; j++)
        {dp[0][j] = 0;}
        
        for(int i = 1; i < row; i++)
        {
            for(int j = 1; j < col; j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                {dp[i][j] = 1+dp[i-1][j-1]; }
                else 
                {  int ans1 = dp[i][j-1];
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1,ans2);
                 }
             }
        }
        printArray(dp);
        System.out.println("the answer is"+dp[row-1][col-1]);

    }
    public static void printArray(int arr[][])
    {
        for(int i = 0; i < arr.length ; i++)
        {
            for(int j = 0; j < arr[0].length; j++)
            {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void coinChange(int coins[] , int amount)
    {
        // here creating 2d  matrix 
        int row = coins.length+1 ;
        int col = amount + 1; 
        int dp[][] = new int[row][col];
        // intialize
        for(int i = 0 ; i < col; i++ )
        { dp[0][i] = 0; }
         for(int j = 0 ; j < row; j++ )
        {  dp[j][0] = 1;}
        for(int i = 1; i < row; i++)
        {
            for(int j = 1; j < col; j++)
            {
                // include 
                int c = coins[i-1];
                if(c <= j)
                {
                   dp[i][j]= dp[i][j-coins[i-1]]+dp[i-1][j];
                }
                // exlude
                else
                { dp[i][j] = dp[i-1][j];}


            }
        }

    //  here printing the  require answer 
    System.out.println("the fewest number of ccoins"+dp[coins.length][amount]);
    }
    public static int  generateParenthesis(int openB ,int n,int total,int dp[][])
    {
        if(total == 2*n)
        {return 1;}
        if(dp[openB][total] != -1)
        { return dp[openB][total];}
        int ans = 0;
        if(openB < n)
        {  ans  +=  generateParenthesis(openB+1,n,total+1,dp);}
        if((total-openB)<openB)
        {  ans += generateParenthesis(openB,n,total+1,dp); }
        return dp[openB][total] = ans;

   }
    public static void  main(String args[])
    {
        // int coins[] = {1,2,5};
        // int amount = 11;
        // coinChange(coins,amount);
    //    String str1 = "abcde" ;
    //    String str2 = "ace";
    //    int n = str1.length();
    //    int m = str2.length();
    //    int db[][] = new int[n+1][m+1];
   
    //     for(int[] i : db)
    //     {
    //         Arrays.fill(i,-1);
    //     }
    //    System.out.println(LCS(str1,str2,str1.length(),str2.length(),db));
    //    printArray(db);
    // lcsTab(str1,str2);
    int n = 3;
    //    here creating 2d array dp for the valid prenthesis
    int row = n*2+1;
    int col = n+1; 
    int dp [][] = new int [row][col];
    for(int i = 0; i < row; i++ )
    { for(int j = 0; j < col; j++)
        { dp[i][j] = -1;  }
    }
    System.out.println(generateParenthesis(0,n,0,dp));


     }
}
    