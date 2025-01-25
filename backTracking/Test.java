import java.util.*;

public List<List<Integer>> subsets(int[] nums) {
  List<List<Integer>> result = new ArrayList<>();
  List<Integer> numList = new ArrayList<>();
  
  result.add(new ArrayList<>()); // empty set
  subsets(0, nums, numList, result);
  return result;
}

  
private void subsets(int offset, int[] nums, List<Integer> numList, List<List<Integer>> result) {
  if (offset >= nums.length) {
    return;
  }
  int val = nums[offset];
  // pick
  numList.add(val);
  subsets(offset + 1, nums, numList, result);
  // add to result
  result.add(new ArrayList<>(numList));
  // not pick
  numList.remove(numList.size() - 1);
  subsets(offset + 1, nums, numList, result);
}











public class Test
{
    public static void printBinary(int arr[],List<Integer>temp,List<List<Integer>> result)
    {
        if(temp.size() == 2)
        {  result.add(new ArrayList<>(temp));
            return;
        }
        for(int i =0;i<arr.length; i++)
        {    temp.add(arr[i]);
             printBinary(arr,temp,result);
             temp.remove(temp.size()-1);
          
        }
    }
    public static int decimal(List<Integer> l)
    {
        int dec = 0;
        int pow = l.size()-1;
        for(int i = 0;i<l.size(); i++)
        {
            dec += l.get(i)*(int)Math.pow(2,pow);
            pow --;

        }
        return dec;

    }
    public static void sortList(List<Integer> list)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size = list.size();
       for(int i = 0;i<size; i++)
       {
         pq.add(list.remove(list.size()-1));
       }
       while(!pq.isEmpty())
       {
        list.add(pq.remove());
       }


    }
    public static void main(String args[])
    {
    List<Integer> list = new ArrayList<Integer>();
    list.add(2);
    list.add(5);
    list.add(1);
    list.add(3);
    sortList(list);
    System.out.println(list);
       
        
    }
}