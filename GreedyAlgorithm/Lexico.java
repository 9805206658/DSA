import java.util.*;
public class Lexico
{
   
   public static void lexico(int sum,int count)
   {
    char[] str = new char[count];
    Arrays.fill(str,'a');
    for(int i=str.length-1; i >= 0; i--)
    { sum = sum-i;
        if(sum>0)
        { if(sum >= 26)
            { str[i] = 'z';
              sum = sum-26;
            }
            else 
            {  str[i] = (char)(sum+97-1);
                sum -= str[i]-'a'+1;
            }
         }
        else 
        { break; }
        sum = sum+i;
        // here check the condition
    } 
    System.out.println("the lexico value:");
    for(int i=0; i<str.length; i++)
    {  System.out.println(str[i]); }
  }
   public static void main(String args[])
    {   // int sum = 42;
        // int count =5;
        // lexico(sum,count);
      ArrayList<ArrayList<Integer>> al = new ArrayList<>();
      ArrayList<Integer> al1 = new ArrayList<>();
      al1.add(1);
      al1.add(2);
      al1.add(3);
      al.add(al1);
      System.out.println(); 
        
    }
}