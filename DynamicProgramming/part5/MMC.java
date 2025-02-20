import java.util.*;
public class MMC
{ 
    // matrix chain multipication
    public static int mmc(int arr[],int i,int j)
    {  if(i == j)
      { return 0;}
      int cost = Integer.MAX_VALUE;
      for(int k=i ; k<=j-1; k++)
      {  int cost1 = mmc(arr,i,k); 
         int cost2 = mmc(arr,i+1,j);
         int cost3 =arr[i-1]*arr[k]*arr[j];
         int ans = cost1+cost2+cost3;
         cost = Math.min(cost,ans);
      }  
      return cost;
    }
    // multiplication with the memorization
    public static int mmcMemo(int arr[],int i,int j,int dp[][])
    {
      if(i == j)
      {return 0; }
      if(dp[i][j] != -1)
      { return dp[i][j]; }
      int maxCost = Integer.MAX_VALUE;
      for(int k = i; k < j; k++)
      { int cost1 = mmcMemo(arr,i,k,dp);
        int cost2 = mmcMemo(arr,k+1,j,dp);
        int cost3 = arr[i-1]*arr[k]*arr[j];
        int totalCost = cost1+cost2+cost3;
        maxCost = Math.min(totalCost,maxCost);
       }
       return dp[i][j] = maxCost;
     }

    public static void printArray(int arr[][])
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


     public static void mmcTab(int arr[])
     {
        int n = arr.length;
        int dp[][] = new int[n][n];
        for(int i = 1; i < n; i++)
        { dp[i][i] = 0; }
        for(int len = 2; len <= n-1; len++)
        {   // row
         for(int i = 1; i <= n-len; i++)
           { // col
            int j = i+len-1;
            dp[i][j] = Integer.MAX_VALUE;
             for(int k = i; k <=j-1; k++)
             {
               int cost1 = dp[i][k];
               int cost2 = dp[k+1][j];
               int cost3 = arr[i-1]*arr[k]*arr[j];
               dp[i][j] = Math.min(dp[i][j],cost1+cost2+cost3);
             } }
          }
        // System.out.println(dp[1][n-1]);
        printArray(dp);
     }

// minimum partioning 
  public static void minimumPartioning(int arr[])
  {
    // find out the total sum
    int sum = 0;
    for(int i = 0; i < arr.length; i++)
    { sum += arr[i]; }
    int set1 = sum/2;
    // creating the dp array 
    int row = arr.length + 1;
    int col = set1 + 1;
    int dp[][] = new int[row][col];
    for(int i = 1; i < row; i++)
    {
      // weight
      for(int j = 1; j < col; j++)
      {
        // include condition
        if(j >= arr[i-1])
        { dp[i][j] = Math.max(arr[i-1]+dp[i-1][j-arr[i-1]],dp[i-1][j]);}
       // exclude condition
        else
        { dp[i][j] =dp[i-1][j]; }
      }
    }


    int sum1 = dp[row-1][col-1];
    int sum2 = sum-sum1;
    int gap = Math.abs(sum2-sum1);
    System.out.println("the minimum gap is"+gap);

  }


  // minimu jumps array
  public static void minimumJumps(int arr[])
  {  //n-1   ->   n-1 
    int dp[] = new int[arr.length];
    int n = dp.length;
    for(int i = 0; i < arr.length; i++)
    { dp[i] = -1;}
      dp[n-1] = 0;
    for(int i = n-2; i >= 0; i-- )
    {  int index = arr[i];
       int ans = Integer.MAX_VALUE;
       for(int j=i+1;  j<=i+index && j < n;  j++)
       {  ans = Math.min(ans,dp[j]+1);
        }
       if(ans != Integer.MAX_VALUE)
       {dp[i] = ans;}
    }
    System.out.println(dp[0]);
  }

  public static void main(String args[])
    {
    // int arr[] = {1,2,3,4,3};

    // mmcTab(arr);

    int arr[] = {1,6,11,5};
  //  minimumPartioning(arr);

   minimumJumps(arr);


    // int len = arr.length;
    // System.out.println(mmc(arr,1,len-1));
    // int n = arr.length+1;
    // int dp[][] = new int[n][n];
    // for(int i = 0; i < n; i++)
    // {
    //   Arrays.fill(dp[i],-1);
    // }
    // System.out.println(mmcMemo(arr,1,arr.length-1,dp));
  }
}





class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        for(int[] i : dp){
            Arrays.fill(i , -1);
        }
        // int ans = Integer.MAX_VALUE;
        // for(int j = 0; j < n; j++){
        //     ans = Math.min(ans, memoization(matrix, dp, n - 1, j));
        // }
        // return ans;
        // return tabulation(matrix);
        return spaceOptimization(matrix);
    }
    public int memoization(int[][] matrix, int[][]dp, int i, int j){
        if(j < 0 || j >= matrix.length) return (int)1e9;
        if(i == 0) return matrix[i][j];
        
        if(dp[i][j] != -1) return dp[i][j];
        int up = matrix[i][j] + memoization(matrix, dp, i - 1, j);
        int diag1 = matrix[i][j] + memoization(matrix, dp, i - 1, j - 1);
        int diag2 = matrix[i][j] + memoization(matrix, dp, i - 1, j + 1);
        int minPath = Math.min(up, Math.min(diag1, diag2));
        return dp[i][j] = minPath;
    }
    public int tabulation(int[][] matrix){
        int n = matrix.length;
        int[][] dp = new int[n][n];
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) dp[0][j] = matrix[0][j];
        for(int i = 1; i < n; i++){
            for(int j = 0; j < n; j++){
                int diag1 = 0, diag2 = 0;
                int up = matrix[i][j] + dp[i - 1][j];
                if(j > 0) diag1 = matrix[i][j] + dp[i - 1][j - 1];
                else diag1 = (int)1e9;
                if(j + 1 < n) diag2 = matrix[i][j] + dp[i - 1][j + 1];
                else diag2 = (int)1e9;
                int minPath = Math.min(up, Math.min(diag1, diag2));
                dp[i][j] = minPath;
            }
        }
        for(int j = 0; j < n; j++) ans = Math.min(ans, dp[n - 1][j]);
        return ans;
    }
    public int spaceOptimization(int[][] matrix){
        int n = matrix.length;
        int[] prev = new int[n];
        int ans = Integer.MAX_VALUE;
        for(int j = 0; j < n; j++) prev[j] = matrix[0][j];
        for(int i = 1; i < n; i++){
            int[] curr = new int[n];
            for(int j = 0; j < n; j++){
                int diag1 = 0, diag2 = 0;
                int up = matrix[i][j] + prev[j];
                if(j > 0) diag1 = matrix[i][j] + prev[j - 1];
                else diag1 = (int)1e9;
                if(j + 1 < n) diag2 = matrix[i][j] + prev[j + 1];
                else diag2 = (int)1e9;
                int minPath = Math.min(up, Math.min(diag1, diag2));
                curr[j] = minPath;
            }
            prev = curr;
        }
        for(int j = 0; j < n; j++) ans = Math.min(ans, prev[j]);
        return ans;
    }
}