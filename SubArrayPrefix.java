public class SubArrayPrefix
{
    public static void SubArraySum(int nums[])
    {
        //here getting prefix sum Arrya
        int max=Integer.MIN_VALUE;
        int prefix[]=new int[5];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++)
        { prefix[i]=prefix[i-1]+nums[i];}
        for(int i=0;i<nums.length;i++)
        {
            int sum=0;
            int start=i;
            for(int j=i+1;j<nums.length;j++)
            {   int  end=j;
                sum=(start==0)?prefix[end]:prefix[end]-prefix[start-1];
                System.out.println(sum);  
            }
            if(sum>max)
            {max=sum; }
          }
          System.out.println("the maximum value is "+max);
 }


 public static int kedanAlgo(int nums[])
 {
    int currSum=0;
    
    int max=Integer.MIN_VALUE;
    boolean isNegative=true;
    // here writing case for the negative value
    for(int i=0;i<nums.length;i++)
    {if(nums[i]>0)
        { isNegative=false;
            break; } 
    }
    if(isNegative==true)
     { max=0;
        for(int i=0;i<nums.length;i++)
        {
            max+=nums[i];
        }
        System.out.print("the max value"+max);
        return 0;
     }

    for(int i=0;i<nums.length;i++)
    {
        currSum+=nums[i];
        // System.out.println(currSum);
        if(currSum<0)
        {currSum=0; }
       if(currSum>max)
        {  max=currSum;
           System.out.println(currSum);
        }
    }System.out.println("the max value is "+max);
    return 0;
}

public static void trappingRainwater(int nums[])
{
    int size=nums.length;
    int waterLevel=0;
    int totalWaterLevel=0;
    int leftMax[]=new int[size];
    int rightMax[]=new int[size];
    leftMax[0]=nums[0];
    rightMax[size-1]=nums[size-1];
    for(int i=1; i<size;i++)
    {leftMax[i]=Math.max(leftMax[i-1],nums[i]);}
    
    for(int i=size-2;i>=0;i--)
    { rightMax[i]=Math.max(rightMax[i+1],nums[i]);}
 // calculating the water level
 for(int i=0;i<size;i++)
 {
    waterLevel=Math.min(leftMax[i],rightMax[i])-nums[i];
    totalWaterLevel+=waterLevel;
}

}


public static void findProfit(int nums[])
{
    int buy=Integer.MAX_VALUE;
   int maxProfit=0;
    for(int i=0;i<nums.length;i++ )
    {
        if(buy<nums[i])
        {
            int profit=nums[i]-buy;
            maxProfit=Math.max(profit,maxProfit);
        }
       else
       { buy=nums[i]; }

}
        System.out.println("the maximum profit is"+maxProfit);
}
public static void main(String args[])
    {
        int nums[]={7,1,5,3,6,4};
        findProfit(nums);
   
     }
    
}
