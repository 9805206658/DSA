import java.util.*;
public class Part1
{
   static class Stack
    {
        ArrayList<Integer> list = new ArrayList<>();
        // checking the stack is empty or not
        public boolean isEmpty()
        {  
            return list.size()==0;
        }
        public void push(int data)
         {   list.add(data); }

        public int pop()
        { int data = list.get(list.size()-1);
          if(isEmpty()== true)
          {  return -1; }
           list.remove(list.size()-1);
          return data;
        }
        public int peek()
        { if(isEmpty()== true)
          { return -1;}
           int data = list.get(list.size()-1);
           return data;
        }
    }
    
    public static void main(String args[])
    {
        Stack s =new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        // here printing the statck element;
        while(!s.isEmpty())
        { System.out.println(s.pop()); }
        System.out.println(s.peek());
    }
}



public int[] nextGreaterElementBrute(int[] nums1, int[] nums2) {
	int[] ans = new int[nums1.length];

	for(int i = 0; i < nums1.length; i++) {
		int greaterIdx = -1, j = nums2.length - 1;
		while(j >= 0 && nums2[j] != nums1[i]) {
			if(nums2[j] > nums1[i]){
				greaterIdx = nums2[j];
			}
			j--;
		}
		ans[i] = greaterIdx;
	}

	return ans;
}