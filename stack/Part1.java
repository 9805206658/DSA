import java.util.*;
public class Part1
{
   static class Stack
    {
        ArrayList<Integer> list = new ArrayList<>();
        // checking the stack is empty or not
        public boolean isEmpty()
        {  
            return list.size()==0;
        }
        public void push(int data)
         {   list.add(data); }

        public int pop()
        { int data = list.get(list.size()-1);
          if(isEmpty()== true)
          {  return -1; }
           list.remove(list.size()-1);
          return data;
        }
        public int peek()
        { if(isEmpty()== true)
          { return -1;}
           int data = list.get(list.size()-1);
           return data;
        }
    }
    
    public static void main(String args[])
    {
        Stack s =new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        // here printing the statck element;
        while(!s.isEmpty())
        { System.out.println(s.pop()); }
        System.out.println(s.peek());
    }
}