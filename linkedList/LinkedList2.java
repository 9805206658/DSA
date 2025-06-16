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





class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) return head; // No need to reverse if k=1

        // Get the length of the linked list
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        ListNode curr = head, prev = null, next = null, mark = null;
        boolean isFirstGroup = true;
        
        for (int i = 0; i < length / k; i++) { // Reverse only complete k-groups
            ListNode last = curr; // Store the start of the current group
            prev = null;
            
            for (int j = 0; j < k; j++) { // Reverse k nodes
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if (isFirstGroup) { // Set new head for the first reversed group
                head = prev;
                isFirstGroup = false;
            } else { // Connect previous group's last node to the new head
                mark.next = prev;
            }

            mark = last; // Mark the last node of the reversed segment
        }
        
        mark.next = curr; // Connect the last processed segment to remaining nodes
        return head;
    }
}