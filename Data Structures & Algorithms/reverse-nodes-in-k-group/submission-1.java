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
    private ListNode getKth(ListNode curr, int k){
        while (curr != null && k > 0){
            curr = curr.next;
            k--;
        }
        return curr;
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(-1, head);
        ListNode groupPrev = dummy; // one node before the group
        // dummy->1->2->3

        while (true){
            ListNode kth = getKth(groupPrev, k);
            if(kth == null){
                break;
            }
            ListNode groupNext = kth.next; //one node after the group

            ListNode prev = kth.next;
            ListNode curr = groupPrev.next; // first node of the group
            //reverse the group
            while(curr != groupNext){
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;




        }
        return dummy.next;

    }
}
