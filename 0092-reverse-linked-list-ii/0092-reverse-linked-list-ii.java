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
    // Algo Used: Reverse LL with 3 pointers with some variation
    // TC: O N , SC O 1
    // Do and refer the dry run with pen and papper for clear understanding

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right){ // if there is only one node temp return (edge case)
            return head;
        }

        ListNode prev= null;
        ListNode curr= head;

        int counter= 0;
        while(curr != null && counter < left - 1){ // traverse till the left-1 node, so that we have to link it toh the new reverse node which will come after it
            prev= curr;
            curr= curr.next;
            counter++;
        }

        ListNode last= prev; // this is the new reverse node which will come after it( after calculated left - 1 posi).
        ListNode newEnd= curr;  // curr node(first node) will become last after reversing.

        int i=0;
        int n= (right - left) + 1;
        ListNode next= curr.next;
        while(curr != null && i< n){    // normal reversing logic using iterative approach
            curr.next= prev;
            prev= curr;
            curr= next;
            if(next != null){
                next= next.next;
            }
            i++;
        }

        if(last != null){   // if calculated left - 1 is not null then make last.next as prev
            last.next = prev;
        }else{  //if calculated left - 1 is null i.e left -1 will be 0 then make the head as prev i.e it will become the first node as there is no calculated node (left-1) present before it so make it the head
            head= prev;
        }

        newEnd.next= curr; // attach the newnd with cur.

        return head;
    }

}