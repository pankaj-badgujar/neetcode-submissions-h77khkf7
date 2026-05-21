class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> substrings = new ArrayList<>();

    private boolean isPalindrome(String s, int l, int r){
        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private void backtrack(String s, int i){
        if (i >= s.length()){
            res.add(new ArrayList<>(substrings));
            return;
        }

        for (int j = i; j < s.length(); j++){
            if (isPalindrome(s, i, j)){
                substrings.add(s.substring(i,j + 1));
                backtrack(s, j+1);
                substrings.remove(substrings.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return res;
    }
}
