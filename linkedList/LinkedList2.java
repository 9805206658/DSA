import java.util.LinkedList;
public class LinkedList2
{
    public static void main(String args[])
    {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addFirst(2);
        ll.addLast(3);
        ll.addLast(4);
        System.out.println(ll);
        ll.removeLast();
        ll.removeFirst();
         System.out.println(ll);
        
    }
}