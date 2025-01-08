public class Set1
{
  public static int generateBinary(int num)
  {
    
   int rem=0;
   int bin=0;
   int i=0;
    while(num>0)
    {
      rem=num%2;
      bin=bin+rem*(int)Math.pow(10,i);
      num=num/2;
      i++;
      }
      return bin;

  }
  public static int generateDecimal(int n)
  {
    int ans=0;
    int i=0;
    while(n>0)
    {
      int mod=n%10;
      ans=ans+(int)(mod*Math.pow(2,i));
      n=n/10;
      i++;
      
    }
    return ans;
  }
  public static void oddAndEven(int num)
  {
    int bitMask=2;
    if((num & bitMask)==0)
    {
        System.out.println("the number is even");
    }
    else 
    {
        System.out.println("the number is odd");
    }
  }

  // public static void getIthBit(int num,int i)
  // {
  //   int bitMask=2;
  //   if((num&i<<bitMask)==0)
  //   {System.out.println(0);}
  //   else
  //   { System.out.println(1); }
  // }

  public static  int getIthBit(int num,int i)
  {
    int bitMask=1<<i;
    if((num&bitMask)==0)
    {
      return 0;
    }
    else 
    {
      return 1;
    }
     
  }

public static int setIthBit(int num,int pos)
{
  int bitMask=(1<<pos);
  return (num|bitMask);
}
  // public static int setIthBit(int num,int pos)
  // { int bitMask=1<<pos;
  //   return (num | bitMask);}

  public static int clearIthBit(int num,int post)
  {
    int bitMask=~(1<<post);
    return (num & bitMask);
  }
  public static int  updateIthBit(int num,int pos,int newBit)
    {
     int firstBit= clearIthBit(num,pos);
      if(newBit==1)
      {
        return (firstBit|((1<<pos)));
      }
      else
      {
        return firstBit;
      }
    }
    

    public static int clearRangeBit(int num,int i,int j)
    {
      int a=((~0)<<j+1);
      int b=(1<<i)-1;
      int bitMask=(a|b);
      return (num & bitMask);
    }
    // clearing last ith bit 
  public static int clearLast(int num,int i)
  {
   int bitMask=(~0)<<i;
   return(num&bitMask);

  }
  public static boolean isPowerOfTwo(int n)
  {
    return ((n&(n-1))==0);

  }
  // here writing the function for counting the set bit 
  public static int countSetBit(int num)
  {
    int count=0;
    while(num>0)
    {
      if((num&1)==1)
      {
        count++;
      }
      num=(num>>1);

    }
    return count;
  }

  public static void swap(int a,int b)
  {
    System.out.println("the number before swap");
    System.out.println(a);
    System.out.println(b);
    System.out.println("after swapping ");
     a=a^b;
     b=a^b;
     a=a^b;
    System.out.println(a);
    System.out.println(b);
    }
    // add integer without using the not operator
    public static int fastExponential(int a,int n)
    {
      int ans=1;
      while(n>0)
      {
        // here find out the lsb
        if((n&1)!=0)
        {
           ans=a*ans;
        } a=a*a;
           n=n>>1;
        }
        // here find out ans;
      return ans;
    }
  

    public static void main(String args[])
    {
        // int a=5;
        // int b=6;

        // System.out.println(~5);  
        // System.out.println(5<<23);
        // oddAndEven(1);
        // getIthBit(6,2);
      // System.out.println("after positioning"+updateIthBit(5,2,0));
        // oddAndEven(9);
        //  System.out.println(generateBinary(clearRangeBit(10,2,4)));
        // System.out.println(countSetBit(7));
        // System.out.println(fastExponential(10));
        // swap(12,14);
        //  System.out.println(isPowerOfTwo());
        //  System.out.println(getIthBit(5,2));
        // System.out.println("+"+1+"is"+(-~23)); }
        System.out.println(generateDecimal((int) ('A')));
        System.out.println(generateBinary((int)('A')));

        // for(char ch='A';  ch<='z'; ch++)
        // {
        //   System.out.println((char)(ch|' '));
        // }
    }

}