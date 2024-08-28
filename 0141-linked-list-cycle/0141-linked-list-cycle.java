/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    //Algo: Fast and slow pointer Method

    public boolean hasCycle(ListNode head) {
        ListNode fast= head;
        ListNode slow= head;

        while(fast != null && fast.next != null){ // the fast pointer should not be on the tail and should not be on the null(which is tail's next)
            slow= slow.next;
            fast= fast.next.next;

            if(fast == slow){ // cycle caught
                return true;
            }
        }
        return false; 
    }
}