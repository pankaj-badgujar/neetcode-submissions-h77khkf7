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

    // private extractNode(node, res){
    //     ListNode temp = node.next;
    //     node.next = null;
    //     res.next = node;
    //     node = temp;
    // }
    
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(-1, null);
        ListNode curr = head;

        while(list1 != null && list2 != null){
            ListNode temp;
            if (list1.val <= list2.val){
                // extract list1 into res
                temp = list1.next;
                list1.next = null;
                curr.next = list1;
                list1 = temp; // incremented
            } else {
                // extract list2 into res
                temp = list2.next;
                list2.next = null;
                curr.next = list2;
                list2 = temp; // incremented
            }
                curr = curr.next;
        }
        if(list1 == null){
            curr.next = list2;
        } else {
            curr.next = list1;
        }
        return head.next;
    }
}