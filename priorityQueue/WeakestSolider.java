import java.util.*;
public class WeakestSolider
{
    static class SoldierInfo implements Comparable<SoldierInfo>
    {
        int idx;
        int num;
        public SoldierInfo(int idx,int num)
        {   this.idx = idx;
            this.num = num;
        }
        @Override
        public int compareTo(SoldierInfo si1)
        { 
            if(this.num == si1.num)
            {
                return this.idx-si1.idx;
            }
            else
            {
             return this.num -si1.num;
            }
        }
    }
    public static void main(String args[])
    {
        PriorityQueue<SoldierInfo> pq = new PriorityQueue<>();
        int m = 4;
        int n= 4,k=2;

        int solider[][] = {
            {1,0,0,0},
            {1,1,1,1},
            {1,0,0,0},
            {1,0,0,0}};
        for(int i = 0; i<m; i++)
        {   int count = 0;
            for(int j=0; j<m; j++)
            {  
                count = solider[i][j]==1?1:0;
            }
            pq.add(new SoldierInfo(i,count));
        }

        for(int i = 0; i<k; i++)
        {
            System.out.println(pq.peek().idx);
            pq.remove();
        }
    }
}