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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; 
        // BFS
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        
        int count = 0;
        while(!queue.isEmpty()){
            int allNodesAtLevel = queue.size();
            for(int i = 0; i < allNodesAtLevel; i++){
                TreeNode node = queue.removeFirst();
                
                if (node.left != null) queue.addLast(node.left);
                if (node.right != null) queue.addLast(node.right);
            }
            count++;
        }
        return count;
    }
}
