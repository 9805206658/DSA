import java.util.*;
public class ConnectRopes
{

    public static void main(String args[])
    {
        int arr[]= {5,1,6};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<arr.length; i++)
        {
            pq.add(arr[i]);
        }
        System.out.println(pq);
        System.out.println(pq.peek());
        // here calculate the cost
        int cost = 0;
        while(pq.size()>1)
        {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += min1+min2;
            pq.add(min1+min2);
            
        }
        System.out.println("tht total cost "+cost);
    }
}  