class Solution {

    List<String> res = new ArrayList<>();
    String[] map = new String[]{null, null, "abc", "def", "ghi", "jkl", "mno","pqrs","tuv","wxyz"}; // it will offer 0 - 9 (we will only use 2 - 9)

    // 34
    // for each of 3 - go to next letter recursively
    // do it until digits end
    // add string to res
    private void dfs(String digits, int idx, StringBuilder sb){

        if (idx >= digits.length()){
            res.add(sb.toString()); // 34, 2, dg
            return;
        }

        int n = digits.charAt(idx) - '0'; // 3
        String pattern = map[n]; // def
        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i); // d, e ,f
            sb.append(c);
            dfs(digits, idx + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public List<String> letterCombinations(String digits) {
        if (digits.length() < 1){
            return res;
        }
        dfs(digits, 0, new StringBuilder());
        return res;
    }
}
