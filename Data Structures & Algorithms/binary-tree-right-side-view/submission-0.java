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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        // we want to do BFS, and for each level, we want to store only the last val in our result
        // basically we store levelCount - 1, but we still iterate through other nodes 
        // cause we want their children in the queue

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        while (!queue.isEmpty()){
            int nodesAtLevel = queue.size();

            for (int i = 0; i < nodesAtLevel; i++){
                TreeNode node = queue.removeFirst();
                
                // we definitely want to add children
                if (node.left != null){
                    queue.addLast(node.left);
                }
                if (node.right != null){
                    queue.addLast(node.right);
                }
                // we want to store val in result only if this is the last node of this level
                if (i == nodesAtLevel - 1){
                    result.add(node.val);
                }
            }
        }
        return result;
    }
}



