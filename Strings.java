import java.util.*;
public class Strings{
    
    public static  void printLetters(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            System.out.print(str.charAt(i)+" ");
        }

    }
    public static boolean isPalindrome(String str)
    {
        int n=str.length();
        for(int i=0;i<n/2;i++)
        {
            if(str.charAt(i)!=str.charAt(n-1-i))
            { 
                return false;
            }
        }
        return true;

    }
public static float getShortestPath(String path)
{
    int x=0,y=0;
    for(int i=0;i<path.length();i++)
    {
        if(path.charAt(i)=='N')
        { y++;}
        else if(path.charAt(i)=='S')
        { y--;}
        else if(path.charAt(i)=='W')
        {     x--; }
        else if(path.charAt(i)=='E')
        {
            x++;
        }
    }
    return (float)Math.sqrt(x*x+y*y);
}

public static String getSubString(String str,int si,int ei)
{
    String subStr="";
    for(int i=si;i<ei;i++)
    {
        subStr+=str.charAt(i);
    }
    return subStr;
}
// here writing the function that convert the character of each letter to uppercase
public static String convertUpperCase(String str)
{
    StringBuilder sb=new StringBuilder("");
     sb.append((Character.toUpperCase(str.charAt(0))));
    for(int i=1;i<str.length(); i++ )
    {
        if((str.charAt(i)==' ') && (i<str.length()-1))
        {
            sb.append(str.charAt(i));
            i++;
            sb.append(Character.toUpperCase(str.charAt(i)));
       }
        else 
        {
            sb.append(str.charAt(i));
        }
    }
    return sb.toString();
}

public static String compressString(String str)
{
    // String tempStr=new String("");
    StringBuilder tempStr=new StringBuilder("");

    Integer count=new Integer(1);
    for(int i=0;i<str.length();i++)
    {
        char ch=str.charAt(i);
        while(i<str.length()-1 && ch==str.charAt(i+1) )
        {
            count++;
            i++;
        }
        tempStr.append(ch);
        if(count>1)
        {
        tempStr.append(count.toString());
        count=1;
        }
     }
     return tempStr.toString();

}

public static boolean isAnagrams(String str,String str2)
{
    if(str.length()!=str2.length())
    {
        return false;
    }
    boolean check=false;
    
    for(int i=0;i<str.length();i++)
    {
        for(int j=0;j<str2.length();j++)
        {
            if(str.charAt(i)==str2.charAt(j))
            {check=true;}
        }
        if(check=false)
        {return false;}}
        return true;}

    
 

    public static void main(String args[])
    {
        String s1="eat";
        String s2="tea";
        char[] s1Arr=s1.toCharArray();
        char[] s2Arr=s1.toCharArray();
        Arrays.sort(s1Arr);
        Arrays.sort(s2Arr);
        System.out.println(Arrays.equals(s1Arr,s2Arr));
    // String str="race";
    // String str2="car";

    // char[] s1Array=str.tocharArray();
    // char[] s2Array=str2.tocharArray();
    //  s1Array.sort();
    //  s2Array.sort();
    //  System.out.println(Arrays.equals(s1Array,s2Array));
    // System.out.println(isAnagrams(str,str2));
    // String s1=new String("GFG");
    // String s2=s1.intern();
    //  System.out.println(s2);
    //  System.out.println(s1.equals(2));


    //     int count=0;
    //     Scanner sc=new Scanner(System.in);
    //     String name=sc.nextLine();
    //  for(int i=0;i<name.length();i++)
    //  {if(name.charAt(i)=='a'||name.charAt(i)=='e'||name.charAt(i)=='i'||name.charAt(i)=='o'||name.charAt(i)=='u')
    //     { count++;  } 
    // }
    //  System.out.println(count);
    // String str="SharadaDidi";
    // String  str1="Apnacollege";
    // String str2="SharadaDidi";
    // System.out.println(str.equals(str1)+" "+str.equals(str2));
    // String str="ApnaCollege".replace("l","");
    // System.out.println(str);
 // System.out.println(name);
        // String product=new String("my name is bikal");
        // System.out.println("the length of the string"+product.length());
        // String firstName="bikal";
        // String lastName="Shrestha";
        // String fullName=firstName+"Siya"+lastName;
        //  printLetters(fullName);
        // boolean check=isPalindrome("racecar");
        // System.out.println(check);
        // String path="NNNNNNNNNNNNNNNN";
        // System.out.println("the shortest path is"+getShortestPath(path));1
        // String s1="Sarmila";
        // String s2="Sarmila";
        // String s3=new String("Sarmila");
        // if(s1.equals(s3))
        // {
        //     System.out.println("the both sreen are equal");
        // }
        // else 
        // {
        //     System.out.println("the both String are not equal");

        // }
        // String text="hellow World";
        // String subString=text.substring(3,5);
        // System.out.println(subString);
        // here printing largest string
        // String fruits[]={"banana","engineer","esominia","cherry","apple"};
        // String smallest=fruits[0];
        // for(int i=1;i<fruits.length;i++)
        // {
        //     if(smallest.compareTo(fruits[i])>0)
        //     {    
        //         smallest=fruits[i];
        //     }
        // }
        // System.out.println("the largest string is"+smallest);
        //using of the string builder function
    //     StringBuilder sb=new StringBuilder();

    //     for(char ch='a'; ch<='z'; ch++)
    //     {
    //         sb.append(ch);
    //     }
    //     System.out.println("the new string is"+sb.length());

//    String s="bikal shrestha sarmila nnn n o p   n";

//     String name=convertUpperCase(s);
//     System.out.println(name);
//    String name="aaabbbcc";
//     String res=compressString(name);
//     System.out.println(res);
  }

}