class TreeNode {
    Map<Character, TreeNode> map;
    boolean isComplete;

    public TreeNode(){
        this(false);
    }

    public TreeNode(boolean isComplete){
        this.map = new HashMap<>();
        this.isComplete = isComplete;
    }
}

class PrefixTree {
    TreeNode root;

    public PrefixTree() {
        root = new TreeNode();
    }

    private void insertDfs(TreeNode node, String word, int idx){
        if (idx >= word.length()){
            return;
        }

        char c = word.charAt(idx);
        boolean isLast = idx == word.length() - 1;
        TreeNode childNode;

        if (node.map.get(c) != null){
           childNode = node.map.get(c);
           
           if (isLast){
            childNode.isComplete = isLast;
           }
        } else {
            childNode = new TreeNode(isLast);
            node.map.put(c, childNode);
        }
        insertDfs(childNode, word, idx + 1);
    }

    public void insert(String word) {
        if (word == null || word.length() < 1){
            return;
        }

        insertDfs(root, word, 0);

        // when a word is sent
        // we take first char, then check hashmap to find the node
            // if node exist, we recursively go to it, then check its hash table for second char
        // if node does not exist we add the node and maintain its kv in parent's map
        // by default we set boolean false
        // then on that node thats last we mark boolean as complete.

    }

    private boolean searchDfs(TreeNode node, String word, int idx, boolean onlyCheckPrefix){
        if (idx >= word.length()){
            return false;
        }

        char c = word.charAt(idx);
        boolean isLast = idx == word.length() - 1;

        if (node.map.get(c) == null){
            return false;
        } else {
           TreeNode childNode = node.map.get(c);

           if (isLast) {
            return onlyCheckPrefix ? true : childNode.isComplete;
           }

           return searchDfs(childNode, word, idx + 1, onlyCheckPrefix);
        }
    }

    public boolean search(String word) {
        // for search we again traverse the tree as per its map
        // if node is not found we return false.
        // if at the last char, we find boolean true, we return true
        // else we return false;
        return searchDfs(root, word, 0, false);

    }

    public boolean startsWith(String prefix) {
        // doesnt check boolean, just finds if the path exists, 
        // if prefix ends we return true
        // else we return false
        return searchDfs(root, prefix, 0, true);

    }
}
