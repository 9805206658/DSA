public class Test2
{
    public static void printSpiral(int matrix[][])
    {
        int startRow=0;
        int startCol=0;
        int endRow=matrix.length-1;
        int endCol=matrix[0].length-1;
        //top
        while(startRow<=endRow)
        {
        for(int i=startRow;i<=endCol;i++)
        {
            System.out.print(matrix[startRow][i]+" ");
        }
        //right

        for(int i=startRow+1;i<=endRow;i++)
        {
            System.out.print(matrix[i][endCol]+" ");
        }
        //bottom
        for(int i=endCol-1;i>=startCol;i--)
        {
            System.out.print(matrix[endRow][i]+" ");
        }
        //left
        for(int i=endRow-1;i>=startRow+1;i--)
        {
            System.out.print(matrix[i][startCol]+" ");
        }
        startRow++;
        endCol--;
        startCol++;
        endRow--;
        } }

   public static void printMatrix(int matrix[][])
    {
      for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
                 {
                 System.out.print(matrix[j][i]+" ");
                  }
               System.out.println();
               }
    }

  public static void transpose(int matrix[][]) {
  for(int i=0;i<matrix.length;i++)
     {
         for(int j=0;j<matrix.length;j++)
        { 
            
            int temp=matrix[i][j];
            matrix[i][j]=matrix[j][i];
            matrix[j][i]=temp;
           }
        }  

         for(int i=0;i<matrix.length;i++)
    {
        for(int j=0;j<matrix.length;j++)
        {
            System.out.print(matrix[i][j]+" ");
        }
        System.out.println();
    }  
   }


 public static void main(String args[])
    {
    int matrix[][]=
   {{1,2,3},
    {4,5,6}  };
   transpose(matrix);}
}