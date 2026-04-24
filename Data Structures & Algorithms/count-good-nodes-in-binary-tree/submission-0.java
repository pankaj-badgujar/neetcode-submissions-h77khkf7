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
    // static var
    int goodNodes = 0;

    private void dfs(TreeNode root, int max){
        if (root == null){
            return;
        }
        if (root.val >= max){
            goodNodes++;
        }
        dfs(root.left, Math.max(max, root.val));
        dfs(root.right, Math.max(max, root.val));
    }

    public int goodNodes(TreeNode root) {

        // we use DFS
        // when we reach a node, if its val > max, 
            // we increase goodNode count, 
            // and we update max to send further

        // return goodNode count in the end
        // for recursive fn to be able to update goodNode count, it can be a static var
        // we run that DFS from main fn
        dfs(root, Integer.MIN_VALUE);
        return goodNodes;
    }
}
