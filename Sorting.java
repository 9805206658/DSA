import java.util.*;
import java.util.Arrays;
import java.util.Collections;

public class Sorting 
{  
    public static void printArray(int data[])
    {
        for(int i=0;i<data.length;i++)
        {
            System.out.print(data[i]);
        }

    }
    
    
    public static void bubbleSort(int data[])
    {
        int n=data.length;
        int swaps=0;
        boolean isSort=true;
        for(int i=0;i<n-1;i++)
        {
            if(data[i]>data[i+1])
            {
                isSort=false;

            }
        }
       
       
       if(isSort==false)
       {

        for(int i=0;i<n-2; i++)
        {
            for(int j=0; j<=n-2-i; j++)
            {
           
                if(data[j]<data[j+1])
                {
                       swaps++;
                    int swap=data[j];
                    data[j]=data[j+1];
                    data[j+1]=swap;}  }

        }
       }
        for(int i=0; i<n; i++)
        {
            System.out.print(data[i]);
        }}


     public static void selectionSort(int nums[])
     {
        int size=nums.length;
         for(int count=0; count<size-1; count++)
         {

            int smallest=count;
            for(int j=count+1;j<size;j++)
            { 

               if(nums[smallest]>nums[j])
               {
                smallest=j;
               }

            }
           int swap=nums[smallest];
           nums[smallest]=nums[count];
           nums[count]=swap;
           
         }
         for(int i=0;i<size;i++)
         {
            System.out.println(nums[i]);
         }

     }
     public static void insertionSort(int arr[])
     {
        for(int i=1;i<arr.length;i++)
        {
            int curr=i;
            int temp=arr[i];
            int prev=i-1;
            while((prev>=0) && (arr[prev]>temp))
            {
                arr[prev+1]=arr[prev];
                prev--;
            }
            arr[prev+1]=temp;
        }
        for(int i=0;i<arr.length;i++)
         {
            System.out.println(arr[i]);
         } 
         }

    // 
    public static void countingSort(int data[])
    {
        // find out the max value
        int largest=Integer.MIN_VALUE;
        for(int i=0;i<data.length;i++)
        {
            largest=Math.max(largest,data[i]);
        }
        System.out.print("the largest value "+largest);
        int count[]=new int[(largest+1)];
        // store the value  in count array
        for(int i=0;i<data.length;i++)
        {
            count[data[i]]++;

        }
        int j=0;
        for(int i=0;i<count.length;i++)
        {
                while(count[i]>0)
                {
                    data[j]=i;
                    j++;
                    count[i]--;
                }
             
        }
       printArray(data);
    }
         
    public static void main(String args[])
    {
    int data[]={5,8,7,6,1,2,3};
    countingSort(data);}
}