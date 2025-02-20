public class Part1
{
    static class Queue
    {
       static int arr[];
        static int rear;
       static int size;
       static int front;
        public Queue(int n)
        {   arr = new int[n];
            rear = -1;
            front = -1;
            size = n;
        }
        public static boolean isEmpty()
        {return (rear == -1 && front == -1);}

         public static boolean isFull()
         {   System.out.println("front"+front);
           System.out.println("rear"+rear);
             return (front%size == (rear+1)%size);  
        
         }
        public static void add(int data)
        { // here check the queue is full or not
            if(isFull())
            { System.out.println("queue is full");}
            // case while adding the first element
            if(front == -1)
            { front = 0;}
            rear = (rear+1)%size;
            arr[rear] = data;
         }
    
         public static int remove()
         {
            if(rear == -1)
            {
             System.out.println("the queue are empty");
             return -1;
            }
            int result = arr[front];
            if(front == rear)
            {
                front = rear = -1;
            }
            else 
            {
                front = (front+1)%size;
            }
            return  result;
          

        //   peek
        public static int peek()
        { if(isEmpty())
            { System.out.println("the queue is empty");
              return -1;
            }
            int data = arr[front];
            return data;
        }
    }
    static class Queue
    {
        
    }
    public static void main(String args[])
    {
        Queue q = new Queue(20);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(5);
        q.add(6);
        q.add(10);
        q.remove();
        q.remove();
        q.add(11);
        
     
        while(!q.isEmpty())
        { System.out.println(q.remove()); }

    }
}
}