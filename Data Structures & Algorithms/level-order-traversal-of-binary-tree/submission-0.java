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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null){
            return result;
        }
        
        // we can use BFS. for that we use queue
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        int nodesAtLevel = queue.size();
        List<Integer> currList;

        while(!queue.isEmpty()){
            currList = new ArrayList<>();

            while(nodesAtLevel > 0) {
                TreeNode node = queue.removeFirst();
                nodesAtLevel--;

                currList.add(node.val);
                
                if (node.left != null){
                    queue.addLast(node.left);
                }
                if (node.right != null){
                    queue.addLast(node.right);
                }
            }
            result.add(currList);
            nodesAtLevel = queue.size();
        }
        return result;
    }
}









