public class Assignment1
{
    // make the function 
    public static boolean isElementTwice(int data[])
    {
        int size=data.length;
        for(int i=0;i<size; i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i==j)
                {
                    continue;
                }
                if(data[i]==data[j])
                {
                    return true;
                }
            }
        
        }
        return false;

    }
    public static void isTarget(int data[],int index)
    {
        int rotate=0;
        int n=data.length;
       int swap[]=new int[0];
        for(int i=index; i<data.length;i++)
        {
            swap[rotate]=data[rotate];
            data[rotate]=data[i];
            rotate++;
          
            
        }
        
          int swaping=0;
        for(int i=((n-1)-index)+1; i<data.length;i++)
        {
             if(i>swap.length-1)
            {
               data[i]=swap[i]; 
            }
            data[i]=swap[swaping];
            swaping++;
        }
        for(int i=0;i<data.length;i++)
        {
           
            System.out.println(data[i]);
        }
    }


    public static void main(String args[])
    {
        int nums[]={0,1,2,4,5,6,7};
        isTarget(nums,5);
        // System.out.println(isTarget(nums));

    }
}
