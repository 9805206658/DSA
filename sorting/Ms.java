public class Ms
{
    public static void merge(int arr[],int si,int mid,int ei)
    {

        System.out.println("starting index:"+si);
        System.out.println("mid:"+mid);
        System.out.println("ending index:"+ei);
        System.out.println();
        int i = si;
        int j = mid+1;
        // creating temp array
        int temp [] = new int[ei-si+1];
        int k = 0;
        while(i <= mid &&  j <= ei)
        { if(arr[i] < arr[j])
           { temp[k] = arr[i];
             i++;
           }
           else 
           { temp[k] = arr[j];
             j++;
           }
           k++;
        }
        // adding the remainig the element
        while(i < mid+1)
        { temp[k] = arr[i];
            k++;
            i++;
        }
        while(j <= ei)
        { temp[k] =  arr[j];
            k++;
            j++;
        }
        for( i = si,k = 0;k < temp.length; i++,k++)
        { arr[i] = temp[k]; } 

    }
    public static void mergeSort(int arr[],int si,int ei)
    {
        if(si >=  ei)
        { return ;}
        int mid = (si+ei)/2;
        mergeSort(arr,si,mid);
        mergeSort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }
    public static void main(String args[])
    {
        int arr1[] ={2,0,2,1,1,0};
       mergeSort(arr1,0,arr1.length-1);
       for(int i = 0; i < arr1.length; i++)
       {
        System.out.println(arr1[i]);
       }
         
    }
}