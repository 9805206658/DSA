// import java.util.Scanner;
public class Part1
{
    //print decrement order;
    public static void printInc(int n)
    {  if(n==1)
        {  System.out.println(n);
            return ; }
        printInc(n-1);
          System.out.println(n);
    } 
    // printing the number in decrement order;
    public static void printDec(int n)
    {
        if(n==1)
        {  System.out.println(1);
            return;
        }
        System.out.println(n);
        printDec(n-1);
     }
    //  calculation factiorial
     public static int factCal(int n)
     {
        int factN;
        if(n==0)
        {return 1;}
        factN=n*factCal(n-1);
        return factN; 
    }
    // print natural sum;
    public static int naturalSum(int n)
    {
        int sum;
        int sumN;
        if(n==-1)
        { return 1;}
        sumN=naturalSum(n-1);
        sum=n+sumN;
        return sum;
    }

//   printing the fibonicasis serries;
   public static int fibonacci(int n)
   { int fb1,fb2,fbn;
    if(n==0 || n==1)
    {
        return n;
    }
    fb1=fibonacci(n-1);
    fb2=fibonacci(n-2);
    fbn=fb1+fb2;
    System.out.println(fbn);
    return fbn;
    }
    // check arry sorte or not ;
    public static boolean isSorted(int arr[],int i)
    {
        if(i==arr.length-1)
        {return true; }
        if(arr[i]>arr[i+1])
        {return false;}
        return  isSorted(arr,i+1);
    }
    // wap to find the first occurence of an element in an array
    public static int firstOccurance(int arr[],int i,int target)
    {
        if((i==arr.length-1) && (arr[i]!=target))
        { return -1;}
        if(arr[i]==target)
        {
            return i;
        }
        return firstOccurance(arr,i+1,target); 
        }
        public static int lastOccurance(int arr[],int i,int target)
        {
            if(i==arr.length)
            {return -1 ;}
            int isFound=lastOccurance(arr,i+1,target);
             if(isFound==-1 && arr[i]==target)
             {return i; }
             return isFound;
        }
    
    // here defining the power function with the recurison
    public static int pow(int x,int n)
    {   if(n==0)
        {return 1;
        }
        int powx=pow(x,n-1);
        return x*powx;
    }
    public static int optimizedPower(int x,int n)
    {
        if(n==0)
        {return 1;
        }
        int halfPower=optimizedPower(x,n/2);
        int halfPowerSquare=halfPower*halfPower;
        if(n%2!=0)
        {
            halfPowerSquare=x*halfPowerSquare;
        }
        return halfPowerSquare;
    }
 
//   first occurnace number of using power function 
   
    public static void main(String args[])
    {
        //  printDec(10);
         printIncDic(10);
    // int arr[]={1,2,3,4,5,2,5,0};
    // int len=arr.length-1;
    //   fibonacci(5);
      }
}