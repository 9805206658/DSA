import java.util.*;
public class IterationHashMap
{
    public static void main(String args[])
    {
        HashMap<String,Integer> hm = new HashMap<>();
        HashMap<String,Integer> hm1 = new HashMap<>();
        hm.put("apple",50);
        hm.put("banana",100);
        hm.put("orange",200);
        String str="";
        Set<String> keys= hm.keySet();
        int max = Integer.MIN_VALUE;
        for(String key:keys)
        {
          if(max < hm.get(key))
          {
            max = hm.get(key);
            str= key;
          }
          System.out.println("key: "+key+" "+"value"+" "+hm.get(key));

        }
       System.out.println(max);
       System.out.println(str);
    }
}