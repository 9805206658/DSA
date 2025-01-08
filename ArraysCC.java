import java.util.*;
public class ArraysCC
{
  public static int min_max(int num[])    
{
  int smaller=Integer.MAX_VALUE;
  int maximum=Integer.MIN_VALUE;
  for(int i=0;i<num.length; i++)
  {
    if(num[i]<smaller)
    {
      smaller=num[i];
    }
    if(num[i]>maximum)
    {
      maximum=num[i];
    }
  }
  System.out.println("the maximum value is:"+maximum);
  return smaller;
  }
  // linear search
  public static int linearSearch(String girl)
  {
    String girls[]={"siya","sarmila","panisha"};
    for(int i=0; i<girls.length; i++)
    {
      if(girls[i].compareTo(girl)==0)
      {
      return i;
      }
    }
     return -1; 
      
   
  }
  public static int binary_search(int num[], int key)
  {
    int start=0;
    int end=num.length-1;
    int mid=0;
    while(start<=end)
    {
      
      mid=(start+end)/2;
      System.out.println("start:"+start);
      System.out.println("end:"+end);
      System.out.println("mid:"+mid);
      if(num[mid]==key)
      {
        return num[mid];
      }
      if(num[mid]>key)
      {
        end=mid-1;

      }
      if(num[mid]<key)
      {
        start=mid+1;
      }

    }
    System.out.println();
    return -1;

  }

  public static void reverseArray(int marks[])
  {
    int start=0;
    int end=marks.length-1;
   
    while(start<end)
    {
       int temp=0;
      temp=marks[start];
      marks[start]=marks[end];
      marks[end]=temp;
   
      start=start+1;
      end=end-1;
       }

  }
  public static void printPairs(int num[])
  {
    for(int i=0;i<num.length;i++)
    {
    
      for(int j=i+1;j<num.length; j++)
      {
        System.out.print("("+num[i]+","+num[j]+")");
      }
      System.out.println();
    }


  }

    public static void printSubArray(int num[])
    {
      for(int i=0;i<num.length;i++)
      {
       
        for(int j=i+1;j<num.length;j++)
        {
          System.out.print("(");
          for(int k=i; k<j;k++)
          {
            System.out.print(+num[k]+",");
          }
          System.out.print(") ");
        }
        System.out.println();
      }

    }

public static void subArrayMaxMin(int marks[])
{
  int min=Integer.MAX_VALUE;
  int max=Integer.MIN_VALUE;
  for(int i=0;i<marks.length;i++)
  {
   int start=i;
    for(int j=start+1;j<marks.length;j++)
    {
      int end=j;
      int sum=0;
       System.out.print("[");
      for(int k=start;k<end;k++)
      {System.out.print(marks[k]+" ");
      sum=sum+marks[k];
      }
      if(sum<min)
      {
        min=sum;
      }
      if(sum>max)
      {
         max=sum;
      }
  
      System.out.print("]=");
      System.out.println(sum);
    }
  }
  System.out.println("the maximum value"+max);
  System.out.println("the minimum value"+min);

}


 public  static int[] plusOne(int[] digits) {
  int count=0;
        for(int i=digits.length-1;i>=0;i--)
        {
            if(digits[i]+1 != 10)
            {
                digits[i] += 1;
                count++;
                System.out.println("the count is "+count);
                return digits;
            }
            digits[i]=0;
        }
        int [] newDigits = new int[digits.length + 1];
        newDigits[0]=1;
        
        return newDigits;
        
    }
   public static void main(String args[])
    {
      int []digits={9,8,7,6,5,4,3,2,1,9};
       int []digts2=plusOne(digits);
       for(int i=0;i<digts2.length;i++)
       {
        System.out.println(digts2[i]);
       }


    }
       
     
}



     
     