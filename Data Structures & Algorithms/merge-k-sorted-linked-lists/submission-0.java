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
    private ListNode mergeTwoLists(ListNode a, ListNode b){
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(a != null && b != null){
            if(a.val < b.val){
                ListNode temp = a.next;
                curr.next = a;
                curr = curr.next;
                a = temp;
            } else {
                ListNode temp = b.next;
                curr.next = b;
                curr = curr.next;
                b = temp;
            }
        }
        if(a == null && b != null){
            curr.next = b;
        } else if(b == null && a != null){
            curr.next = a;
        }

        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {

        int k = lists.length;

        if (k == 0){
            return null;
        }

        if (k == 1){
            return lists[0];
        }
        
        ListNode mergedList = lists[0];

        for(int i = 1 ; i < k; i++){
            mergedList = mergeTwoLists(mergedList, lists[i]);
        }
        return mergedList;
    }
}
