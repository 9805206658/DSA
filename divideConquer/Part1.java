public class Part1
{
    public static  void printArray(int []arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]);
        }
        
    }
     public static  void printArray(String []arr)
    {
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
        
    }
    public static  void mergeSort(int []arr,int si, int ei)
    {
        if(si>=ei)
        {
            return ;
         }
        int mid=(si+ei)/2;
        // left
        mergeSort(arr,si,mid-1);
        //right
        mergeSort(arr,mid+1,ei);
        merge(arr,si,mid,ei);
    }

    public static void merge(int []arr,int si,int mid,int ei)
    {
        int [] temp=new int[ei-si+1];
        int i=si; //for left
        int j=mid+1;// for right
        int k=0;// for temp
        while(i<=mid && j<=ei)
        {
            if(arr[i]<arr[j])
            {
           temp[k]=arr[i];
           i++;
            }
            else 
            { temp[k]=arr[j];
              j++;
            }
            k++;
        }
        while(i<=mid)
        {temp[k++]=arr[i++]; // for remaining left  }
        while(j<=ei)
        {temp[k++]=arr[j++];}//for remaining right  }
        // copying the temparay array element into the actual array;
        for(k=0,i=si; i<temp.length; k++,i++)
        {  arr[i]=temp[k];}
        }
    }
    public static void quickSort(int arr[],int si,int ei)
    {
        // kaam ;
        if(si>=ei)
        {
            return ;
        }
         int pivotIndex=partion(arr,si,ei);
         quickSort(arr,si,pivotIndex-1);
         quickSort(arr,pivotIndex+1,ei);
    }
    public static int partion(int []arr,int si,int ei )
    {
      int i=si-1;
      for(int j=si;j<ei;j++)
      {
        // here swapping the element of the partion 
        if(arr[j]<arr[ei])
        {   i++;
            int temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;  } 
      }
       i++;
    //    swaping the last element
       int temp=arr[ei];
       arr[ei]=arr[i];
       arr[i]=temp;
       return i;
    }

// search in the rotated and sorted arrray
    public static int search(int []arr,int tar,int si,int ei)
    {  // kaam
        if(si>ei)
        { return -1;}
        int mid=(si+ei)/2;
        if(arr[mid]==tar)
        { return mid;}
        if(tar<arr[mid])
        {  // left
           if( (arr[si] <= tar) && arr[mid] <= tar)
            { return search(arr,tar,si,mid-1);}
            // right
           else
            {  return search(arr,tar,mid+1,ei);}
        }
            //line 2
        else 
        { // right
            if(arr[mid]<=tar && tar<=arr[mid])
            {return search(arr,tar,si,mid-1); }
            // left
            else 
            {return search(arr,tar,mid+1,ei);}
        }
 }
 public static  String[] sortString(String[] args,int si,int ei)
 {

  if(si==ei)
  {  
    String[] str={args[si]};
    return str;
  }
   int mid=(si+ei)/2;
   String  strL[] = sortString(args,si,mid);
   String strR[] = sortString(args,mid+1,ei);
   return merge1(strL,strR);
}
public static String[] merge1(String[] str1 ,String[] str2)
{
     int len1=str1.length;
     int len2 = str2.length;
     String []temp = new String[len1+len2];
     int k=0;
     int i=0;
     int j=0;
     while(i<len1 && j<len2)
     {
      if(isAphabaticallySamller(str1[i],str2[j]))
       {temp[k]=str1[i];
        i++;
        }
       else 
       {temp[k]=str2[j];
        j++;
       }
       k++;
     }
     
    //  reamining element of the first line 
    while(i<len1)
    {temp[k++]=str1[i++];}
    //reamining elment of the second line 
    while(j<len2)
    { temp[k++]=str2[j++];}
    // copying the temp element into actual array element 
   return temp;
}


public static boolean isAphabaticallySamller(String arg1, String arg2)
{
   if(arg1.compareTo(arg2)<0)
   {
    return true;
   }
   return false;

}

// it is done using the recursion 
// public static int majorityElement(int digits[],int majority,int index,int count)
// {
//     if(index==digits.length)
//     {
//         return majority;
//     }
//     if(digits[index]==majority)
//     { count++; }
//     else if(count==0 && digits[index]!=majority)
//     {
//         majority=digits[index];
//         count++;
//     }
//     return majorityElement(digits,majority,index+1,count);

// }
// here apporach to identify the marjority elements
public static int majorityElement(int digits[])
{
    int majorityCount=digits.length/2;
    for(int i=0; i<digits.length; i++)
    {
        int count=0;
        for(int j=0; j<digits.length; j++)
        {
            if(digits[i]==digits[j])
            {
                count++;
            }
       }
       if(count >  majorityCount)
       {
         return digits[i];
       }

    }
    return -1;
}

// majority element by using the recursion 
public static int countInRange(int args[],int nums,int si, int ei)
{
    int count=0;
    for(int i=si; i<ei; i++)
    {
        if(nums==args[i])
        {
            count++;
        }
    }
    return count;
}


public static int majorityRecursion(int digits[],int si,int ei)
{
    if(ei==si)
      {return digits[ei]; }
    int mid=(si+ei)/2;
    int left=majorityRecursion(digits,si,mid);
    int right=majorityRecursion(digits,mid+1,ei);
    if(left==right)
    {
        return right;
    }
    int leftCount=countInRange(digits,left,si,ei);
     int rightCount=countInRange(digits,right,si,ei);
    return  leftCount>rightCount? left:right;

}

 public static void main(String args[])
    {
        int digits[]={5,6,7,8,8,8};
        int val=Integer.MAX_VALUE;
    //    System.out.println( majorityRecursion(digits,0,digits.length-1));/
    for(int i=0; i<digits.length; ++i)
     {System.out.println(digits[i]); }

     System.out.println();

      for(int i=0; i<digits.length; i++)
     { System.out.println(digits[i]);}
     System.out.println(val/2);


    }   
   
        
}