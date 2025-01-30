import java.util.*;
public class CheapestFlight
{
    static class Edge{
        int src ;
        int des;
        int wt;
        public Edge(int src,int des,int wt)
        {
            this.src = src ;
            this.des = des;
            this.wt = wt;

        }
    }

   static class Info
   {
    int v;
    int  wt;
    int  stops;
    public Info(int v , int weight, int stops)
    {
        this.v= v;
        this.wt = wt;
        this.stops = stops;
    }

   }

    // here defining fuctionc core funtion 
    public static int cheapestFlight(int flights[][],int src,int des,int k)
    {
        // creating  graph
        int size = flights.length;
        ArrayList<Edge>graph[] = new ArrayList[size];
        createGraph(flights,graph);
        // here creating calculate intital distance for all vertex from src to des ;
        int dist[] = new int[size];
        for(int i = 0; i < size ; i++)
        {
            if(i != src)
            {  dist[i] = Integer.MAX_VALUE; }
        }
        // creating the queue 
        Queue<Info> q = new  LinkedList<>();
        // adding the initial element 
        q.add(new Info(0,0,0));
        //  here start looping 
        while(! q.isEmpty())
        {
            Info curr = q.remove();
            if(curr.stops > k )
            {
              break;

            }
                //   here adding neighbour; 
                for(int i = 0 ; i < graph[curr.v].size(); i++)
                {
                    Edge edge = graph[curr.v].get(i);
                    int u = curr.v ;
                    int v = edge.des;
                    int wt = edge.wt;
                  // performance relaxation steps
                    if(wt+dist[u] < dist[v] && curr.stops <= k)
                    {
                        dist[v] = wt+dist[u];
                        // here add the pair in the queue 
                        q.add(new Info(v,dist[v],curr.stops+1));

                    }

                }
                }
        if(dist[des] == Integer.MAX_VALUE)
        {
            return -1;
        }
        else 
        {
            return dist[des];
        }





    }

    
   public static void createGraph(int flights[][],ArrayList<Edge>list[])
   {
    // here intializing arraylist
    for(int i = 0; i < flights.length; i++)
    {
        list[i] = new ArrayList<>();
    }
    // here inserting the element 
    for(int i = 0; i  < flights.length; i++)
    {
        int src = flights[i][0];
        int des = flights[i][1];
        int wt = flights[i][2];
        Edge edge= new Edge(src,des,wt);
        list[src].add(edge);
    }


   }
   
    public static void main(String args[])
    {
        int flights[][]={
            {0,1,100},
            {1,2,100},
            {0,2,500}
        };

       int  src = 0;
        int dest = 2;
        int k = 1;

      System.out.println(cheapestFlight( flights,src, dest, k));
    

    }
}