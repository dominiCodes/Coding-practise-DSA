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
    //ALgo Used: Slow and Fast pointer
    public ListNode detectCycle(ListNode head) {
         if(head== null || head.next == null) return null;
        
        ListNode fast= head;
        ListNode slow= head;
        ListNode first= head;
        
        while(fast!=  null && fast.next!= null){
             slow= slow.next;
             fast= fast.next.next;
             
            if(fast == slow){
        
              while(first!=  slow){ // once the fast and slow has meet, increase the first node and slow pointer from the (fast slow meet) simultaneously, the point where they meet will be the start of cycle. 
                   first= first.next;
                   slow= slow.next;
              }
              return slow; //or slow
             }
        }
        return null;
    }
}