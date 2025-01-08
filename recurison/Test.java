public class Test
{  
    public static void lastOccurance(int target,int []arr,int i,int find)
    {   if(i == arr.length)
        { System.out.println(find);
          return ;
        }
        if(arr[i] == target)
        { find = i;}
        lastOccurance(target,arr,i+1,find);
    }
    public static void firstOccurance(int target,int []arr,int i,int find)
    {  if(i == arr.length)
       { System.out.println(find);
        return ;
       }
       if(arr[i] == target)
       {find = i;}
      firstOccurance(target,arr,i+1, find);
    }
    public static int pow(int x,int n)
    {   if(n==0)
        {  return 1;}
        return x*pow(x,n-1);
    }
    public static int optimizedSquare(int x,int n)
    {   if(n==0)
        {return 1;}
        int halfPower = optimizedSquare(x,n/2);
        int halfPowerSquare = halfPower*halfPower;
        if(n%2 != 0)
        {return x*halfPowerSquare;}
        return halfPowerSquare;
     }
  public static void main(String args[])
    { int []arr = {1,2,3,5,6,7,9,5};
       System.out.println(optimizedSquare(5,4));
    }
}