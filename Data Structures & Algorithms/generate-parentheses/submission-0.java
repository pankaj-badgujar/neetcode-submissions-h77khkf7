class Solution {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public void dfs(int n, int open, int close){

        // we have a full and valid string
        if (open == close && open == n){
            res.add(sb.toString());
            return;
        }

        // we have two options from here - 

        // go with open
        if (open < n){
            sb.append('(');
            dfs(n, open + 1, close);
            // remove last added char
            sb.deleteCharAt(sb.length() - 1);
        }

        // or go with close if we can
        if (close < open){
            sb.append(')');
            dfs(n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0);

        return res;
    }
}
