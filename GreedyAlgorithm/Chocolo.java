import java.util.*;
public class Chocolo
{

    public static void main(String args[])
    {
      System.out.println('w'-'a');
        int n=3
        int m=3;
        // horizental cost
       Integer horCost[] = {4,1,2};
        // vertical cost
        Integer verCost[]={2,1,3,1,4};
        Arrays.sort(horCost,Collections.reverseOrder());
        Arrays.sort(verCost,Collections.reverseOrder());
          // hp= horizental pieces vp = vertical pieces;
        int hp=1,vp=1,h=0,v=0;
        int cost = 0;
        while(h<horCost.length && v<verCost.length)
        { if(horCost[h]<= verCost[v])
            { cost = cost+verCost[v]*hp; // claculate vertical cost because vertical cost expensive
               vp++;
               v++;
            }
            else 
            {cost = cost+horCost[h]*vp; // claculate vertical cost because vertical cost expensive
              hp++;
               h++;
            }
        }
        // here calculating reamining peieces
        while(h<horCost.length)
        {  cost = cost+horCost[h]*vp; // claculate vertical cost because vertical cost expensive
              hp++;
               h++;
        }
         while(v<verCost.length)
        {  cost = cost+verCost[v]*vp; // claculate vertical cost because vertical cost expensive
             vp++;
               v++;
        }
        System.out.println("the total minimum cost"+cost);


    }
}