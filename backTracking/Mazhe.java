import java.util.*;
public class Mazhe
{
  
   final static char[][] l= 
        { {},{},{'a','b','c'},{'d','e','f'},
            {'g','h','i'},{'j','k','l'},{'m','n','o'},
            {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
        };

//   here defining the print soloution
public static void printSoloution(int sol[][])
{
    for(int i=0; i<sol.length; i++)
    { for(int j=0; j<sol.length; j++)
        {  System.out.print(" "+sol[i][j]+" ");}
        System.out.println();
    }
}
public static boolean isSafe(int mazhe[][],int x, int y)
{  if(x >= 0 && y >= 0 &&  x<mazhe.length-1  &&  y <mazhe.length-1  &&  mazhe[x][y]==1 )
    {
          System.out.println("x:"+ x);
          System.out.println("y:"+ y);
        return true;
    }
    return false;
}
public static boolean solveMaghe(int mazhe[][])
{
    int N = mazhe.length;
    int sol[][] = new int[N][N];
    if(solveMazheUtil(mazhe,0,0,sol)==false)
    {   System.out.println("doesn't exist the soloution");
        return false; 
    }
    printSoloution(sol);
    return true;
}

public static boolean solveMazheUtil(int mazhe[][],int x,int y,int sol[][])
{  if(x == sol.length-1  || y == sol.length-1 && mazhe[x][y] == 1)
    { sol[x][y]=1;
      return true;
    }
    // check mazhe is vlaid or not
    if(isSafe(mazhe,x,y) == true)
    {  if(sol[x][y] == 1)
       return false;
       sol[x][y] =1;
       if( solveMazheUtil(mazhe,x+1,y,sol))
       { return true;}
       if( solveMazheUtil(mazhe,x,y+1,sol))
       {return true; }
    } 
    return false;
}


public static void letterCombination(String D)
{
    int len=D.length();
    if(len == 0)
    {
        System.out.println("");
        return ;
    }
    bfs(0,len, new StringBuilder(), D);
    
}
public static void bfs(int pos,int len,StringBuilder sb,String D)
{
    if(pos == len)
    { 
    System.out.println(sb.toString());}
    else 
    {  char[] letters=l[Character.getNumericValue(D.charAt(pos))];
        for(int i=0; i < letters.length; i++)
        {bfs(pos+1,len,new StringBuilder(sb).append(letters[i]),D);}
    }
}


 

    public static void main(String args[])
    {
        int mazhe[][] = {
        {1,0,0,0},
        {1,1,0,1},
        {0,1,0,0},
        {1,1,1,1} };
        solveMaghe(mazhe);
    // here defining the character
    // letterCombination("12");
    //     int n=5;
    // fibo(50);
       
    }

}