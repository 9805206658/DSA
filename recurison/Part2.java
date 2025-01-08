public class Part2
{
    // Tilling problem 
    public static int findNumber(int n)
    {
        if(n==0 || n==1)
        {return 1; }
        int fv=findNumber(n-1);
        int fn=findNumber(n-2);
        return fv+fn;
    }
    // remove duplicate from string 
    public static void removeDuplicate(String currStr,int currIndex, boolean map[],StringBuilder uniqueStr)
    {
        if(currIndex==currStr.length())
        {
         System.out.println(uniqueStr);
         return ;
         }
        char currChar=currStr.charAt(currIndex);
        System.out.println(currChar-'a');
        if(map[currChar-'a']==true)
        {
          removeDuplicate(currStr,currIndex+1,map,uniqueStr);
        }
        else 
        {
           map[currChar-'a']=true;
           uniqueStr.append(currChar);
           removeDuplicate(currStr,currIndex+1,map,uniqueStr);
        }
    }
    public static int friendsPairing(int n)
    {
       if(n==1 || n==2)
       {
        return n;
       }
        int fn1=friendsPairing(n-1);
        int fn2=friendsPairing(n-2);
        int totalPair=fn1+fn1*fn2;
        return totalPair;
}
public static void printBinaryString(int n,int bac,String str)
{
   if(n == 0)
    { 
    System.out.println(str);
    return ;
     }
    printBinaryString(n-1,0,str+"0");
    if(bac == 1)
    { printBinaryString(n-1,1,str+'1');
    }
}
public static void printOccurances(int arry[],int n, int key)
{
   if(n==arry.length)
    {return ; }
     if(arry[n]==key)
     {System.out.println(n); }
    printOccurances(arry,n+1,key);
}

 public static void printString(int n,String str,String numArry[])
 {if(n==0)
    { System.out.println(str);
        return; }
    int val=n%10;
    str=str.concat(numArry[val]+" ");
    printString(n/10,str,numArry);

}
public static int findLength(String str)
{
    if(str.length()==0)
    {return 0; }
   return findLength(str.substring(1))+1;
}
public static int countSubstrs(String str,int i,int j,int n )
{
    if(n == 1)
    { return 1;}
    if(n<=1)
    {return 0;}
    int res=countSubstrs(str,i+1,j,n-1)+countSubstrs(str,i,j-1,n-1)-countSubstrs(str,i+1,j-1,n-2);
    if( str.charAt(i)==str.charAt(j))
    { res++; }
    return res;
}
static int count=1;
public static void towerOfHanoi(int n,int A,int C,int B)
{
    if(n==1)
    { 
        System.out.println(count+":"+"the disk"+n+" "+"move"+" "+A+" to "+ C);
        count++;
         return ;
 }
    towerOfHanoi(n-1,A,B,C);
   System.out.println(count+":"+"the disk"+n+" "+"move"+" "+A+" to "+ C);
   count++;
   towerOfHanoi(n-1,B,C,A);
}

public static int countSub(String str,int si,int ei)
{
    if(si>ei)
    {
        return 0;
    }
    int removedFirstChar=countSub(str,si+1,ei);
    int removedLastChar=countSub(str,si,ei-1);
    int removedBoth=countSub(str,si+1,ei-1);
    int ans=removedFirstChar+removedLastChar-removedBoth;
    if(str.charAt(si)==str.charAt(ei))
    {
        ans++;
    }
    return ans;
}
public static int printPalindrome(int n)
{
    if(n==0 || n==1)
    { return n;}
    int firstNum=printPalindrome(n-1);
    int seconNum=printPalindrome(n-2);
    int ans=firstNum+seconNum;
     return  ans;

}

public static int naturalSum(int n)
{

if(n==1)
{return 1;}
int sum= naturalSum(n-1);
return n+sum;


}
    public static void main(String args[])
    {
    //     int arry[]={3,2,4,5,6,2,7,2,2};
    //    printOccurances(arry,0,2);
    //    String numArry[]={"zero","one","two","three","four","five","six","seven","eight","nine"};
    //    printString(2019,"",numArry);
    // String str="bikal shrestha";
    // System.out.println(str.substring(1));
    // String str="abcab";
    // int n=str.length();
    // System.out.println(countSubstrs(str,0,n-1,n));
    //  towerOfHanoi(3,10,30,20);
    String str="abcab";
    // System.out.println(countSub(str,0,str.length()-1));
    // printName(20);
    System.out.println(naturalSum(5));



}
    

}