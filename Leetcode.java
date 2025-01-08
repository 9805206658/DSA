public class Leetcode 
{
    public static int[] productExceptSelf(int nums[])
    {
        int n=nums.length;
        int results[]=new int[n];
        int prefix[]=new int[n];
        int suffix[]=new int[n];
        prefix[0]=nums[0];
        suffix[n-1]=nums[n-1];
        
        for(int i=1;i<n; i++)
        {
            prefix[i]=prefix[i-1]*nums[i];
        }

// here displaying prefix value


        // for suffix
        for(int i=n-2; i>=0;i--)
        { 
           
            suffix[i]=suffix[i+1]*nums[i];
        }
            for(int i=1;i<n-1;i++)
        {
            results[i]=prefix[i-1]*suffix[i+1];
        }
        results[0]=suffix[1];
        results[n-1]=prefix[n-2];
        return results;

 }
    public static void main(String args[])
    {
        int sample[]={1,2,3,4};
        int results[]=productExceptSelf(sample);
        System.out.println();
        for(int i=0;i<sample.length;i++)
        {
            System.out.print(results[i]);
        }
        System.out.println();
     }
}