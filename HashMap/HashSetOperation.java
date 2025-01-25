import java.util.HashSet;
import java.util.Iterator;
import java.util.*;
public class HashSetOperation
{
    // union and interesection of two array
    public static void unionAndIntersection (int arr1[],int arr2[])
    {   HashSet<Integer> hs= new HashSet<>();
        for(int num : arr1)
        {   hs.add(num); }
        for(int num: arr2)
        {   hs.add(num);}
        System.out.println("union"+hs.size());
        hs.clear();
        for(int num:arr1)
        {
            hs.add(num);
        }
        int count = 0;
        for(int num: arr2)
        { if(hs.contains(num))
            {
                hs.remove(num);
               count++;
            }
        }
        System.out.println("the union is:"+count);


    }
     public static void main(String args[])
    {
        // HashSet<String> country = new HashSet();
        // country.add("Nepal");
        // country.add("india");
        // country.add("china");
        // country.add("bhutan");
        // // Iterator it = hs.iterator();
        // Iterator cont = country.iterator();
        // while(cont.hasNext())
        // {System.out.println(cont.next());}
        // LinkedHashSet<String> country = new LinkedHashSet<>();
        // country.add("Npeal");
        // country.add("China");
        // country.add("Bhutan");
        // country.add("German");
        // System.out.println(country);
        // TreeSet<String> ts  = new TreeSet<>();
        // ts.add("nepal");
        // ts.add("china");
        // ts.add("german");
        // ts.add("bhutan");
        // ts.remove("china");
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        unionAndIntersection(arr1,arr2);    
    }
}