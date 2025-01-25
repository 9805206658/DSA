import java.util.*;
public class MinimumTime
{
    public static void minTime(int N,int k,int arr[])
    {
     //   here creating the normal queue
     Queue<Integer> q = new LinkedList<>();
      boolean vis[] = new boolean[N+1];
      int time = 0;
      for(int i = 0;  i<k; i++)
      {
        q.add(arr[i]);
        vis[arr[i]] = true;
      }
      while(q.size() > 0)
      {
        for(int i = 0; i<q.size(); i++)
        {
            int curr = q.poll();
            // left adjacent element 
            if(curr-1 >=1 && vis[curr-1] != true)
            {
                q.add(curr-1);
                vis[curr-1] = true;
            }
            // wright adjecent element;
            if(curr+1 <= N && vis[curr+1] != true)
            {
                q.add(curr+1);
                vis[curr+1] = true;
            }
        }
        time++;

      }
    System.out.println("the minimu time is " + (time-1));
    }

    public static void pathMinumEffort(int[][] path)
    {
        int m = path.length; 
        int n = path[0].length;
        int totalEffort = path[0][0];
        int r = 0;
        int c = 0;
        class Paths implements Comparable<Paths>
        {
            int effort;
            int row;
            int col;
            public Paths(int effort,int row,int col)
            {
                this.effort = effort;
                this.row = row;
                this.col = col;
            }
            @Override
            public int compareTo(Paths p1)
            {
                return this.effort - p1.effort;
            }
        }

         
        while(path[r][c] != path[m][n])
        {
            PriorityQueue<Paths> pq = new PriorityQueue<>();
            // row = 0 and colum = 0;
            // int temp1 = r;
            // int temp2 = c;
            // if(r == 0 && c == 0)
            // {   r ++;
            //     pq.add(new Paths(path[r][temp2],r,temp2));
            //     c++;
            //     pq.add(new Paths(path[temp1][c],temp1,c));
            // }
            // else if(r == 0 && c<n-2)
            // {   r++;
            //     pq.add(new Paths(path[r][temp2],r,temp2));
            //     c++;
            //     pq.add(new Paths(path[temp1][c],temp1,c));
            // }

            // else if(r == m-1 && c<n-2)
            // {
            //     r--;
            //     pq.add(new Paths(path[r][temp2],r,temp2));
            //     c++;
            //     pq.add(new Paths(path[temp1][c],temp1,c));
            // }
            // else if(r)

             
           
            totalEffort += pq.peek().effort;
            i = pq.peek().row;
            j = pq.peek().col;
         

        }
        System.out.println("the total effort is "+totalEffort);
        
    }
    public static void main(String args[])
    {
        int path1 [][]={
            {31,100,65,12,18},
            {10,13,47,157,6},
            {100,113,174,11,33},
            {88,124,41,20,140},
            {49,32,111,41,20}
        };
        pathMinumEffort(path1);
       
        
    }
}





public class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        int[][] dist = new int[rows][cols];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        minHeap.add(new int[]{0, 0, 0});
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int effort = top[0], x = top[1], y = top[2];
            
            if (effort > dist[x][y]) continue;
            
            if (x == rows - 1 && y == cols - 1) return effort;
            
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < rows && ny >= 0 && ny < cols) {
                    int new_effort = Math.max(effort, Math.abs(heights[x][y] - heights[nx][ny]));
                    if (new_effort < dist[nx][ny]) {
                        dist[nx][ny] = new_effort;
                        minHeap.add(new int[]{new_effort, nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}