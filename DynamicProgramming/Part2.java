import java.util.*;
public class Part2
{
    // knapsack with the memorization
    // public static int knapSack(int wt[],int val[],int W,int i,int dp[][])
    // {

    //     if(i==0 || W == 0)
    //     { return 0; }
    //     if(dp[i][W] != -1)
    //     {
    //         return 0;
    //     }
    //      if(wt[i]<= W)
    //     {   // inclcude;
    //        int val1=val[i]+knapSack(wt,val,W-wt[i],i-1,dp);
    //         // exclude;
    //        int val2= knapSack(wt,val,W,i-1,dp);
    //       return  dp[i][W]=Math.max(val1,val2);
    //     }
    //     else 
    //     {
    //         // exclude
    //         return dp[i][W]=knapSack(wt,val,W,i-1,dp);
    //     }

    // }
    public static void knapsackTab(int wt[],int val[],int w)
    {
        // creating the matrix;
        int row = wt.length+1;
        int col = w+1;
        int dp[][] = new int[row][col];
        // filling column with zero
        for(int i =0; i < row; i++)
        {dp[i][0] = 0;}
        // filling the row with zero
        for(int j = 0; j< col;j++)
        { dp[0][j] = 0; }
        for(int i = 1; i < row; i++)
        { for(int j = 1; j < col; j++)
            {   int weight = wt[i-1];
                int value = val[i-1];
                if(weight <= j)
                {  // include condition
                    int include = value + dp[i-1][j-weight];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include,exclude);
                 }
                else 
                {  // exclude condition
                  dp[i][j] =  dp[i-1][j];
                }
                
            }
        }
    
        // here printing the final answer;
        System.out.println("the answer"+dp[wt.length][w]);

    }


public static void printArray(boolean arr[][])
{
    for(int i = 0; i < arr.length; i++)
    {  for(int j = 0; j < arr[0].length; j++)
        { System.out.print(arr[i][j]+" "); }
        System.out.println();
    }
}

public static void printArray(int arr[][])
{
    for(int i = 0; i < arr.length; i++)
    {  for(int j = 0; j < arr[0].length; j++)
        { System.out.print(arr[i][j]+" ");}
        System.out.println();
    }
}

    // target sum problem with tabulation
    public static void targetSum(int arr[],int target )
    {//here creating array
       boolean dp[][] = new boolean[arr.length+1][target+1];
    //    filling 0 when sum = 0;
       for(int i =0; i < arr.length+1; i++)
       {  dp[i][0] = true;}
    //    assign the meaning
     for(int i = 1; i < arr.length+1; i++)
     {
        for(int j = 1; j < target+1; j++)
        { int val = arr[i-1];
        //    include conidition
           if(val <= j && dp[i-1][j-val] == true)
           { dp[i][j] = true;}
        //    exclude condition
           else 
           { if(dp[i-1][j] == true )
             {  dp[i][j] = true; }
           }

        }
     }
     printArray(dp);
     System.out.println("the answer is"+dp[arr.length][target]);
    }
    // knapsack problme with unbounded weight;
    public static void knapSackUnbound(int wt[],int value[],int c)
    {  // create matrix;
        int row = wt.length+1;
        int col = c+1;
         int dp[][ ] = new int[row][col];
        // assign vlaue 
        for(int i = 0; i < row;i++)
        {dp[i][0]= 0; }
        // assign vlaue for 0 col;
         for(int i = 0; i < col;i++)
        { dp[0][i]= 0; }
        for(int i = 1; i < row; i++)
        {
            for(int j = 1; j < col; j++)
             {
                int weight = wt[i-1];
                int val = value[i-1];
                // include condition
                if(weight <= j)
                {   int include = val + dp[i][j-weight];
                    int exclude = dp[i-1][j];
                    dp[i][j] = Math.max(include,exclude);
                }
                else
                { dp[i][j] = dp[i-1][j]; }
                // exclude condition
             }
        }
        System.out.println(dp[row-1][col-1]);
        printArray(dp);

    }



 // knapsackbound logic  with recurision
 public static int knapsack(int wt[],int val[],int W , int i)
 {  // base case 
    if(i == 0 || W == 0)
    { return 0;}
   //   finding vlaue at index i;
     int value = val[i];
     int weight = wt[i];
    //  include condition
     if(weight <= W)
     {  int include =value+knapsack(wt,val,W-weight,i);
        int exclude = knapsack(wt,val,W,i-1);
        return Math.max(include,exclude);
     }
    //  exclude condition
     else 
     { return knapsack(wt,val,W,i-1); }
 }
 
  public static int coinChange(int[] coins, int amount) {
        int ans = coinCount(coins, amount);
        return (ans == Integer.MAX_VALUE) ?  -1 : ans;
    }

    public static int coinCount(int[] coins, int amount) {

        if(amount == 0) { return 0; }
        if(amount < 0) { return Integer.MAX_VALUE; }
        int minCoins = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int ans = coinCount(coins, amount - coins[i]);
            if(ans != Integer.MAX_VALUE) {
                //we have returned 0 in ans, so now we are updating the ans count
                //hence 1 + ans
                minCoins = Math.min(minCoins, 1 + ans);
            }
        }
        return minCoins;
    }
    public static void main(String args[])
    {

        Vector<Integer> v 
        = new Vector<>();
        v.addElement(1);
        v.addElement(2);
        v.removeElementAt(0);
        for(int i:v)
        {
            System.out.println(i);
        }


        // int wt[] = {2,5,1,3,4};
        // int val[] = {15,14,10,45,30};
        // int W = 7;
        // int dp[][] = new int[wt.length+1][W+1];
        // intialize it 
        // for(int i = 0; i < dp.length; i++)
        // { for(int j = 0; j < dp[0].length; j++)
        //     { dp[i][j] = -1; }
        // }
        // int size = wt.length;
        // System.out.println(knapSack(wt,val,W,size-1,dp));
        //  for(int i = 0; i < dp.length; i++)
        // { for(int j = 0; j < dp[0].length; j++)
        //     { 
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        // knapsack tabulation
        // knapsackTab( wt, val, W);
        // targetSum(arr, target );

        // int coins[] = {1,2,3};
        // int amount = 5;
        // System.out.println(coinChange(coins,amount));
        
    
    }
}







