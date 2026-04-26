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
    int max = Integer.MIN_VALUE;

    private int dfs(TreeNode root){
        if (root == null){
            return 0;
        }
        
        int myLeftsBest = Math.max(dfs(root.left),0);
        int myRightsBest = Math.max(dfs(root.right), 0); 

        int withSplit = root.val + myLeftsBest + myRightsBest;

        max = Math.max(max, withSplit);

        return root.val + Math.max(myLeftsBest, myRightsBest);
    }

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
}
