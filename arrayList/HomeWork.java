import java.util.*;
public class HomeWork
{
    public static boolean isMonotonic(ArrayList<Integer>list)
    { 
        boolean check = true;
        // checking for in ascending order
        for(int i=0; i < list.size()-1; i++)
        { if(!(list.get(i) <= list.get(i+1)))
            { check = false;}
        }
        // checking for in decending order
        if(check == false)
        { check=true;
        for(int i=0; i < list.size()-1; i++)
        {  if(!(list.get(i) >= list.get(i+1)))
            { check = false;}
         }
        }
        return check;
    }


// brute force approach
    // public static ArrayList<Integer> lonelyNumber(ArrayList<Integer>list)
    // {
    //   ArrayList<Integer>list1 = new ArrayList<>();
    //   for(int i=0; i < list.size(); i++)
    //    {
    //     boolean check=true;
    //     for(int j=0; j < list.size(); j++)
    //     {
    //         if(i != j)
    //         {
    //         if((list.get(i)+1 == list.get(j)) || (list.get(i)-1 == list.get(j)) || (list.get(i) == list.get(j)))
    //         { check=false;} }
    //    }
    //     if(check == true)
    //      {list1.add(list.get(i)); }
    //    }
    //    return list1;

    // }

    public static int mostFrequently(ArrayList<Integer>list,int key)
    {   
        int []result= new int[1000];
        for(int i = 0; i<list.size()-1; i++)
        {if(list.get(i) == key)
            {   System.out.println(list.get(i+1)-1);
                result[list.get(i+1)-1]++;
            }
        }contain water systems
        int max = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i<result.length; i++)
        {
            if(max < result[i])
            {   max = result[i];
                ans = i+1;
            }
        }
        return ans;
    }
    // alternative soloution of the lonely number
    public static ArrayList<Integer>findLonelyNumber(ArrayList<Integer>list)
    {
        // here making hashmap
        // 10,6,5,8
        ArrayList<Integer> lonelyNumber=new ArrayList<>();
        HashMap<Integer,Integer> hp= new HashMap<>();
        for(int i=0; i < list.size(); i++)
        {
            if(hp.containsKey(list.get(i)) == false)
            { hp.put(list.get(i),1); }
            else 
            { hp.put(list.get(i),hp.get(list.get(i))+1);}
        }
        // here extractiing 
        for(int i=0; i < list.size()-1; i++)
        { if(hp.containsKey(list.get(i+1))==false && hp.containsKey(list.get(i-1))== false && hp.get(list.get(i)) == 1)
            { lonelyNumber.add(list.get(i)); }
         }
         return lonelyNumber;
    }


    


    public static void main(String args[])
    {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);
       System.out.println(findLonelyNumber(list));

        // System.out.println(mostFrequently(list,2));
    }
}