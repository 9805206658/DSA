import java.util.*;
public class BackTrackingOne
{
    public static void printArry(int arr[])
    {   for(int i=0; i < arr.length; i++)
        {
        System.out.print(arr[i]);
        }
        System.out.println();
    }
    public static void changeArr(int arr[],int i, int val)
    { if(i == arr.length)
        {
            printArry(arr);
            return ;
        }
        arr[i]=val;
        changeArr(arr,i+1,val+1);
        // here writing the backTracking program
        arr[i]=arr[i]-2;
    }
    public static void subChar(String str,int i,String ans)
    {
        if(i==str.length())
        {
            if(ans.length()==0)
            {
                System.out.println("null");
            }
            else 
            {
                System.out.println(ans);
            }
            return ;
        }
        subChar(str ,i+1, ans+str.charAt(i));
        subChar(str, i+1, ans);
  }

  public static void findPermutation(String str, String ans)
  {
    if(str.length() == 0)
    {   System.out.println(ans);}
    for(int i=0; i<str.length(); i++)
    {    System.out.println("the vlaue of "+i);
        char curr=str.charAt(i);
        // System.out.println(curr);
        String newStr=str.substring(0,i) + str.substring(i+1);
        findPermutation(newStr,ans+curr);
    }

  }
//   here making the board for printing 
 public static void printBoard(char board[][])
 {
    System.out.println("-------chessBoard--------");
    for(int i=0; i<board.length; i++)
    { for(int j=0; j<board.length; j++)
        { System.out.print(board[i][j]+" ");}
        System.out.println();
    }
 }

 public static void printBoardb(int board[][])
 {
    System.out.println("-------chessBoard--------");
    for(int i=0; i<board.length; i++)
    { for(int j=0; j<board.length; j++)
        { System.out.print(board[i]+" ");}
        System.out.println();
    }
 }
public static boolean isSafe(char board[][],int row,int col)
{
    // vertical up
    for(int i=row; i>=0; i--)
    {if(board[i][col] == 'Q')
        { return false; }
    }
    // diag right up
    for(int i=row-1,j=col+1;  i>=0 && j<board.length;  i--,j++)
    {if(board[i][j] == 'Q')
        {return false;}
    }
    // diag left up
     for(int i=row-1,j=col-1;  i >= 0 && j >= 0;  i--,j--)
    {if(board[i][j] == 'Q')
        {return false;}
    }
    return true;
}
static int count=0;
public static void nQueens(char board[][],int row)
{
  if(row == board.length)
     { 
        // System.out.println("enter");
    printBoard(board);
     return ;
     }
    for(int i=0; i<board.length; i++)
    { 
        System.out.println("the row:"+row);
        System.out.println("the i:"+i);
      if(isSafe(board,row,i))
        { 
         board[row][i] = 'Q';
         printBoard(board);
         nQueens(board,row+1);
         board[row][i] = 'x';
        }
    }

}
// making factorial calculation function
public static int fact(int n)
{
    if(n==1)
    {return 1;}
    return n*fact(n-1);
}
public static int gridWays(int x,int y,int row,int col)
{
    if(x==row-1 && y==col-1)
    { return 1;}
    if(y == row || x == col)
    { return 0;}
    int left=gridWays(x+1,y,row,col);
    int right=gridWays(x,y+1,row,col);
    int totalWays=left+right;
   return totalWays;
}
// here defining the isSafers function
public static boolean isSafers(int board[][],int row, int col, int digit)
{ // here checking the columns
    for(int j = 0; j < board.length; j++)
        {   if(board[row][j] == digit)
            { return false;}
        }
    // here checking on the  row
    for(int i = 0; i<board.length; i++)
    {  if(board[i][col] == digit)
        {return false;}
    }
    // here checking on the grid
    int startRow = (row/3)*3;
    int startCol = (col/3)*3;
    int endRow =startRow+3;
    int endCol = startCol+3;
    for(int i = startRow; i < endRow; i++ )
    { for(int j = startCol; j < endCol; j++)
        {
            if(board[startRow][startCol] == digit)
            {return false;}
        }
    }
    return true;
}
public static boolean sudokuSolver(int board[][],int row,int col)
{
    // base case
    if(row == 9)
    { return true;
    }
    int nextRow=row;
    int nextCol = col+1;
    if(col+1 == 9)
    { nextRow = row+1;
        nextCol = 0;
    }
    // kaam
    if(board[row][col] != 0)
    { return sudokuSolver(board,nextRow,nextCol); }

// board exisit doesn't zero value
   for(int digit=1; digit <=9; digit++)
    {    if(isSafers(board,row,col,digit))
            {  board[row][col] = digit;
               if(sudokuSolver(board,nextRow,nextCol))
               {return true; }
               board[row][col]=0;
              
            }
    }
  return false;
}
  


// how can rat reach to the destination
public static void reachDestination(int maze[][],int x,int y)
{
    if(x==maze.length-1 && y == maze.length-1)
    {  printBoardb(maze);
        return ;
    }
    if(maze[x][y] == 1)
    {  reachDestination(maze,x,y+1); }
}





  public static void main(String args[]){
  
    // al.add(2);
    // al.add(3);
  
    // System.out.println(al);
// / int maze[][]=
    // {   {1,0,0,0},
    //     {1,1,0,1},
    //     {0,1,0,0},
    //     {1,1,1,1}
    // };
//    char board[][] = new char[4][4];
//    for(int i=0; i<board.length; i++)
//    {
//      for(int j=0; j<board.length; j++)
//      {
//         board[i][j]='x';
//      }
//    }  
// printBoard(board);
//  if(nQueens(board,0))
//  { printBoard(board);};

    // int board[][]={
    //     {0,0,8,0,0,0,0,0,0},
    //     {4,9,0,1,5,7,0,0,2},
    //     {0,0,3,0,0,4,1,9,0},
    //     {1,8,5,0,6,0,0,2,0},
    //     {0,0,0,0,2,0,0,6,0},
    //     {9,6,0,4,0,5,3,0,0},
    //     {0,3,0,0,7,2,0,0,4},
    //     {0,4,9,0,3,0,0,5,7},
    //     {8,2,7,0,0,9,0,1,3} };

    //     if(sudokuSolver(board,0,0)==true)
    //     { printBoard(board);}
    //     else 
    //     {
    //         System.out.println("the soloution doesn't exist");
    //     }
        // findPermutation("abc","");
    //   int n = 4;
    //   char board[][] = new char[n][n];
    // //   intialize
    // for(int i = 0; i<board.length; i++)
    // {
    //     for(int j = 0; j<board.length; j++)
    //     {board[i][j] = 'x'; }
    // }
    // System.out.println(fact(3));
    // System.out.println(str.substring(0,1));
    // nQueens(board,0);
    // System.out.println("the total number of possible soloution is "+count);
    // if(nQueens(board,0)==true)
    // {
    //     System.out.println("the soloution is exist");
    //     printBoard(board);
    // }
//     String str="b";
//     System.out.println(str.substring(0,1) + str.substring(0+1));
//    System.out.println(gridWays(0,0,3,3));
  System.out.println('9'-'0');
} 