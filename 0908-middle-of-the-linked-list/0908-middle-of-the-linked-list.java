/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Algo Used: Slow and Fast Pointers
    // TC: O N , SC: O 1
    public ListNode middleNode(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;

        while(fast != null && fast.next != null){ // until the fast reaches to last index move slow and fast pointers
            slow= slow.next;  // move by 1 index
            fast= fast.next.next;  // move by 2 index
        }

        return slow; // return slow i.e the will be the mid after iterating linkedlit
    }
}