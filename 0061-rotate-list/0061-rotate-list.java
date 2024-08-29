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
    // Algo Used: Basic Logic (Dry run with pen and paper)
    // TC: O N , SC: O 1
    public ListNode rotateRight(ListNode head, int k) {

        if(k < 1 || head == null || head.next == null){ // Edge case
            return head;
        }

        ListNode last= head;  // last is our LL tail currently
        int length=1;

        while(last.next != null){ // find the len of LL, via our tail i.e last
            length++;
            last= last.next;
        }

        last.next= head;  // attach the last node's next to head;
        
        int rotations = k  % length; // this will give the no. of rotations, suppose len of LL is 6 and k= 8 then it will do 8 % 6 = 2 , so it will rotate 2 times.
        int n= length - rotations; // steps to reach one step before the rotation begins

        ListNode newLast= head; //one step before the rotaiton begins = newLast
        for(int i=0; i< n - 1 ; i++){ // newLast will be our new tail, so reaching till there
            newLast= newLast.next;
        }
        head= newLast.next; // newLast.next will be our new head.
        newLast.next = null; //now point newLast.next = null as newLast is our tail now.
        
        return head; // return head.
    }
}