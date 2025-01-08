// import util.java.*;
public class PrimeNumber
{
    public static void binToDec(long binNum)
    {
        long binaryNumber=binNum;
        long pow=0;
        long lastDigit;
        long decNum=0;
    while(binNum>0)
        {
        lastDigit=binNum%2;
        decNum=decNum+ (lastDigit*(long)Math.pow(2,pow));
        pow++;
        binNum=binNum/10;   
        }
        System.out.println("binary to decimal"+binNum+" to "+decNum);

    }

    public static void decTobin(int decNum)
    {
        int decimalNumber=decNum;
        int pow=0;
        int binNum=0;
        while(decNum>0)
        {
            int rem=decNum%2;
            binNum=binNum+(rem*(int)Math.pow(10,pow));
            pow++;
            decNum=decNum/2;
        }
        System.out.println("the decimalNumber to binNum"+decimalNumber+"to"+binNum);


    }


    public static int avg(int a,int b,int c)
    {
        return ((a+b+c)/3);


    }
    public static boolean isEven(int n)
    {
        if(n%2==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void isPalindrome(int n)
    {
        //  here reverse number
        int actualNumber=n;
        int rev=0;
        while(n>0)
        {
            int rem=n%2;
            System.out.println("rem"+rem);
            rev=rev*10+rem;
            n=n/10;
            System.out.println(n);
         }
         System.out.println(rev);
         if(rev==actualNumber)
         {
            System.out.println("the give number is palindrome");
         }
         else
         {
            System.out.println("the give number is not palindrome");
         }

    }
    
    public static void main(String args[])
    {
     
     isPalindrome(50
     );

    }

}