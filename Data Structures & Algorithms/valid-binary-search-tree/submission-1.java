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
    private boolean dfs(TreeNode root, int min, int max){
        if (root == null){
            return true;
        }
        if (root.val <= min || root.val >= max){
            return false;
        }

        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
    public boolean isValidBST(TreeNode root) {

        // we do DFS
        // each node gets a min, and a max
        // it cannot be less than or equal to min
        // it cannot be greater than or equal to max
        // if its either, return false;
        // if not, then check its left and right subtrees

        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}
