/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;


        while (!stack.isEmpty() || curr != null){
            // we go to left subtree
            while (curr != null){
                stack.addLast(curr);
                curr = curr.left;
            }

            // we pop now since our left is null
            curr = stack.removeLast();
            
            if (--k == 0){
                return curr.val;
            }
            curr = curr.right;
        }
        return 0;
    }
}
