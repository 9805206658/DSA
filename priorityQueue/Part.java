import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.*;
public class Part
{   // here making the class
    static class Student implements Comparable<Student>
    {
        String name;
        int grade;
        public Student(String name,int grade)
        {   this.name = name;
            this.grade = grade;
        }
        @Override
        public int compareTo (Student s2)
        { return (this.grade - s2.grade); }

    }
//  implement heap using the arraylist
    static class Heap{
     ArrayList<Integer> al = new ArrayList<>();
      public void insert(int data)
        {  al.add(data);
            int x=al.size()-1;
            int par = (x-1)/2;
            while(al.get(par) > al.get(x))
            {   int temp = al.get(x);
                al.set(x,al.get(par));
                al.set(par,temp);
                x=par;
                par = (x-1)/2;
            }
        }
     public int get()
     {return al.get(0);}
     public void heapify(int idx)
     {
        int left = 2*idx+1;
        int right = 2*idx+2;
        int minIdx = idx;
        // here check either heap are balance or not
        if(left < al.size() && al.get(idx)>al.get(left))
        {
           minIdx = left;
        }
        if(right < al.size() && al.get(idx) > al.get(right))
        {
           minIdx = right;
        }
       if(minIdx != idx)
        {
          int temp = al.get(idx);
          al.set(idx,al.get(minIdx));
          al.set(minIdx,temp);
          heapify(minIdx);
        }
     }
     public boolean isEmpty()
     {
        return (al.size() == 0);
     }

     public int remove()
     {  // swapping first and last index;
        int data = al.get(0);
        int temp = al.get(0);
        al.set(0,al.get(al.size()-1));
        al.set(al.size()-1,temp);
         // remove the last element
        al.remove(al.size()-1);
        // hipify 
        heapify(0);
        return data;
     }
     public void peek()
     {
        System.out.println(al.get(0));
     }

    }
     public static void main(String args[])
    {

        Heap h1 = new Heap();
        h1.insert(3);
        h1.insert(4);
        h1.insert(1);
        h1.insert(5);
        while(! h1.isEmpty())
        {
            h1.peek();
            h1.remove();
        }
    }
    //   here creating the priority queue
    // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    // pq.insert(1);
    // pq.insert(2);
    // pq.insert(4);
    // pq.insert(3);
    // pq.insert(5);
    // while(!pq.isEmpty())
    // {  System.out.println(pq.peek());
    //     pq.remove();
    // }
    // }
    // PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
    //  pq.insert(new Student("A",2));
    //  pq.insert(new Student("C",5));
    //  pq.insert(new Student("D",16));
    //  pq.insert(new Student("E",20));
    //  while(!pq.isEmpty())
    //  {
    //     System.out.println(pq.peek().name+"->"+pq.peek().grade);
    //     pq.remove();
    //  }
    // }
}