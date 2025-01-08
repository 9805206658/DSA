public class KnightTour
{
    // here defining function checking the movement safer or not 
     public static boolean isSafe(int board[][] ,int x,int y)
     {
        if(x>=0 && y>=0 && x<board.length && y<board.length && board[x][y] == -1)
        { 
            return true;
        }
        return false;
     }
    // here defining the function printing the soloution.
     public static boolean solveKTUtil(int x,int y,int xMove[],int yMove[],int movei,int sol[][])
     {
        int n=sol.length;
        int nextX,nextY;
        if(movei==n*n)
        { return true; }
        for(int i=0; i < sol.length; i++)
        {   nextX = x+xMove[i];
            nextY = y+yMove [i];
        //  System.out.println("x:"+nextX);
        //  System.out.println("y:"+nextY);

            if(isSafe(sol,nextX,nextY))
            {    sol[nextX][nextY]=movei;
                if(solveKTUtil(nextX,nextY,xMove,yMove,movei+1,sol))
                {return true; }
                else 
                { sol[nextX][nextY] = -1;//here writing code for the }
            }
        }
        return false;
     }
    public static void printSoloution(int sol[][])
    {
        for(int i=0; i<sol.length; i++)
        {  for(int j=0; j<sol.length; j++)
            {System.out.print(" "+sol[i][j]+" "); }
            System.out.println();
        }
    }
    public static void main(String args[])
    {
    //   here creating the matrix table
    int n=5;
    int sol[][] = new int[n][n];
    for(int i=0; i<n; i++)
    { for(int j=0; j<n; j++)
        {sol[i][j]=-1;}
        System.out.println();
    }
    // here defining the movement array
    int x[] = {2,1,-1,-2,-2,-1,1,2};
    int y[] = {1,2,2,1,-1,-2,-1,-1};
    // here defining the soloution matrix
    if(solveKTUtil(0,0,x,y,0,sol))
    { System.out.println("the soloution exist");
        printSoloution(sol);
    }
    else 
    {
        System.out.println("the soloution doesn't exist");
    }

    // here checking the either the x are able to mover or not
   
  


    }
    
}