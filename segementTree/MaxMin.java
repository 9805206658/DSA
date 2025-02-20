public class MaxMin
{
     static int tree[];
    public static void init(int n)
    {  tree = new int[n*4];
    }
    public static void buildTree(int arr[],int i,int si,int sj)
    {   if(si == sj)
        {   tree[i] = arr[si];
            return;
        }
        int mid = (si+sj)/2;
        // left  i = i*2+1;
        buildTree(arr,i*2+1,si,mid);
        buildTree(arr,i*2+2,mid+1,sj);
        tree[i] = Math.max(tree[i*2+1],tree[i*2+2]);
    }
    public static void updateUtil(int val,int i,int idx,int si,int sj)
    {   

          
         System.out.println("the val"+val);
         System.out.println("the idx"+idx); 
           System.out.println("the si:"+si);
         System.out.println("the sj:"+sj); 
         if( idx < si || idx > sj)
         {return ;}
         tree[i] =Math.max(tree[i],val);
         System.out.println(tree[i]);
         if(si != sj)
         {  int mid = (si + sj)/2;
            updateUtil(val,i*2+1,idx,si,mid);
            updateUtil(val,i*2+2,idx,mid+1,sj );
         }
    }
    public static void update(int arr[],int idx,int value)
    {
        arr[idx] = value;
        updateUtil(value,0,idx,0,arr.length-1);
    }
    public static int findMaxUtil(int i,int si,int sj,int qi, int qj)
    {     // not overlapping
      if(si > qj || sj < qi)
        {return Integer.MIN_VALUE; }
        // complete overlapping
        if( si >= qi && sj <= qj)
        { return tree[i];}
        else
        { // partial overallping
          int mid = (si+sj)/2;
          int left = findMaxUtil(i*2+1,si,mid,qi,qj);
          int right = findMaxUtil(i*2+2,mid+1,sj,qi,qj);
          return Math.max(left,right);
       }

    }

    public static int findMax(int arr[],int qi,int qj)
    {  return findMaxUtil( 0,0,arr.length-1, qi, qj);
     }
    public static void main(String args[])
    {  
        
        System.out.println("the number"+2%5);
        
        //  int arr[] = {6,8,-1,2,17,1,3,2,4};
        // init(arr.length);
        // buildTree(arr,0,0,arr.length-1);
        // update(arr,2,20);
        // System.out.println("the value"+findMax(arr,0,6));
                
    }
}






class ProductOfNumbers {

    // Stores cumulative product of the stream
    private ArrayList<Integer> prefixProduct = new ArrayList<>();
    private int size = 0;

    public ProductOfNumbers() {
        // Initialize the product list with 1 to handle multiplication logic
        this.prefixProduct.add(1);
        this.size = 0;
    }

    public void add(int num) {
        if (num == 0) {
            // If num is 0, reset the cumulative products since multiplication
            // with 0 invalidates previous products
            this.prefixProduct = new ArrayList<Integer>();
            this.prefixProduct.add(1);
            this.size = 0;
        } else {
            // Append the cumulative product of the current number with the last
            // product
            this.prefixProduct.add(this.prefixProduct.get(size) * num);
            this.size++;
        }
    }

    public int getProduct(int k) {
        // Check if the requested product length exceeds the size of the valid
        // product list
        if (k > this.size) return 0;

        // Compute the product of the last k elements using division
        return (
            this.prefixProduct.get(this.size) /
            this.prefixProduct.get(this.size - k)
        );
    }
}




class MyCalendar {
    private List<int[]> books = new ArrayList<>();
    public boolean book(int start, int end) {
        for (int[] b : books)
            if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
        books.add(new int[]{ start, end });
        return true;
    }
}
/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */



