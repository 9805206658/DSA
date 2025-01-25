import java.util.*;


 class Solution {
    public int[] topKFrequent(int[] nums, int k) {

      // here creating hash map
        Map<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        
      //  list of array
        List<Integer>[] freq = new ArrayList[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        
      //   System.out.println(counter.keySet());
      //   for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
      //       int frequency = entry.getValue();
      //       freq[frequency].add(entry.getKey());
      //   }

   for(int key : counter.keySet()) 
    {
        freq[counter.get(key)].add(key);
    }
    
        
       System.out.println(freq.length);
       for(int i = 0; i<freq.length; i++)
       {
         System.out.println(freq[i]);

       }
        int[] res = new int[k];
        int idx = 0;
        for (int i = freq.length - 1; i >= 0; i--) {
            for (int num : freq[i]) {
                res[idx++] = num;
                if (idx == k) {
                    return res;
                }
            }
        }
        
        return new int[0];        
    }
}





public class Test
{   // bubble sort
    public static void bubbleSort(int arr[])
    {int idx = 0;
      while(idx < arr.length)
      { int num = arr[0];
        for(int i =1 ;i<arr.length-idx;i++)
        {  if(arr[i-1]> arr[i])
           {   int temp = arr[i-1];
               arr[i-1] = arr[i];
               arr[i] = temp;
            }
        }
        idx++;
      }
    }
    // selection sort
    public static void selectionSort(int arr[])
    {
       int idx = 0;
       while(idx < arr.length)
       { int s = idx;
         for(int i = idx; i< arr.length; i++)
         {if(arr[s]>arr[i])
            {  s = i; }}
        //  swapping the element
        int temp = arr[idx];
        arr[idx] = arr[s];
        arr[s] = temp;
        idx++;
       }
    }
    public static void insertionSort(int arr[])
    {
       for(int i = 0; i< arr.length; i++)
       {
        int curr = i;
        int temp = arr[i];
        int prev = i-1;
        while(prev >= 0 && arr[prev]>temp)
        {
            arr[prev+1] =  arr[prev];
            prev--;
        }
        arr[prev+1] = temp;
       }
    }
    // selection sort
    public static void countingSort(int arr[])
    {
    //    finding the largest element;
     int largest = Integer.MIN_VALUE;
     for(int i = 0; i < arr.length; i++)
     {
        if(arr[i] > largest)
        {largest = arr[i];
        }
     }
    //  creating the counting array
    int countArr[] = new int[largest+1];
    for(int i = 0; i<arr.length; i++)
     countArr[arr[i]]++;
    //  display the element 
     
     for(int j = 0; j<countArr.length; j++)
     {
        while(countArr[j]>0)
        {  System.out.println(j);
            countArr[j]--;
         }
    }
     }

      public static void sortList(List<Integer> list)
       {
        int size= list.size();
        int arr[] = new int[list.size()];
         for(int i= 0; i<list.size();i++)
         {
            arr[i] = list.get(i);
         }
         Arrays.sort(arr);
         list.clear();
         for(int i= 0; i<size;i++)
         {
            list.add(arr[i]);
         }
       }
    

    public static void quickSort(int nums[],int si,int ei)
    {
       if(si == ei)
       { return ;
       }
       int pivot = partion(nums,si,ei);
       quickSort(nums , si , pivot);
       quickSort(nums , pivot+1 , ei);

    }
    public static int partion(int nums[] , int si , int ei)
    {
      int i = si-1;
      for(int j = 0; j < ei; j++)
      {
         if(nums[j] < nums[ei])
         {  i++;
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
         }
     }  
     i++;
     int temp = nums[i];
     nums[i] = nums[ei];
     nums[ei] = temp;
     return i;
 }








    public static void main(String args[])
    {
      //   List<Integer> list = new ArrayList<>();
      //   int arr[] = {1,6,5,2};
      //   for(int i = 0; i<arr.length; i++)
      //   { list.add(arr[i]);
      //   }
      //   sortList(list);
      //   System.out.println(list);

      // List<List<Integer>> result = new ArrayList<>();
      // List<Integer> list = new ArrayList<>();
      // List<Integer> list2 = new ArrayList<>();
      // list.add(1);
      // list.add(2);
      // list.add(3);
      // list2.add(4);
      // list2.add(2);
      // list2.add(3);
      // if(!result.contains(list))
      // result.add(list);
      // if(!result.contains(list))
      // result.add(list2);
      // System.out.println(result);
      
      // int arr[] = {1,5,2,3,6,7};
      // quickSort(arr , 0 , arr.length-1);
      // for(int i = 0; i < arr.length; i++)
      // {
      //    System.out.println(arr[i]);
      // }

// int nums[] = {1,1,1,2,2,3};
// int k = 2;
// Solution s = new Solution();
// int n[] = s.topKFrequent(nums,2);
// for(int i = 0; i < n.length; i++)
// {
//    System.out.println(n[i]);
// }

System.out.println((0+3)/2);

    

   }
}