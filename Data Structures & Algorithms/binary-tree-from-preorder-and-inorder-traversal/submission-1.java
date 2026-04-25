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

    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // we can do this recursively
        // we know that root is 0th element of preorder
        // we build the root node, then we say makeTree on the left arr and rightArr
        // for each arr, their 1st element is their root
        if (preorder.length < 1 || inorder.length < 1){
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        // so we find that in inorder arr, the left is left substree, right is rightsubtree
        int mid = 0;
        while (inorder[mid] != preorder[0]){
            mid++;
        }
        // new inorders
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid + 1);
        int[] leftSubArray = Arrays.copyOfRange(inorder, 0, mid);

        // new preorders 
        int[] rightPreorder = Arrays.copyOfRange(preorder, mid + 1, inorder.length);
        int[] rightSubArray = Arrays.copyOfRange(inorder, mid + 1, inorder.length);


        root.left = buildTree(leftPreorder,leftSubArray);
        root.right = buildTree(rightPreorder,rightSubArray);
        
        return root;
    }
}
