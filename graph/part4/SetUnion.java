public class SetUnion
{
    static int size = 7;
    static int parent[] = new int[size];
    // initial the rank node will be zero
    static int rank[] = new int[size];
    public static void init()
    {
        // initializing the parent;
      for(int i = 0; i < 7 ;i++ )
      {
        parent[i] = i;
      }
    }
    // this function find parent
    public static int findParent(int A)
    {
        if(parent[A] == A)
        {
            return A;
        }
        // here doing optimization with path compression
        return  parent[A]=findParent(parent[A]);
    }

    // union function defination
    public static void union(int A ,int B)
    {
        int parA = findParent(A);
        int parB = findParent(B);
        //similar rank;
        if(rank[parA] == rank[parB])
        {
        // making the parent b  is a ;
          parent[parB] = parA;
        //   increase the rank of parent a;
          rank[parA] ++;
        }
        else if(rank[parA] > rank[parB])
        {
            parent[parB] = parA;
        }
        else 
        {
            parent[parA] = parB;
        }
    }

    public static void main(String args[])
    {
        init();
        // System.out.println(findParent(3));
        union(3,1);
        // System.out.pr5intln(findParent(4));
        union(4,2);
        union(3,4);
        System.out.println(rank[3]);
         


    }
}