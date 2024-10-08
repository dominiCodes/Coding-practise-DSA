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

// Refer Note Book , TC ON, SC O1
class Solution {
    //Algo Used: Dummy node with 3 pointers method
    // TC: O N , SC O 1
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy= new ListNode();
        dummy.next= head;
        // Declaring our 3 pointers
        ListNode prev= dummy;
        ListNode curr= head;
        ListNode next= curr.next;
         
        int count= 0;
        
        while(curr!= null){ //getting the length of LL
            count++;
            curr=curr.next;
        }
        curr =head;
       

        
        while(count >= k){ // loop until we have k pairs left , break when the remaining nodes are < k times
           // after every loop adjust curr and next
        // (Dry run Eg: as per Leetcode Eg: 1 for first k groups)
           curr= prev.next; // It is intitally pointed to 1 
           next= curr.next; // pointed to 2
            
           for(int i=1; i<k; i++){ // change the links for reversing
               curr.next= next.next; //pointing 1 -> 3
               next.next= prev.next; // pointing 2 -> 1
               prev.next= next; // pointing 1 -> 3
               next= curr.next; // updating our next from 2 to 3 and the same things will repeat for rest of the k groups
           }
            prev= curr; // updating our prev i.e it will be now 2
            count-= k;
        }
        return dummy.next; //return head
    }
}