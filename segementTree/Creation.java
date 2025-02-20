public class Creation
{
     static int tree[];
     public static void init(int n)
     {
        tree = new int[n*4];
     }
    //  creating the segment tree
     public static int buildTree(int i,int start,int end,int arr[])
     { if(start == end)
        {   tree[i] = arr[start];
            return arr[start];
        }
        // building left subTree
        int mid = (start+end)/2;
        buildTree(i*2+1,start,mid,arr); //left i*2+1
        buildTree(i*2+2,mid+1,end,arr);  //right i*2+2
        // building right subTree
         tree[i] = tree[i*2+1]+tree[i*2+2];
         return tree[i];
     }

    public static int getSumUtil(int i,int si,int sj,int qi, int qj)
    {  // 3 cases 
        // not overlaped
        if(qj <= si || qi >= sj )
        { return 0;  }
        // fully overlaped
        if(si >= qi && sj <= qj)
        { return tree[i];}
        else
        {
        // patially overlapped
         int mid = (si+sj)/2;
        int left = getSumUtil(2*i+1,si,mid,qi,qj);
        int right = getSumUtil(2*i+2,mid+1,sj,qi,qj);
        return left + right;
      }
    }
    public static void updateUtil(int arr[],int idx,int i,int si,int sj,int diff)
    {
        // not include in the range
        if(idx < si || idx > sj )
        { return ;
        }
        tree[i] += diff;
        if(si != sj )
        {
         int mid = (si+sj)/2;
         updateUtil(arr,idx,2*i+1,si,mid,diff);
         updateUtil(arr,idx,2*i+2,mid+1,sj,diff);
        }
  

    }
    public static void update(int arr[],int idx,int newValue )
    {
        int diff = newValue - arr[idx];
        arr[idx] = newValue ;
        updateUtil(arr,idx,0,0,arr.length-1,diff);

    }

    public static int getSum(int arr[],int qi,int qj)
    {
        int n = arr.length;
        return getSumUtil(0,0,arr.length-1,qi,qj);

    } 
    public static void main(String args[])
    {
        int arr[] = {1,2,3,4,5,6,7,8};
        int n = arr.length;
        init(n);
        buildTree(0,0,n-1,arr);
        for(int i = 0; i < tree.length; i++)
        {
            System.out.println(tree[i]);
        }
       System.out.println("the range sum is"+getSum(arr,2,5));
       update(arr,2,2);
       System.out.println("the range sum is"+getSum(arr,2,5));
          for(int i = 0; i < tree.length; i++)
        {
            System.out.println(tree[i]);
        }
       

    }
}






/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery* obj = new RangeFreqQuery(arr);
 * int param_1 = obj->query(left,right,value);
 */






class RangeFreqQuery {

    HashMap<Integer,Integer> ans[];
    int arr[];
    public RangeFreqQuery(int[] arr) {
        this.arr = arr;
        int n = arr.length;
        
          int x = (int)
        Math.pow(2,(int)
        Math.ceil(
          Math.log(2*n)/Math.log(2))
        )-1;
         ans = new HashMap[x];
         for(int i = 0; i < x; i++)
         { ans[i] = new HashMap<>();
         }
         buildTree(0,n-1,0);
    }

    public void buildTree(int si,int sj,int idx)
    {
        System.out.println(ans);
        if(si == sj)
        {
        //  ans[idx].put(arr[si],1);
         ans[idx].put(arr[si],1);
         return;
        }
        else
        {   int mid = (si+sj)/2;
            buildTree(si,mid,idx*2+1);
            buildTree(mid+1,sj,idx*2+2);
            ans[idx] = addHashMap(ans[idx*2+1],ans[idx*2+2]);
        }
    }

    public HashMap<Integer,Integer> addHashMap(HashMap<Integer,Integer> h1,HashMap<Integer,Integer> h2)
    {
        HashMap<Integer,Integer> newHp = new HashMap<>();
        for(int x: h1.keySet())
        {
            newHp.put(x,h1.get(x));
        }
        for(int x: h2.keySet())
        {
            newHp.put(x,h2.get(x)+h1.getOrDefault(x,0));
        }
        return newHp;

    }
    public int freqSearch(int si,int sj,int left,int right,int value,int idx)
    {   // out of the boundary
        if(right < si || left > sj)
        {
            return 0;
        }
        // cover full;
        if(si >= left && sj <= right)
        {
            return ans[idx].getOrDefault(value,0);
        }
        // cover half; c
        int  mid = (si+sj)/2;
        int l = freqSearch(si,mid,left,right,value,idx*2+1);
        int r = freqSearch(mid+1,sj,left,right,value,idx*2+2);
        return  l+r;
       

 

    }
    

    public int query(int left, int right, int value) {
      return  freqSearch(0,ans.length-1,left,right,value,0);
        
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */