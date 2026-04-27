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

public class Codec {
    List<String> list = new ArrayList<>();

    private void serializeDfs(TreeNode root){
        // we do dfs and create a preorder traversal string
        if (root == null) {
            list.add("N");
            return;
        } 
        list.add(root.val + "");
        
        serializeDfs(root.left);
        serializeDfs(root.right);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null){
            return null;
        }
        
        serializeDfs(root);
        return String.join(",", list);
    }

    int idx = 0;
    private TreeNode deserializeDfs(String[] nodes){
        
        if (nodes[idx].equals("N")){
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[idx]));
        idx++;
        
        if (idx < nodes.length){
            node.left = deserializeDfs(nodes);
        } 
        if (idx < nodes.length){
            node.right = deserializeDfs(nodes);
        } 

        return node;
    }
    

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println("data: "+ data);
        if (data == null || data.length() < 1){
            return null;
        }

        String[] nodes = data.split(",");
        return deserializeDfs(nodes);
    }
}
