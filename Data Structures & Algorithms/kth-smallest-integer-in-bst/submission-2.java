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
    int lowestFound = 0;
    int kthSmallest = -1;
    private void dfs(TreeNode root, int k){
        if (root == null || kthSmallest != -1){
            return;
        }
        
        dfs(root.left, k);
        lowestFound++;

        if (lowestFound == k){
            kthSmallest = root.val;
            return;
        }

        dfs(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return kthSmallest;
        
    }
}
