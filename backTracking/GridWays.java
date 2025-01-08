import java.util.*;
public class GridWays
{
    // print matrix;
    public static void printMatrix(int matrix[][])
    {
        for(int i=0;i<matrix.length; i++)
        {
            for(int j=0; j<matrix.length; j++)
            {  System.out.print(" "+matrix[i][j]+" ");}
            System.out.println();
        }

    }
    public static int findGrids(int i,int j,int n,int m, int sum,int sol[][])
      { System.out.println("the point"+"("+i+","+j+ ")");
      if(i == n-1 || j == m-1)
        {return 1;}
        else if(i<0 || j<0)
        {  return 0;}
        sol[i][j]=sum;
        sum++;
        int firstWays = findGrids(i,j+1,n,m,sum,sol);
        int secondWays = findGrids(i+1,j,n,m,sum,sol);
        return firstWays+secondWays;
     }

   public static boolean isSafe(int x,int y,int mazhe[][])
     { 
        int n = mazhe.length;
        System.out.println("x:"+x);
        System.out.println("x:"+y);
        if( x>=0 && y>=0 && x<n && y<n && mazhe[x][y]==1)
       {return true;}
       return false;
     }

// here solving maghi problem
   public static  boolean solveMaghi(int x,int y,int sol[][],int mazhe[][])
   {
    if(x == sol.length-1 && y == sol.length-1 && sol[x][y] == 1)
      { return true; }
    if(isSafe(x,y,mazhe) == true)
    { System.out.println("enter");
        sol[x][y]=1;
        if(solveMaghi(x+1,y,sol,mazhe))
        {return true;}
        if(solveMaghi(x,y+1,sol,mazhe))
        { return true;}
     }
     return false;
}

    public static void main(String args[])
    {
        // int m = 3;
        // int n = 3;
        // // here defining the empty matrix
        // int [][] grid= new int[n][n];
        // for(int i=0; i<n; i++ )
        // {for(int j=0; j<n; j++)
        //     {  grid[i][j]=0; }
        // }
    //   here creating the matrix for the maghi
    int mazhe[][]=
    {   {1,0,0,0},
        {1,1,0,1},
        {0,1,0,0},
        {1,1,1,1}
    };
    int n = mazhe.length;
    int sol[][]=new int[n][n];
    solveMaghi(0,0,sol,mazhe);
    printMatrix(sol);

    }
}