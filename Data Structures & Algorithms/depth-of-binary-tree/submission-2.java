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
    class StackEntry{
        TreeNode node;
        int depth;
        public StackEntry(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public int maxDepth(TreeNode root) {

        Deque<StackEntry> stack = new ArrayDeque<>();
        stack.addLast(new StackEntry(root, 1));
        int depth = 0;
        while(!stack.isEmpty()){
            StackEntry se = stack.removeLast();
            TreeNode node = se.node;
            if(node == null) continue;
            depth = Math.max(depth, se.depth);

            if(node.left != null) stack.addLast(new StackEntry(node.left, se.depth + 1));
            if(node.right != null) stack.addLast(new StackEntry(node.right, se.depth + 1));
        }
        return depth;
    }
}
