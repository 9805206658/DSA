import java.util.*;

public class Test
{
   public static void solveSudoku(char[][] board) {
     sudokuSolver( board ,0, 0);
     }
    public static boolean isSafers(char[][]board,int row,int col,char value)
    {
        // row test;
        System.out.println("enter");
        for(int i = 0;i<9; i++)
        { if(board[row][i] == value)
            {
                return false;
             }
        }
        // column test;
        for(int i =0; i<9; i++)
        {
            if(board[i][col] == value)
            {
                return false;
            }
        }
        // find out starting row and start colum;
        int startRow = (row/3)*3;
        int startCol =  (col/3)*3;
        int endRow =0 , endCol =0;
        endRow = startRow + 3;
        endCol = endCol + 3;
        for(int i = startRow; i<endRow; i++)
        {
            for(int j = startCol; j<endCol; j++)
            {
                // checking the digit either exist or not on the grid;
                if(board[i][j] == value)
                { return false;}
            }
        }
        
        return true;
       }
    public static boolean sudokuSolver(char[][] board ,int row,int col)
    {
       if(row == 9)
       {return true;}
       int nextCol = col+1;
       int nextRow = row;
        if(col == 8)
        {   nextRow +=1;
            nextCol = 0;
        }
        // the vlaue are greater than zero;
        if(board[row][col] != '.')
        { return sudokuSolver(board,nextRow,nextCol); }
        // the value are not zero;
         for(int digit= 1; digit<= 9; digit++)
        {  if(isSafers(board,row,col,Integer.toString(digit).charAt(0)))
            { 
                // System.out.println("enter");
                // System.out.println(Integer.toString(digit).charAt(0));
            board[row][col] = Integer.toString(digit).charAt(0);
            System.out.println(board[row][col]);
              if(sudokuSolver(board,nextRow,nextCol))
              {return true;}
              board[row][col] ='.';
             }
         }
        return false;
    }
    // n queen prblem
       public static List<String> charToStr(char[][] rows)
    {
        List<String> l = new ArrayList<>();
         for(int i= 0;i<rows.length; i++)
         { 
            StringBuilder sb = new StringBuilder();
            for(int j =0;j<rows[0].length; j++)
           {
             sb.append(rows[i][j]);
           }
           l.add(sb.toString());
         }
         return l;
     }
   
    public static void printBoard(List<List<String>> board)
    { for(int i=0; i<board.size(); i++)
        { System.out.println(board.get(i)); }
           System.out.println();    
    }
    public static void placeQ(List<List<String>> board,char subBoard[][],int row)
     {  if(row == subBoard.length)
        {  board.add(charToStr(subBoard));
            return ;
        }
        for(int i = 0; i<subBoard.length; i++)
        {  subBoard[row][i] = 'Q';
            placeQ(board,subBoard,row+1);
            subBoard[row][i] = '.';
        }

     }

    
    public static void main(String args[])
    {
        // List<String> l = new ArrayList<>();
        // l.add("....");
        // l.add("....");
        // l.add("....");
        // l.add("....");
        // String str = l.get(0);
        // char strs[] = str.toCharArray();
        // strs[0] = '9';
        // l.remove(0);
        // l.add(0,charToStr(strs));
        // System.out.println(l);

        
        
        //  char[][] board = {
        //     {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        //     {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        //     {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        //     {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        //     {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        //     {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        //     {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        //     {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        //     {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        // };
        // solveSudoku(board);
        // // here printing the board;
        // for(int i =0;i<board.length;i++)
        // {
        //     for(int j=0; j<board.length;j++)
        //     {
        //         System.out.print(board[i][j]);
        //     }
        //     System.out.println();
        // }
      char subBoard[][] = {{'x','x'}, {'x','x'} };
      List<List<String>> board = new ArrayList<>();
      placeQ(board,subBoard,0);
      printBoard(board);

    }
}




