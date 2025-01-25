public class HeapSort
{
    public static void heapify(int arr[],int idx,int size)
    {
        int left = 2*idx+1;
        int right = 2*idx+2;
        int curr = idx;
        if(left < size && arr[left] > arr[curr])
        { curr = left;}
        if(right < size && arr[right] > arr[curr])
         { curr = right; }
        if(curr != idx)
        { // swapping the value
            int temp = arr[idx];
            arr[idx] = arr[curr];
            arr[curr] = temp;
            heapify(arr,curr,size);
        }

    }
    public static void heapSort(int arr[])
    {    // build the max heap;
        int n = arr.length;
        for(int i = n/2; i>= 0; i-- )
        {
            heapify(arr,i,n);
        }
        // push last element in last;
        for(int i = n-1; i>0; i--)
        {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapify(arr,0,i);
        }

    }
    public static void main(String args[])
    {
       int arr[] = {1,2,4,5,3};
       heapSort(arr);
       for(int i = 0;i<arr.length; i++)
       {
        System.out.println(arr[i]);
       }
    }
}