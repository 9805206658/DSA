import java.util.*;
public class PracticeQuestion
{
    public static void majorityElement(int arr[],int context)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
       for(int i = 0; i<arr.length; i++)
       {hm.put(arr[i],hm.getOrDefault(arr[i],0)+1); };
      for(int key:hm.keySet())
      {  if(hm.get(key)>(arr.length/context))
        {
            System.out.println(key);
        }
      }
    }
    // public static boolean checkAnagram(String str1,String str2)
    // {
    //     if(s.length() != str2.length())
    //     {
    //         return false;
    //     }
    //    HashMap<Character,Integer> hm = new HashMap<>();
    //    for(int i = 0;i<str1.length(); i++)
    //    {
    //     hm.put(str1.charAt(i),hm.getOrDefault(str1.charAt(i),0)+1);
    //    }
    //    char arr[] = str2.toCharArray();
    //    for(char ch:arr)
    //    {
    //      if(hm.containsKey(ch)!= null)
    //      { 
    //        if(hm.get(ch)==1)
    //        {
    //         hm.remove(ch);
    //        }
    //        else{
    //          hm.put(ch,hm.get(ch)-1);

    //        }
    //      }
    //      else 
    //      {return false; }
    //     }
    //     System.out.println(hm);
    //   return hm.isEmpty();
    // }
    public static String getStartPoint(HashMap<String,String>hm)
    {
      HashMap<String,String> revMap = new HashMap<String,String>();
      for(String key:hm.keySet())
      {revMap.put(hm.get(key),key);}

      for(String key:hm.keySet())
      {if(!revMap.containsKey(key))
        { return key;}
      }
      return null;

    }
    // largest subArray with sum  0
    public static void largestSubArray(int arr[])
    {
      HashMap<Integer,Integer> hm = new HashMap<>();
      int sum = 0;
      int len = 0;
      for(int i =0; i<arr.length; i++)
      {
        sum += arr[i];
        if(hm.containsKey(sum))
        { len = i - hm.get(sum); }
        else 
        {
          hm.put(sum,i);
        }
       }
       System.out.println("largest subArray size"+ len);
    }
    // sub array sum equal to  k
    public static void subArraySum(int arr[] , int k)
    {
      int sum = 0;
      int len = 0;
      //  sum +  count
      HashMap<Integer,Integer> hm = new HashMap<>();
      hm.put(0,1);
      for(int i = 0 ; i<arr.length; i++)
      {
        sum += arr[i];
        System.out.println(sum);
        if(hm.containsKey(sum-k))
        { len += hm.get(sum-k);}
        hm.put(sum,hm.getOrDefault(sum,0)+1);
      }
      System.out.println("the length:"+len);

    }



    public static void main(String args[])
    {
    //   String str1= "care";
    //   String str2= "race";
    //  System.out.println(checkAnagram(str1,str2));
  //   HashMap<String,String> hm = new HashMap<>();
  //   hm.put("chennai","bengaluru");
  //   hm.put("mumbai","delhi");
  //   hm.put("goa","chennai");
  //   hm.put("delhi","goa");
  //   String start = getStartPoint(hm);
  //   System.out.print(start);
  //   for(String key:hm.keySet())
  //   {
  //     System.out.print("->"+hm.get(start));
  //     start= hm.get(start);
  //   }
  //  }
  // int arr[] = {15,-2,2,-8,1,7,10};
  // largestSubArray(arr);

  int arr[] = {10,2,-2,-20,10};
  subArraySum(arr,-10);
    }

}