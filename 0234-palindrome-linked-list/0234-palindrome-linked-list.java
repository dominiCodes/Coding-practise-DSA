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
    // ALgo Used: ReverseLL and Finding Mid
    // TC: O N , SC: O 1

    public boolean isPalindrome(ListNode head) {

        ListNode mid = getMid(head);  // find the mid og LL
        ListNode midHead= reverseLL(mid);  // Reverse the LL from mid, if LL is Palindrome then (Head to mid-1 and mid to tail will be equal after reversing second half)
        //Eg: 1221 -> 1212 

        while(head != null && midHead != null){ // keep comaring the nodes(first node from head second node from mid), the list will be splitted in two parts.
            if(head.val != midHead.val){  
                return false;
            }
            head=head.next;
            midHead= midHead.next;
        }
        return true;
    }

    public ListNode getMid(ListNode head) {  // find mid
        ListNode slow= head;
        ListNode fast= head;

        while(fast != null && fast.next != null){ // until the fast reaches to last index move slow and fast pointers
            slow= slow.next;  // move by 1 index
            fast= fast.next.next;  // move by 2 index
        }

        return slow; // return slow i.e the will be the mid after iterating linkedlit
    }


     public ListNode reverseLL(ListNode head) {  // Reverse LL
        if(head == null  || head.next == null){   //Edge case
            return head;
        }
        ListNode prev= null;  // 3 pointers
        ListNode curr= head;
        ListNode next = curr.next;

        while(curr != null){  // Iterate until curr is not null
            curr.next= prev;
            prev= curr;
            curr= next;
            if(next != null){  //Check if next.next goesout of bound
                next= next.next;
            }  
        }
        return prev; // at the end prev will be at the last node, curr will be at null
    }
}