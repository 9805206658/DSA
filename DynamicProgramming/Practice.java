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
                     System.out.println("enter");
                    union(cell1, cell2);
                } else if (ch[j] == '/'){
                    int cell1 = (i+1)*dots + j;
                    int cell2 = i*dots + (j+1);
                    System.out.println("enter");
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
public class Practice
{ public static void main(String args[])
   {
    Solution sol = new Solution();
    String str []= {" /","/ "};
    System.out.println( sol.regionsBySlashes(str));
   }
}