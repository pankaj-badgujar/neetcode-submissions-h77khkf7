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
        // for every node we need the height of its left subtree, and right subtree.
        // their difference should be less than 2.

        // to pass up, each node will pas max of (left, and right )
    boolean isBalanced = true;

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = dfs(root.left);
        int rightHeight = dfs(root.right);
        
        if (Math.abs(leftHeight - rightHeight) > 1){
            isBalanced = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

    
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }
}
