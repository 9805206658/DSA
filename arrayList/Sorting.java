import java.util.*;
public class Sorting
{
    // brute force approach 
    // public static int waterContainer(ArrayList<Integer>list)
    // { int maxWater=0;
    //     for(int i=0; i < list.size(); i++)
    //     {
    //         for(int j=i+1; j < list.size(); j++)
    //         {   int height=Math.min(list.get(i),list.get(j));
    //             int width=j-i;
    //             int area=width * height;
    //             maxWater=Math.max(maxWater,area);
    //          }
    //      }
    //     return maxWater;
    // }
    // 2 pointer approach
    public static boolean pairSum2(ArrayList<Integer>list,int target)
    {// here finding out starting and ending position on rotating and sorted array;
      int lp=0,rp=0;
      int n = list.size();
      for(int i = 0; i < list.size(); i++)
      {if(list.get(i) > list.get(i+1))
         {  lp = i+1;
            rp = i;
            break;
         }
      }
         while(lp != rp)
         {
            if(list.get(lp)+list.get(rp) == target)
            { return true; }
            else if(list.get(lp)+list.get(rp) < target)
            { lp = (lp+1) % n; }
            else 
            {rp=(n+rp-1) % n;  }
          }
          return false;
      }


    public static int waterContainer(ArrayList<Integer>list)
    {
        int lp=0;
        int maxWater=0;
        int rp=list.size()-1;
        while(lp<rp)
        {
        int height=Math.min(list.get(lp),list.get(rp));
        int width=rp-lp;
        int area=height * width;
         maxWater=Math.max(maxWater,area);
         if(list.get(lp)<list.get(rp))
         { lp++;}
         else 
         {  rp--; }
        }
         return maxWater;
        
    }
    public static boolean findPairs(ArrayList<Integer>list,int target)
    {
      int left=0;
      int right=list.size()-1;
      while(left<right)
      {
       int sum=list.get(left)+list.get(right);
       if(sum==target)
       { return true;}
       if(sum > target) { right--;}
       else  { left++;}
        
      }
      return false;
    }



       // for(int i=0; i<list.size(); i++)
      // {
      //    for(int j=i+1; i<list.size(); j++)
      //    {  if(target == (list.get(i)+list.get(j)))
      //       {return true; } 
      //    }
      // }
 public static void main(String args[])
    {
        ArrayList <Integer> list =new ArrayList<>();
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(pairSum2(list,16));
      //   System.out.println(waterContainer(list));
        // ArrayList<ArrayList<Integer>> mailnList =new ArrayList<>();
        //  ArrayList<Integer> list1= new ArrayList<>();
        //  ArrayList<Integer> list2= new ArrayList<>();
        //  ArrayList<Integer> list3= new ArrayList<>();
        // //  list1.add(2); list1.add(3); list1.add(4);
        // //  list2.add(4); list2.add(5); list2.add(10);
        //  mainList.add(list1);
        //  mainList.add(list2);
        //  mainList.add(list3);
     
         

    //      for(int i=1; i <= 10; i++)
    //      {
    //         list1.add(i*1);
    //         list2.add(i*2);
    //         list3.add(i*3);
    //      };
    //          System.out.println(mainList);

    //    for(int i = 0; i < mainList.size(); i++)
    //      {  ArrayList<Integer>currList= mainList.get(i);
    //         for(int j=0 ; j < currList.size(); j++)
    //         { System.out.print(currList.get(j)+" "); }
    //         System.out.println();
    //      }


    //      here putting the multipication table in the mainArraylist 


    //     ArrayList <Integer> list= new ArrayList<>();
    //     list.add(1);
    //     list.add(10);
    //     list.add(11);
    //     list.add(5);
    //     list.add(20);
    //     Collections.sort(list);
    //     Collections.sort(list,Collections.reverseOrder());
    //     for(int i = 0; i < list.size(); i++)
    //     {System.out.println(list.get(i)); }

     }
}

