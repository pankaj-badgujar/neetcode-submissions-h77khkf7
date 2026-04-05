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

        // we create a slow and fast pointer. 
        // the point after slow (slow.next) is second half
        // we reverse the list from there onwards.
        // once we have both heads we just merge
        

        ListNode s = head;
        ListNode f = head.next;
        while(f != null && f.next != null){
            s = s.next;
            f = f.next.next;
        }
        ListNode second = s.next;
        ListNode prev = null;
        s.next = null; // end first half on a null

        // here we reverse second half
        while(second != null){
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }

        ListNode first = head;
        // prev is the head of the reversed part now
        second = prev;

        while(second != null){
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }
}
