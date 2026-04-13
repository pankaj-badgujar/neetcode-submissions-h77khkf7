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
    int max = 0;

    public int maxHelper(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = maxHelper(root.left);
        int rightHeight = maxHelper(root.right);
        
        max = Math.max(max, leftHeight + rightHeight); // update diameter
        return Math.max(leftHeight, rightHeight) + 1;//return height

    }
    public int diameterOfBinaryTree(TreeNode root) {
        maxHelper(root);
        return max;
    }
}
