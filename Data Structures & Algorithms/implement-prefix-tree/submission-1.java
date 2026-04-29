class TreeNode {
    Map<Character, TreeNode> map;
    boolean endOfWord;

    public TreeNode(){
        this.map = new HashMap<>();
        this.endOfWord = false;
    }
}
class PrefixTree {
    TreeNode root;

    public PrefixTree() {
         root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode curr = root;
        
        for (int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if (curr.map.get(c) == null){
                curr.map.put(c, new TreeNode());
            } 
            curr = curr.map.get(c);
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TreeNode curr = root;

        for (int i = 0 ; i < word.length(); i++){
            char c = word.charAt(i);
            if (curr.map.get(c) == null) {
                return false;
            }
            curr = curr.map.get(c);
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TreeNode curr = root;

        for (int i = 0 ; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if (curr.map.get(c) == null) {
                return false;
            }
            curr = curr.map.get(c);
        }
        return true;
    }
}
