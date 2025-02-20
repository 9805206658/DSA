import java.util.*;
public class Part4
{
    public static int longestIncPath(int mat[][],int i , int j, int m, int n,int dp[][])
    {
        if(i < 0 || j < 0 || i > m-1 || j > n-1)
        { return 0; }
        if(dp[i][j] != -1)
        {
            return dp[i][j];
        }
        int ans = 1;
        // left
        if( j-1  >= 0 && mat[i][j] > mat[i][j-1])
        { ans = Math.max(ans,1+longestIncPath(mat,i,j-1,m,n,dp));
        }
        // right
        if( j+1  < n && mat[i][j] > mat[i][j+1])
        {  ans = Math.max(ans,1+longestIncPath(mat,i,j+1,m,n,dp));}

        // top
        if(i-1 >= 0 && mat[i][j] > mat[i-1][j])
        { ans = Math.max(ans,1+longestIncPath(mat,i-1,j,m,n,dp));}

        // down
        if(i+1 < m && mat[i][j] > mat[i+1][j])
        { ans = Math.max(ans,1+longestIncPath(mat,i+1,j,m,n,dp));}
        return dp[i][j] = ans;
    }
    public static void main(String args[])
    {
        int mat[][] =  {   {9,9,4},
                           {6,6,8},
                           {2,1,1}
                       };
        int row = mat.length;
        int col = mat[0].length;
        int dp[][] = new int[row][col];
        for(int i = 0; i < row; i++)
        {  for(int c[]:dp)
            { Arrays.fill(c,-1);}
        }
        
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < mat.length; i++)
        {  for(int j = 0; j < mat[0].length; j++)
            { result = Math.max(result,longestIncPath(mat,i,j,mat.length,mat[0].length,dp));}
        }
         System.out.println("the longest path"+result);

     
    }
}



class Solution {
    int[] parent;
    int[] rank;
    int count;
    public int regionsBySlashes(String[] grid) {
        int rows = grid.length;
        int dots = rows+1;
        // creating the rank for the  square matrix
        parent = new int[dots*dots];
        rank = new int[dots*dots];
        for (int i=0; i<parent.length; i++){
            parent[i] = i;
            rank[i] = 1;
        }



// here joining the boundary
        for (int i=0; i<dots; i++){
            for (int j=0; j<dots; j++){
                if (i==0 || j==0 || i==rows || j==rows){
                    int cells = i * dots + j;
                    union(0, cells);
                }
            }
        }



        for (int i=0; i<rows; i++){
            // conver the string to charArray
            char[] ch = grid[i].toCharArray();
            for (int j=0; j<ch.length; j++){
                if (ch[j] == '\\'){
                    int cell1 = i* dots+ j;
                    int cell2 = (i+1)*dots + (j+1);
                    union(cell1, cell2);
                } else if (ch[j] == '/'){
                    int cell1 = (i+1)*dots + j;
                    int cell2 = i*dots + (j+1);
                    union(cell1, cell2);
                }
            }
        }
        return count;
    }

    public void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if (parentA == parentB){
            count++;
        } else {
            if (rank[parentA] > rank[parentB]){
                parent[parentB] = parentA;
            } else if (rank[parentA] < rank[parentB]){
                parent[parentA] = parentB;
            } else {
                parent[parentB] = parentA;
                rank[parentA]++;
            }
        }
    }

    public int find(int a){
        if(parent[a]==a)
            return a;
        int temp = find(parent[a]);
        parent[a] = temp;
        return temp;
    }

}