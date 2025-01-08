import java.util.*;
public class Part1
{
    public static void Swapping(int  idx1,int idx2,ArrayList<Integer> list)
    {
        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
     }

    public static void main(String args[])
    {
        ArrayList<Integer> list =new ArrayList();
        list.add(1);
        list.add(15);
        list.add(55);
        list.add(77);
        list.remove(0);
        System.out.println(list.contains(5*5));
         System.out.println("the number before swappings");
        for(int i = 0; i<list.size() ; i++)
        {
            System.out.println(list.get(i));
        }
        Swapping(0,1,list);
        System.out.println("the number after swappings");
        for(int i = 0; i<list.size() ; i++)
        {
            System.out.println(list.get(i));
        }
    }

        
        // print the reverse arraylist
        // for(int k = list.size()-1; k > 0; k--)
        // {
        //     System.out.println(list.get(k));
        // }
        // finding maximum value on the arraylist
    //     int max = Integer.MIN_VALUE;
    //     for(int j=0; j < list.size(); j++)
    //     {
    //       if(max<list.get(j))
    //       {
    //         max=list.get(j);
    //       }
    //     }
    //     System.out.println("the maximunm vlaue in the arraylist are"+max);
    // }

}