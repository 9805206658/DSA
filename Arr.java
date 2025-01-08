import java.util.Scanner;
import java.util.Arrays;
public class Arr
{
    public static void spiral(int nums[][])
    {
         int startRow=0;
         int startCol=0;
         int endRow=nums.length-1;
         int endCol=nums[0].length-1;
        while(startRow<=endRow && startCol<=endCol)
        {
        for(int j=startCol;j<=endCol;j++)
        { System.out.print(nums[startRow][j]+" "); }
    // right
        for(int i=startRow+1;i<=endRow;i++)
        {
            System.out.print(nums[i][endCol]+" ");

        }
         System.out.println();
        //bottom
        for(int j=endCol-1;j>=startCol;j--)
        {
        
            System.out.print(nums[endRow][j]+" ");
        }
        //right
         System.out.println(endRow);
        for(int i=endRow-1; i>=startRow+1; i--)
        {
           
            System.out.print(nums[i][startCol]+" ");
        }
        startRow++; 
        startCol++;
        endCol--;
        endRow--;
        }

    }
    public static void printArray(int []arr)
    {  for(int i=0; i < arr.length; i++)
        { System.out.print(arr[i]);}
    }
   
   public static void min_max(int nums[][])
   {
    int min=Integer.MAX_VALUE;
    int max=Integer.MIN_VALUE;
    for(int i=0;i<nums.length;i++)
    {
        for(int j=0;j<nums[0].length;j++)
        {   if(nums[i][j]<min)
            {  min=nums[i][j];}
            if(nums[i][j]>max)
            { max=nums[i][j]; }
        }
    }
    System.out.println("the maximum value is "+max);
    System.out.println("the minimum value is "+min);

   }

  public static  void search(int arr[][],int target)
   {
    boolean check=false;
    for(int row=0;row<arr.length;row++)
    {for(int col=0;col<arr[0].length;col++)
        { if(arr[row][col]==target)
            {   check=true;
                System.out.println("the element are found at"+"("+row+","+col+")");
                break;
            }
        }
    }
    if(check==false)
    { System.out.println("the element not found "); }
}

public static void diagonalSum(int nums[][])
{
    int rowLen=nums.length;
    int colLen=nums[0].length;
    int sum=0;
    
    
    for(int i=0;i<=rowLen-1;i++)
    {
        System.out.println(nums[i][i]);
        sum+=nums[i][i];
        if(((rowLen-1)-i)!=i)
        {
        sum+=nums[(rowLen-1)-i][i];
        }
     }
     System.out.println("the total sum"+(sum));
}
 
public static void diagonalSumB(int matrix[][])
{
    int sum=0;
    for(int i=0;i<matrix.length-1;i++)
    {
        for(int j=0;j<matrix.length-1;j++)
        {
            if(i==j)
            {
                sum+=matrix[i][j];
            }
            else if(i+j==matrix.length-1)
            {
                sum+=matrix[i][j];
            } }
           
     }
     System.out.println("the sum is"+sum);

}

//here writing the code for the searching in order 2d matrix
public static boolean stairCaseSearch(int matrix[][],int target)
{
    int left=matrix[0].length-1;//col
    int bottom =0; //row
    while(left>=0 && bottom<=matrix.length-1)
    {
        if(matrix[bottom][left]==target)
        {
            System.out.println("the element are found at matrix"+"("+left+","+bottom+")");

            return true;
        }
        else if(target>matrix[bottom][left])
        {
            bottom++;

        }
        else if(target<matrix[bottom][left])
        {
            left--;
        }
    }
return false;

}

public static int findSeven(int matrix[][])
{
      int count=0;
    for(int i=0;i<matrix.length;i++)
    {
       for(int j=0;j<matrix[0].length;j++) 
       {
        if(matrix[i][j]==7)
        {
            count++;

        }
        
       }
    }
    return count;

}

 public static int threeSumClosest(int[] nums, int target) {
        int closet_sum=Integer.MAX_VALUE/2;
        // sorting the array
       Arrays.sort(nums);
        for(int i=0; i < nums.length-2; i++)
        {    // System.out.println("the vlaue of  i"+i);
            int left=i+1;
            int right=nums.length-1;
            while(left<right)
            {
                int current_sum= nums[i]+nums[left]+nums[right];
                if(Math.abs(current_sum-target ) <  Math.abs(closet_sum-target))
                { closet_sum=current_sum ; }
                if(current_sum < target)
                {  System.out.println("the left"+left);
                    left++;
                 }
                else if(current_sum > target)
                {  System.out.println("the right"+right);
                     right--;
                }
                else 
                { System.out.println("enter");
                     return current_sum; }
            }
        }
          return closet_sum;
 }

 public static void print2dMatrix(int matrix[][])
 {
      for(int i=0; i<matrix.length; i++)
     {
        for(int j=0; j<matrix[0].length; j++)
        {
            System.out.print(matrix[i][j]);
        }
        System.out.println();
     }
    

 }


  public static int minArraySum(int[] nums, int k, int op1, int op2) {
        Arrays.sort(nums);
        int i,j;
        int opt1=0;
        int opt2=0;
        int sum=0;
        for(i=nums.length-1; i>0; i--)
        {
            if(opt1!=op1)
            {nums[i]=Math.round(nums[i]/(float)2);
            opt1++;
            }
            else 
            { break;}
        }
        printArray(nums);
        System.out.println(i);
        for(j=i; j>=0; j--)
        {
             if(opt2 != op2)
             {nums[j]=nums[j]-k;
             opt2++;
             }
        }
        for(int l=0; l<nums.length; l++)
        {
            sum+=nums[l];
        }
        return sum;
        // perfroming the 2nd operation 
    }


   public static void setZeroes(int[][] matrix) {
        // here finding zero element
          int row=matrix.length;
        int col=matrix[0].length;
        int existZero[][]=new int [row][col];
          int re=0;
        for(int i=0;i < matrix.length; i++)
        {
            for(int j=0; j < matrix[0].length; j++)
            {
                if(matrix[i][j]==0)
                {
                    existZero[re][0]=i;
                    existZero[re][1]=j;
                    re++;
                    

                }
            }
        
        }
        print2dMatrix(existZero);
        System.out.println();
        System.out.println();

        for(int i=0; i<existZero.length; i++)
        {
            for(int j=0; j<existZero[0].length; j++)
            {
                //  here setting rows and colums zer0

                if(j==0 && existZero[i][j]!=0)
                {
                // row constant
                for(int k=0; k<col; k++)
                { matrix[existZero[i][j]][k]=0;}
                }
                // column constant
                 if(j==1 && existZero[i][j]!=0)
                {
                for(int k=0; k<row; k++)
                { matrix[k][existZero[i][j]]=0;}
                }

            }
        }
       
        
   }

  public static void main(String args[])
    {
     int matrix[][]={{1,1,1},{1,0,1},{1,1,1}};
    int nums='2'-'1';
     System.out.println(nums);
    //  setZeroes(matrix);
    //  print2dMatrix(matrix);
    System.out.println(20|64);
   }

}
    