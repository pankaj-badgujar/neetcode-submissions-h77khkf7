/**
 * Definition for singly-linked list.
 * class ListNode {
 *     constructor(val = 0, next = null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
class Solution {
    /**
     * @param {ListNode} head
     * @param {number} left
     * @param {number} right
     * @return {ListNode}
     */
    reverseBetween(head, left, right) {
        const dummy = new ListNode(0, head);

        let leftPrev = dummy, curr = head;
        for (let i = 0; i < left - 1; i++){
            leftPrev = curr;
            curr = curr.next;
        }
        let prev = null;
        for (let i = 0; i < right - left + 1; i++){
            let temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        leftPrev.next.next = curr;
        leftPrev.next = prev;
        return dummy.next;
    }
}
