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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        while(head != null){
            System.out.println(visited.toString());
            System.out.printf("head.val: %d\n--\n", head.val);
            if(visited.contains(head)){
                return true;
            }
            visited.add(head);
            head = head.next;
        }
        return false;
    }
}
