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
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(root == null) return null;

        deque.addLast(root);

        while (!deque.isEmpty()){
            
            TreeNode node = deque.removeFirst();
            
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.right != null) deque.addLast(node.right);
            if (node.left != null) deque.addLast(node.left);
            
        }
        return root;
    }
}
