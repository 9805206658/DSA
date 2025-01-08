import java.util.Scanner;
public class LeapYear
{

    public static void butterfly(int n)
    {
        int starts=1;
        int spaces=2*(n-1);
       for(int i=0;i<2*n;i++)
       {
        if(i<n-1)
        {
            // start 
            for(int j=0;j<starts;j++)
            {
                System.out.print("*");
            }
            for(int j=0;j<spaces;j++)
            {
                System.out.print(" ");
            }
             for(int j=0;j<starts;j++)
            {
                System.out.print("*");
            }
            if(i!=n-1)
            {
                 starts++;
                spaces-=2;
            }
            System.out.println();
          
        }
        else 
        {
          for(int j=0;j<starts;j++)
            {
                System.out.print("*");
            }
            for(int j=0;j<spaces;j++)
            {
                System.out.print(" ");
            }
               for(int j=0;j<starts;j++)
            {
                System.out.print("*");
            }
           starts--;
           spaces+=2;
                System.out.println();

            
        }

       }

        

    }




    public static void diamond_pattern(int n)
    {
        int fontSpace=1;
        for(int i=1;i<=n;i++)
        {
            // spaces
            for(int j=1;j<=n-i;j++)
            {System.out.print(" ");
              }
           if(i!=1)
           {
            System.out.print("*");
            for(int j=1;j<=((2*(i-1))-1); j++)
            {
                System.out.print(" ");
            }
            System.out.print("*");

           }
           else
           {
            System.out.print("*");
           }
            
            System.out.println();
         }
        //  backface
        for(int i=1;i<=n-1; i++)
        {
            // spaces
            for(int j=1;j<=i;j++)
            {
                System.out.print(" ");
            }
            if(i!=n-1)
            {
                System.out.print("*");
                for(int j=1; j<=2*(n-(i+1))-1;j++)
                {
                    System.out.print(" ");
                }
                System.out.print("*");

            }
            else
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }
    public static void main(String args[])
    {
    butterfly(4);
    }
}