import java.util.*;
public class HomeWork
{
//    public static void decToBin(int num)
//    {
//     Stack <Integer> st = new Stack<>();
//     while(num != 0)
//     {  st.push(num%2);
//         num = num/2;
//     }
//     // here printing the value of stack
//     boolean isZero = false;
//     while(!st.isEmpty())
//     {
//         if(st.peek() == 0 && isZero == false)
//         {st.pop();}
//         else 
//         {  isZero = true;
//             System.out.print(st.pop());
//         }
//     }
//     System.out.println();
//    }
//    public static void printAllBin(int n)
//    {
//     for(int i = 1; i<=n; i++)
//     {decToBin(i);
//     }
    
//    }
 public static void printAllBin(int n)
 {
    Queue<String> q = new LinkedList<>();
    q.add("1");
    while(n>0)
    {   String str1 = q.peek();
        q.remove();
        System.out.println(str1);
        String str2 = str1;
        q.add(str1+"0");
        q.add(str2+"1");
        n--;
    }
    System.out.println("remaining vlaue of stack");
    while(!q.isEmpty())
    {
        System.out.println(q.remove());
    }
 }
  public static int minCost(int[] arr)
  {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int cost= 0;
    int res = 0;
    for(int i = 0 ; i < arr.length; i++)
    { pq.add(arr[i]); }
    while(pq.size()>1)
    {   int first = pq.poll();
        int second = pq.poll();
         res = first+second;
         cost += res;
        pq.add(res); 
    }
    return cost;
}
public static void reverseKElement(Queue<Integer> q,int k)
{
    Stack <Integer> s = new Stack<>();
    for(int i = 0; i<k; i++)
    {s.push(q.remove());}
    while(!s.isEmpty())
    {q.add(s.pop());}
    for(int i=0; i<q.size()-k; i++)
    {q.add(q.remove());}
}
   public static void main(String args[])
    {  
    HashMap<Character,Integer> hm = new HashMap<>();
    hm.put('a',3);
    System.out.println(hm.get('b'));
    Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);
        q.add(60);
        q.add(70);
        q.add(80);
        q.add(90);
        q.add(100);
        reverseKElement(q,5);
        System.out.println("the value :"+((char)('a'+'1')));
        while(!q.isEmpty())
        {System.out.println(q.remove());}
    }
}

     //  printAllBin(5);
    //     int a=1;
    //    int  b= a;
    //    System.out.println("a:"+a);
    //    System.out.println("b:"+b);   
     
