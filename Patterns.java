public class Patterns
{

   public static void hollow_pattern(int rows,int cols)
   {
      for(int i=1;i<=rows;i++)
      {
        // inner loop
        for(int j=1;j<=cols;j++)
        {
            if(i==1 || i==rows || j==1 || j==cols)
            {
                System.out.print("*");
            }
            else
            {
                System.out.print(" ");
            }
        }
        System.out.println();

      } }
     public static void zero_one_trangle(int rows,int cols)
     {
        for(int i=1; i<=rows; i++)
        {
            for(int j=1; j<=i; j++)
            {
              if((i+j)%2==0)
              {
                System.out.print("1");
              }
              else
              {
                System.out.print("0");

              }
            }

        System.out.println();
        }

     }
    public static void butterfly_pattern(int n)
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1; j<=i; j++)
            {
                System.out.print("*");
            }
            for(int j=1; j<=2*(n-i); j++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n; i>=1; i--)
        {
             for(int j=1; j<=i; j++)
            {
                System.out.print("*");
            }
            for(int j=1; j<=2*(n-i); j++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++)
            {
                System.out.print("*");
            }
            System.out.println();

        }

    }

    public static void solid_rohombus(int n,int start_num)
    {
        for(int i=1;i<=n;i++)
        {
            for(int j=1; j<=n-i; j++)
            {
                System.out.print(" ");
            }
            for(int j=1;j<start_num;j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }

public static void diamond_pattern(int n)
{
    // first part
    for(int i=1;i<=n;i++)
    {
     //  spacesd
    for(int j=1;j<=n-i; j++)
    {
        System.out.print(" ");
    }
    for(int j=1; j<=2*i-1; j++)
    {
        System.out.print("*");
    }
    System.out.println();
    }

    for(int i=n; i>=1; i--)
    {
      //  spacesd
    for(int j=1;j<=n-i; j++)
    {
        System.out.print(" ");
    }
    for(int j=1; j<=2*i-1; j++)
    {
        System.out.print("*");
    }
    
    System.out.println();

    }
    //second part 


}

public static void half_diamond(int n)
{
    // first part
    for(int i=1;i<=n;i++)
    {
        for(int j=1;j<=2*i-1; j++)
        {
            if(j%2==0)
            {
                System.out.print("*");
            }
            else{
                System.out.print(i+1);
            }

        }
        System.out.println();
    }
    // second
    for(int i=n;i>=1;i--)
    {
          for(int j=1;j<=2*i-1; j++)
        {
            if(j%2==0)
            {
                System.out.print("*");
            }
            else{
                System.out.print(i+1);
            }

        }


    }

}

// public static void pure_diamond(int n)
// {
   
 
//     for(int i=1;i<=(2*n)-1;i++)
//     {
        
//         if(i<n)
//         {
          
//         for(int j=1;j<=n-i;j++)
//         {
//             System.out.print(" ");
//         }
//         }

//         if(i>n)
//         {
//             for(int j=1;i<=)
//         } }}



        public static void diamond_number_pattern(int n)
        {
            for(int i=1;i<=n;i++)
            { // spaces
                for(int j=1;j<=n-j;j++)
                {
                    System.out.print(" ");

                }
                 int num = 1;
                for(int j=1;j<=(2*i)-1;j++)
                {
                   
                    System.out.print(num);
                    if(j>=i)
                    {
                     num--;
                     }
                    else
                    { num++; }

                }
                System.out.println();
            }



            
        }

    public static void main(String args[])
    {
       diamond_number_pattern(5);

    }
    
}