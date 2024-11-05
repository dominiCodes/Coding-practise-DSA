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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);  // Dummy node to simplify edge cases
        ListNode current = dummyHead;  // Pointer to construct the result linked list
        int carry = 0;  // To keep track of the carry value when summing digits
        
        // Traverse both linked lists until we reach the end of both
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;  // Get value from l1 if exists, else 0
            int y = (l2 != null) ? l2.val : 0;  // Get value from l2 if exists, else 0
            
            int sum = x + y + carry;  // Sum of two digits and carry
            carry = sum / 10;  // Update carry for the next step ( / bcz lekin for 7+5=12 we will get 12/10= 1)
            current.next = new ListNode(sum % 10);  // Create a new node with the result digit (% bcz taking the last digit only)
            
            current = current.next;  // Move the pointer to the next node
            
            // Move to the next nodes in l1 and l2 if they exist
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        // If there's a carry left after the final addition, add a new node with carry value
        if (carry > 0) {
            current.next = new ListNode(carry);
        }
        
        return dummyHead.next;  // Return the next of dummyHead which is the actual result head
    }
}