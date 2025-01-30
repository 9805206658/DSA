// connecting cities code 
import java.util.*;
public class Connect
{
    static class Pair implements Comparable<Pair>{
        int dest;
        int cost;
        public Pair(int dest,int cost)
        {
            this.dest = dest;
            this.cost = cost;
        }
        @Override
        public int compareTo(Pair p2)
        {
            return this.cost - p2.cost;
        }
    }
    public static  int connectCities(int cities[][])
    {
        //creating the priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean vist[] = new boolean[cities.length];
        int finalCost = 0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty())
        {
            Pair curr = pq.remove();
            if(!vist[curr.dest])
            {
                vist[curr.dest] = true;
                finalCost += curr.cost;
                for(int i = 0; i < cities[curr.dest].length; i++)
                {
                    if(cities[curr.dest][i] != 0)
                    {
                        pq.add(new Pair(i,cities[curr.dest][i]));
                    }
                }
             }
        }
     return finalCost;

    }
    public static void main(String args[])
    {
        int cities[][]= 
        {
            {0,1,2,3,4},
            {1,0,5,0,7},
            {2,5,0,6,0},
            {3,0,6,0,0},
            {4,7,0,0,0}
        };
        System.out.println(connectCities(cities));

       
    }

}