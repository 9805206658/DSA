import java.util.*;
public class Part1
{
    // here printing fibonnacie series using the dynamic programming
    public static int fib(int n,int f[])
    {
        if( n== 1 || n == 0)
        { return  n;  }
        if(f[n] != 0)
        // f[n]!= 0 exist && f[n]== o not exist;
         {return f[n]; }
        //  assign  value and return it
        return f[n]= fib(n-1,f)+fib(n-2,f);
    }


    // sovling the problem of the stairs count with memorization in dp
    // public static int stairCount(int n ,int f[])
    // {
    //     if( n == 0)
    //     {return 1;}
    //     if( n < 0)
    //     { return 0; }
    //     if(f[n] != -1)
    //     {
    //         return f[n];
    //     }
    //     return f[n]=stairCount(n-1,f)+stairCount(n-2,f);
    // }


    // sovling the problem of the stairs count with tabulation in dp
    public static int stairCount(int n)
    {
        int arr[] = new int[n+1];
         arr[0] = 1;
        for(int i = 1; i<=n; i++ )
        {
            if(i == 1)
            {
              arr[i] =arr[i-1]+0;

            }
            else
            {
             arr[i] = arr[i-1]+arr[i-2];
            }
        }
        return arr[n];
    }


    public static void main(String args[])
    {
        // int n = 5;
        // // int f[]  = new int[n+1];
        // // System.out.println(fib(6,f));
        // int f[] =new int [n+1];
        // Arrays.fill(f,-1);
        // System.out.println(stairCount(5));
        System.out.println(9999999991+1);
        

    }
}