import java.util.*;
public class Part1
{
  public static int fractionalKnapSack(int capacity ,int value[],int weight[] )
  { // creating  2d array
    int size = value.length;
    int ratio[][] = new int[size][2];
    // store ratin on array with its real index
    for(int i = 0; i<size ; i++)
    { ratio[i][0]=i;
      ratio[i][1]=(int)value[i]/weight[i];
    }
    // sorting the array; on thechainOfPair(i basis of the ration
    Arrays.sort(ratio,Comparator.comparingDouble(o -> o[1]));
  // calculating the maximum value
  int totalValue=0;
  for(int i=size-1; i >= 0; i--)
    { if(weight[ratio[i][0]] <= capacity)
      {  totalValue = totalValue + value[ratio[i][0]];
         capacity = capacity-weight[ratio[i][0]];
       }
      else
      { totalValue = totalValue + capacity*ratio[i][1];
        capacity =0;
      }
    }
    return totalValue;
  }




  public static int minimumAbsoluteDiff(int arr1[],int arr2[])
  {
    // sorting the array
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    int minAbs=0;
    // calculating the min array;
    for(int i = 0; i<arr1.length; i++)
    {
      minAbs = minAbs + Math.abs(arr1[i]-arr2[i]);
    }
    return minAbs;

  }
    public static void activitySelection(int start[],int end[])
      { int n = start.length;
        int activities[][] = new int[n][n];
        //  if the array is given in the unsorted sorted ;
        for(int i=0; i<start.length; i++ )
        {  activities[i][0] =  i;
           activities[i][1] = start[i];
           activities[i][2] = end[i];
        }
        // sorting the array
        Arrays.sort(activities,Comparator.comparingDouble(o -> o[2]));
        // Display the sorted array
        for(int i=0; i<activities.length; i++)
        {for(int j=0; j<activities.length; j++)
          {System.out.print(activities[i][j]);}
          System.out.println();
        }
        // here doing the program for activity selection
        ArrayList<Integer> ll = new ArrayList<>();
        int max   = activities[0][2];
        int count = 1;
        ll.add(activities[0][0]);
         int endTime = activities[0][2];
        for(int i=1; i<start.length; i++)
        {  if(activities[i][1]>= endTime)
            {ll.add(activities[i][0]);
              endTime = activities[i][2];
            }
       }

       for(int i=0; i<ll.size(); i++)
       { System.out.println("A"+ll.get(i));
    }
   }

//  chain of pairs
public static void chainOfPair(int pairs[][])
{
  Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
  // here calculating the length;
  int maxLen = 1;
  int pairEnd = pairs[0][1];
  for(int i = 0; i < pairs.length; i++)
  { if(pairs[i][0]>= pairEnd)
    { maxLen++;
      pairEnd = pairs[i][1];
    }
  }
  System.out.println("the max length" + maxLen);
}
public static void nepaliCoinSysem(Integer coins[],int amount)
{// here sorting the array in descending order
  Arrays.sort(coins,Comparator.reverseOrder());
  ArrayList<Integer> al = new ArrayList<>();
  int countOfCoins = 0;
  for(int i = 0; i<coins.length; i++)
  {if(coins[i] <= amount)
    { while(coins[i]<= amount)
      { countOfCoins++;
         al.add(coins[i]);
         amount = amount-coins[i];
      }
    }
  }
 System.out.println("the total numbers of coins" + countOfCoins) ;
 for(int i = 0; i<al.size() ; i++)
 {System.out.println(al.get(i));}
}

  public static void main(String args[])
  {
    // 
      // for activity selection
        //  int start[] = {0,3,1,5,8,5};
        // int end [] = {7,4,2,6,9,9};
        // activitySelection(start,end);
        // for max vlaue knapsack;
        int value[]={60,100,120};
        int weight[]={10,20,30};
        int capacity = 50;
        System.out.println(fractionalKnapSack(capacity,value,weight));
        // int arr1[] = {2,5,6,7,8};
        // int arr2[] = {9,10,11,12,15};
        // System.out.println(minimumAbsoluteDiff(arr1,arr2));
        // int pairs[][]= {{1,2},{2,7},{3,9},{10,11}};
        // chainOfPair(pairs);
        // Integer coins[] = {1,5,10,20,50,100,500,1000};
        // int amount  = 940;
        // nepaliCoinSysem(coins,amount);

    }
}