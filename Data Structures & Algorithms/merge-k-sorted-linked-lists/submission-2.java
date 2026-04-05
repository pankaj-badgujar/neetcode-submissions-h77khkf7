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
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(a != null && b != null){
            if(a.val < b.val){
                curr.next = a;
                a = a.next;
            } else {
                curr.next = b;
                b = b.next;
            }
            curr = curr.next;
        }
        if(b != null){
            curr.next = b;
        } else {
            curr.next = a;
        }

        return dummy.next;
    }

    private ListNode divide(ListNode[] lists, int l , int r){
        if(l > r){
            return null;
        }
        if(l == r){
            return lists[l];
        }
        int m = l + (r - l)/ 2;
        ListNode left = divide(lists, l, m);
        ListNode right = divide(lists, m+1, r);
        return mergeTwoLists(left, right);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(lists == null || k == 0){
            return null;
        }
        return divide(lists, 0, k - 1);
    }
}
