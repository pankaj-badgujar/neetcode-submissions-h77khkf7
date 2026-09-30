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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode leftCut = null, dummy = new ListNode(-1);
        dummy.next = head;
        
        Deque<ListNode> stack = new ArrayDeque<>();
        int pos = 1;

        // find left
        while (pos < left){
            leftCut = head;
            head = head.next;
            pos++;
        }

        while (pos < right){
            stack.addLast(head);
            head = head.next;
            pos++;
        }
        ListNode rightCut = head.next;

        if (leftCut != null){
            leftCut.next = head;
        } else {
            dummy.next = head;
        }

        while (!stack.isEmpty()){
            head.next = stack.removeLast();
            head = head.next;
        }

        head.next = rightCut;

        return dummy.next;
    }
}