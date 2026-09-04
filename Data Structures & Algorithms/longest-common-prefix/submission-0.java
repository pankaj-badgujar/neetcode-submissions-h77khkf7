class Trie {
    char c;
    Map<Character, Trie> children;

    public Trie(char c){
        this.c = c;
        children = new HashMap<>();
    }
}
class Solution {
    public String longestCommonPrefix(String[] strs) {

        String smallest = strs[0];

        if (strs.length < 2){
            return smallest;
        }


        for (String s : strs){
            if (s.length() < smallest.length()){
                smallest = s;
            }
        }

        for (String s : strs){
            if (s.startsWith(smallest)) continue;
            // else we should reduce smallest by 1
            while (!s.startsWith(smallest)){
                smallest = smallest.substring(0, smallest.length() - 1);
                if (smallest.length() < 1){
                    return "";
                }
            }
        }
        return smallest;
    }
}