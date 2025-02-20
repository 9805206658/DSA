import java.util.*;
public class Test
{
     public static Stack<Integer> sort(Stack<Integer> s) {
        Stack<Integer> s1 = new Stack<>();
        while(!s.isEmpty())
        {
         int num = s.pop();
        while(!s1.isEmpty() && num > s1.peek())
         {
             s.push(s1.pop());
         }
         s1.push(num);
        }
        return s1;
        // add code here.

    }
    public static void main(String args[])
    {  // int arr[] ={12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        // 11,2,32,3,41;
        Stack<Integer> stack = new Stack<>();
        stack.push(41); 
        stack.push(3); 
        stack.push(32); 
        stack.push(2); 
        stack.push(11); 
        System.out.println(sort(stack));
   }

}


class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // here finding the starting station
       int totalGas = 0;
       int totalCost =0;
       for(int i = 0;i<gas.length;i++)
       {
        totalGas += gas[i];
        totalCost += cost[i];
       }
    //   check availibility of the gas;
       if(totalGas < totalCost)
       {
        return -1;
       }
    // 
    int startPos = 0;
    int startGas = 0;
       for(int i = 0;i<gas.length; i++)
       {
        startGas += gas[i]-cost[i];
        if(startGas < 0)
        {
            startPos = i+1;
            startGas =0;
        }

       }
       return startPos;
        
    }
}





class Solution {
    // here creating class ele
    class Ele
    {
        int x;
        int y;
        // defining index class store each matrix index;
        public Ele(int x, int y)
        {   this.x = x;
            this.y = y;
        }
    }

   public boolean isValid(Ele temp,int row, int col)
   {if(temp.x >= 0 && temp.x < row && temp.y >= 0 && temp.y < col)
    { return true;
    }
    return false;
   }
 
//  checking element is delimeter or not 
   
  public boolean  isDelimeter(Ele temp)
  { if(temp.x == -1 && temp.y == -1)
    {return true; }
    return false;
  }
//    checking either  all the orange are root or not 
 public boolean checkAll(int grid[][],int row , int col)
   {
    for(int i = 0; i < row ; i++)
    {
         for(int j = 0; j < col ; j++)
         {if(grid[i][j] == 1)
            { return true;}
         }
    }
    return false;
 }

    public int orangesRotting(int[][] grid) {
        // here creating the queue
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0; 
        boolean vist = false;
        Queue<Ele> q = new LinkedList<>();
        // here adding the alll the orange in the queue which root
        for(int i = 0; i < row; i++)
        { for(int j = 0; j < col; j++)
            {
                if(grid[i][j] == 2)
                {
                    q.add(new Ele(i,j));
                }

            }
            // here adding the 
        }
            q.add(new Ele(-1,-1));

        while(!q.isEmpty())
        {
            vist = false;
            
            while(!isDelimeter(q.peek()))
            {
             
                Ele ele = q.peek();
                // top case;
                if(isValid(new Ele(ele.x+1,ele.y),row,col) && grid[ele.x+1][ele.y] == 1)
                {
                      if(vist == false)
                      { ans++; 
                       vist = true;
                      }
                      grid[ele.x+1][ele.y] = 2;
                      ele.x++;
                        q.add(new Ele(ele.x,ele.y));
                    //   bringing in the same position
                      ele.x--;
                }


                // bottom case ;

                  if(isValid(new Ele(ele.x-1,ele.y),row,col) && grid[ele.x-1][ele.y] == 1)
                {
                      if(vist == false)
                      { ans++; 
                       vist = true;
                      }
                     
                      grid[ele.x-1][ele.y] = 2;
                      ele.x--;
                         q.add(new Ele(ele.x,ele.y));
                      ele.x++;
                }

                // left case 
              if(isValid(new Ele(ele.x,ele.y+1),row,col) && grid[ele.x][ele.y+1] == 1)
                {   if(vist == false)
                      { ans++; 
                       vist = true;
                      }
                      grid[ele.x][ele.y+1] = 2;
                      ele.y++;
                         q.add(new Ele(ele.x,ele.y));
                    //   bringing in the same position
                      ele.y--;
                }
             // right case
             if(isValid(new Ele(ele.x,ele.y-1),row,col) && grid[ele.x][ele.y-1] == 1)
                {   if(vist == false)
                      { ans++; 
                       vist = true;
                      }
                      grid[ele.x][ele.y-1] = 2;
                      ele.y--;
                      q.add(new Ele(ele.x,ele.y));
                   
                    //   bringing in the same position
                      
                }
                q.remove();
             }

             q.remove();
             if(!q.isEmpty())
             {
                q.add(new Ele(-1,-1));
             }
        }
         
         if(checkAll(grid,row,col))
         {
            return -1;
         }
        return ans;
            
    }
}


class StockSpanner {
    Stack<int[]> st;
    
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int days = 1;
        while (!st.isEmpty() && st.peek()[0] <= price) {
            days += st.pop()[1];
        }
        st.push(new int[]{price, days});
        return days;    
    }
}