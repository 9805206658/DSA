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




class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int remaining = n;
        int step = 1;
        int head = 1;

        while (remaining > 1) {
            if (left || remaining % 2 == 1) {
                head += step;
            }
            remaining /= 2;
            step *= 2;
            left = !left;
        }

        return head;
    }
}



class Solution {
    public int lastRemaining(int n) {
        boolean left=true;
        return calc(n,left);
    }
    public int calc(int n, boolean left){
        if(n==1){
            return 1;
        }
        if(left){
            return 2*calc(n/2,false);   
            //if left to right, then elements from 1 to n will be processed
            //1 will be removed, then 3, then 5, ...
            //so the remaining are 2,4,6,...
            //this is basically 2*(1,2,3,...) and the ranges is now n/2
            //keep this in mind
        }else{
            //now in right to left, elements from n to 1 will be processed, and this makes 2 cases
            //earlier in left to right, we didnt get this case because n/2(gives floor of odd) adjusted our range to even 
            //and 2 * range gave the result
            //basically, 1st element is removed no matter the n and last even element is always left out because of
            //floor value returned by n/2
            //but we will get cases for below now
            if(n%2==0){
                //if our n is even and we are removing right to left, then first is always left out
                //but what we keep doing is 2 * range/2
                //so we need to subtract 1 to get the first element.
                //try to relate this to left to right
                //there also, we always skipped first element because it would be deleted no matter what
                //however here, first is getting left out, so u have to handle that by subtracting to reach the first element
                return 2*calc(n/2,true)-1;
            }else{  if(n%2==0){
                //otherwise if n is odd, then you dont have to worry
                //both first and last element will be removed no matter what
                //and this makes it similar to our left to right case
                //so just return how you did there
                return 2*calc(n/2,true);
            }
        }
    }
}





   
    public static void main(String args[])
    {
        //  printDec(10);
         printIncDic(10);
    // int arr[]={1,2,3,4,5,2,5,0};
    // int len=arr.length-1;
    //   fibonacci(5);
      }
}