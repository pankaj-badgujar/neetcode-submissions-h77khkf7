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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 1->8
        // 4->5->6

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode carry = new ListNode(0);

        while(l1 != null || l2 != null){
            int sum = carry.val;
            if(l1 != null){
                sum += l1.val;
            }
            if(l2 != null){
                sum += l2.val;
            }
            System.out.println("sum: " + sum);
            curr.next = new ListNode(sum % 10);
            carry.val = sum / 10;
            curr = curr.next;
            if (l1 != null){
                l1 = l1.next;
            }
            if (l2 != null){
                l2 = l2.next;
            }
        }
        if(carry.val > 0){
            curr.next = new ListNode(carry.val);
        }
        return dummy.next;
    }
}
