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
    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(0);

        // traverse through the list first, that gets us the count of total nodes in the list | o(n)
        // now while doing that we also create a secondary list that is reversed of the main list

        // once we have two lists, we now create dummy by taking one from each, and decreasing count until zero
        // once ready we return dummy.next;
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode reversedList = null;
        int count = 0;

        while(curr != null){
            ListNode copyNode = new ListNode(curr.val, curr.next);
            ListNode temp = copyNode.next;
            copyNode.next = reversedList;
            reversedList = copyNode;
            copyNode = temp;
            curr = curr.next;
            count++;
        }
        
        ListNode h = head;
        ListNode r = reversedList;
        ListNode d = dummy;

        for(int i = 0; i < count; i++){

            if(i % 2 == 0){
                d.next = h;
                h = h.next;
            } else {
                d.next = r;
                r = r.next;
            }
            d = d.next;
        }
        d.next = null;
        head = dummy.next;
    }
}
