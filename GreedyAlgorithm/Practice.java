import java.util.*;
public class Practice 
{
    public static void activitySelection(int start[],int end[])
    {   int n = start.length;
       int activities [][] = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
       Arrays.sort(activities,Comparator.comparingDouble((o)->o[2]));
         ArrayList<Integer> al = new ArrayList<>();
          al.add(activities[0][0]);
          int endTime = activities[0][2];
        for(int i = 1; i < n; i++)
        {
            int startTime = activities[i][1];
            if(startTime >= endTime)
            { al.add(activities[i][0]);
                endTime = activities[i][2];
            }
        }
        System.out.println("the number works:"+al.size());
    }

    // knapsack problem
    public static void knapSack(int values[],int weight[],int w)
    {
        int n = values.length;
        int product[][] = new int[n][n];
        for(int i = 0; i < values.length; i++)
        {  // 0->value, 1->weight, 2->ratio
            int ratio = values[i]/weight[i];
            product[i][0] = values[i];
            product[i][1] = weight[i];
            product[i][2] =  ratio;
         }
        Arrays.sort(product,Comparator.comparingDouble(o->(o[2])));
        int val = 0;
        for(int i = 0; i < n ; i++)
        {
            if(product[i][1] <= w)
            { 
                // System.out.println(product[i][1]);
                val += product[i][0];
                w -= product[i][1];
                  System.out.println(val);
            }
            else if(w > 0 && product[i][1] > w)
            { val += w*product[i][2];
                w = 0;
            }
        }
        System.out.println("the max value is:"+val);
    }

// min absolute difference 
    public static void minAbsDiff(int A[],int B[])
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for(int i = 0; i < A.length; i++)
        {
            sum += A[i]-B[i];
        }
        System.out.println("the sum is:"+sum);
    }

    public static void nepaliCoinsSystem(int price)
    {   int prices[] = {1000,500,100,50,20,10,5,2,1};
        // Arrays.sort(reverseOrder());
        ArrayList<Integer> al = new ArrayList<>();
        int count = 0;
        for(int i = 0; i < prices.length; i++)
        { 
             if(price == 0)
                {
                    break;
                    
                }
            while(prices[i] <= price)
            {   price = price - prices[i];
                al.add(prices[i]);
                count ++;
               
            }
        }
        System.out.println("the total num:"+al.size());
        System.out.println(al);

    }

    public static void main(String args[])
    {
        int start[] = {10,12,20,30,100,50};
        int end[] = {20,25,30,30,30,30,30};


        int value[] = {60,120,100};
        int weight[] = {10,20,30};

        int A[] = {5,3,2};
        int B[] = {1,2,3};
        int w = 50;
        nepaliCoinsSystem(540);
     //    activitySelection(start,end);
     //    knapSack(value,weight,w);
    //   minAbsDiff(A,B);
  
    }
}


