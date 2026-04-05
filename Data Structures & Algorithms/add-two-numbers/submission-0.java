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
        long n1 = 0, n2 = 0;
        
        int multiplier = 1;
        while(l1 != null){
            n1 += l1.val * multiplier;
            multiplier *= 10;
            l1 = l1.next;
        }
        multiplier = 1;
        while(l2 != null){
            n2 += l2.val * multiplier;
            multiplier *= 10;
            l2 = l2.next;
        }
        System.out.println("n1: " + n1);
        System.out.println("n2: " + n2);
        long sum = n1 + n2;
        
        System.out.println("sum: " + sum);
            

        multiplier = (int)Math.pow(10, Long.toString(sum).length() - 1);
        ListNode dummy = new ListNode(-1);
        while(multiplier >= 1){
            int d = (int)sum / multiplier;
            sum = sum % multiplier;
            multiplier /= 10;

            ListNode newNode = new ListNode(d);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
            // System.out.println("multiplier: " + multiplier);
            // System.out.println("d: " + d);
            // System.out.println("sum: " + sum);
        
        return dummy.next;
    }
}
