import java.util.*;
public class Knapsack
{
    public static void getValue(int value[],int weight[],int capacity)
    {
        // here store the ration with index 
        int n = value.length;
        int ratio[][] = new int[n][n];
        for(int i = 0; i<value.length; i++)
        { 
            ratio[i][0]= i;
            ratio[i][1]= (int)value[i]/weight[i];
        }
        Arrays.sort(ratio,Comparator.comparingDouble(o->o[1]));
        int totalValue=0;
        int i = ratio.length-1;
        while(capacity !=0)
        {
            if(weight[ratio[i][0]] <= capacity)
            { totalValue += value[ratio[i][0]] ;
              capacity -= weight[ratio[i][0]];
            }
            else 
            {
             totalValue += ratio[i][1]*capacity;
             capacity= 0;
            }
            i--;
        }
        System.out.println("the total value is"+totalValue);
     }

     public static void canJump(int[] nums) {
        int goal = nums.length-1;
      for(int i = nums.length -2; i >= 0; i--)
      {
        if(i+ nums[i] >= goal)
         {
            goal = i;
            System.out.println(goal);
         }

      }
      System.out.println(goal);
      System.out.println ( goal == 0);

    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        // here finding the starting station
        int startPos = 0;
        int n = gas.length;
        for(int i = 0;i<gas.length ; i++)
        {
            int saveFuel = gas[i]-cost[i];
            if(saveFuel > 0)
            {
                startPos = i;
                break;
            }
        }
        // check by traversing;
        int prevPos = startPos;
         int i = startPos+1;
        if(startPos == n-1)
        { i=0; }
        if(i>n-1)
        { i=i%n;}
        int tank = gas[startPos];
        
        while(i != startPos)
        {   if(i >= n)
            {i= i%n;}
            tank = tank - cost[prevPos]+gas[i];
            System.out.println(tank);
            prevPos=i;
            if(tank <0)
            {return -1;}
            i++;
          
            
          }
              System.out.println("pp"+prevPos);
          System.out.println("i:"+i);
        

        // here final condiiton
        if(i == startPos)
        {  tank = (tank - cost[prevPos]);
        System.out.println(tank);
        }

        if(tank >=0)
        { return startPos; }
        return -1;
        
        
    }



    public static void main(String args[])
    {
        int cost[] = {3,4,3};
        int gas[]={2,3,4};
        System.out.println(canCompleteCircuit(gas,cost));
        
    

    }
}