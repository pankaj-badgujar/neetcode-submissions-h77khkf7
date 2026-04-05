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
     public ListNode removeNthFromEnd(ListNode head, int n) {
        // put each node into a stack
        // then count and pop from stack, if count = n, skip it.
        // after that just pop remaining
        // in the end, return head

        Stack<ListNode> stack = new Stack<>();
        ListNode start = head;

        while(start != null){
            stack.push(start);
            start = start.next;
        }
        
        ListNode result = null;
        while(!stack.isEmpty()){
            ListNode node = stack.pop();
            n--;
            if(n == 0){
                continue;
            }
            node.next = result;
            result = node;
        }
        return result;
    }
}
