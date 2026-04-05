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
    private ListNode[] reverseThisSublist(Deque<ListNode> stack){
        //[1,2,3]
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!stack.isEmpty()){
            curr.next = stack.poll();
            curr = curr.next;
        }
        curr.next = null;

        return new ListNode[]{dummy.next, curr};
    }
    public ListNode reverseKGroup(ListNode head, int k) {

         
        // i want a helper to which i give: a stack of nodes, 
        // ask it to reverse
        // it gives me back a reversed list (head and a tail), 
        // that i then attach its head the next of my tail.
        // and its tail is now my new tail.

        // i want to call this helper only if size of the stack is equal to k,
        // keep on doing this until i dont reach null
        // if i reach null, then we have to append remaining to the tail.next;
        // but for that, we should know the head of the remaining
        
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        
        // //[1,2,3,4,5], k = 3
        ListNode curr = head; // [1]

        while(curr != null){
            stack.push(curr);
            curr = curr.next;
            // if we have already reached the size, then time to call the helper
            if (stack.size() == k){
                ListNode[] headAndTail = reverseThisSublist(stack); //3 and 1
                tail.next = headAndTail[0]; // we attach new reversed list to our tail
                tail = headAndTail[1]; // tail now points to the new tail
                stack.clear();
            } 
        }
        
        if(!stack.isEmpty()){
            while(stack.size() > 1){
                stack.poll();
            }
            tail.next = stack.poll();    
        }
        return dummy.next;
    }
}
