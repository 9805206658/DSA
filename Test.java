public class Test
{
    // sorting in the descending  order
    public static void bubbleSortDecending(int data[])
    {
        for(int i=0;i<data.length;i++)
        {
            for(int j=0;j<(data.length-i)-1;j++)
            {
                if(data[j]<data[j+1])
                {
                    int temp=data[j];
                    // data[j]=data[j+1]
                    data[j+1]=temp;
                }
            }
           
        }
        for(int i=0;i<data.length;i++)
        {
            System.out.println(data[i]);
        }
    }
    public static void selectionSort(int arr[])
    {
      for(int i=0;i<arr.length-2;i++)  
      {
        int largest=i;
        for(int j=i+1;j<arr.length-1;j++)
        {
            if(arr[largest]>arr[j])
            {
                largest=j;
            }
        }
        // swapping
        int temp=arr[largest];
        arr[largest]=arr[i];
        arr[i]=temp;  }
       for(int i=0;i<arr.length;i++)
        {System.out.println(arr[i]); }}

        public static void insertionSort(int arr[])
        {
            for(int i=1;i<arr.length;i++)
        {
            int curr=i;
            int temp=arr[i];
            int prev=i-1;
            while((prev>=0) && (arr[prev]<temp))
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

        //  sorting using the selection sort
       public static void countingSort(int data[])
       {
        int size=data.length;
        // here finding the max value
        int max=Integer.MAX_VALUE;
        for(int i=0;i<size;i++)
        {
         max=Math.max(data[i],max);
        }
        // defining the each frequency
        int []count=new int[max];
        for(int i=data.length;i>=0;i++)
        {
            count[data[i]]++;
        }


        // storing array and finally printing the number
        int counter=0;
        for(int i=0;i<count.length;i++)
        {
            while(count[i]>0)
            {
                data[counter]=i;
                count[i]--;
                counter++; } }
        for(int i=0;i<data.length;i++)
         {
            System.out.println(data[i]);
         } 
            }

public static  void printArray(int data[])
{
    for(int i=0;i<data.length;i++)
    {
        System.out.println(data[i]);
    }
}


 public  static int trap(int[] height) {
        // deciding maximum left and right height for each element
         int size=height.length;
         int maxLeft[]=new int[size];
         int maxRight[]=new int[size];
         int maxR=Integer.MIN_VALUE;
          int maxl=Integer.MIN_VALUE;
          int totalWater= 0;
       for(int i=0;i<size;i++)
         {
            if(height[i]>maxl)
            {
            maxl=height[i] ;}
            maxLeft[i]=maxl;
            int curr=(size-i)-1;
            System.out.println(curr);
            if(height[curr]>maxR)
            {
                maxR=height[curr];
            }
            maxRight[curr]=maxR;
         }
        //  printArray(maxLeft);
        
         for(int i=0;i<size;i++)
         {
            int trapWater=Math.min(maxLeft[i],maxRight[i])-height[i];
            totalWater+=trapWater;
          }
        return totalWater;
 }
        


 public static double power(double x,int n,int i)
    {
        if(n == i)
        {
            return x;
        }
       return x*power(x, n, i+1);
    }




         
public static void main(String args[])
 {
        // int data[]={4,2,0,3,2,5};
        // int totalWater=trap(data);;
        // System.out.println(totalWater);
         System.out.println(power(2.00,10,1));
        
         
    }
 

}