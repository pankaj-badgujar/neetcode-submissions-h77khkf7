class TreeNode {
    Map<Character, TreeNode> children = new HashMap<>();
    boolean endOfWord = false;
}
class WordDictionary {
    TreeNode root;

    public WordDictionary() {
        root = new TreeNode();
    }

    public void addWord(String word) {
        TreeNode curr = root;

        for (int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            curr.children.putIfAbsent(c, new TreeNode());
            curr = curr.children.get(c);
        }
        curr.endOfWord = true;
    }

    private boolean searchDfs(TreeNode node, String word, int idx){
        if (idx >= word.length()){
            return false;
        }

        char c = word.charAt(idx);
        if (c == '.'){
            if (idx == word.length() - 1){
               return node.children.values().stream().anyMatch(child -> child.endOfWord);
            }

            for (TreeNode child : node.children.values()){
                // for all children of this node we have to find other chars
                if (searchDfs(child, word, idx + 1)){
                    return true;
                }
            }
            return false;
        } else {
            if (!node.children.containsKey(c)){
                return false;
            }
            TreeNode childNode = node.children.get(c);

            if (idx == word.length() - 1){
                return childNode.endOfWord;
            }

            return searchDfs(childNode, word, idx + 1);
        }
    }

    public boolean search(String word) {
        // do dfs, explore every path
        return searchDfs(root, word, 0);


    }
}
