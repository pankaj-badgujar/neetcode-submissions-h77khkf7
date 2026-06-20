class Solution {
    List<String> wordDict;
    String s;
    Map<Integer, Boolean> dp;

    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        this.s = s;
        dp = new HashMap<>();

        // return false;

        return dfs(0);
    }

    private boolean dfs(int i){
        if (i >= s.length()){
            return true;
        }
        
        // if i is already in the map, means its checked
        if (dp.containsKey(i)){
            return dp.get(i);
        }
        
        // else its not checked, so we check and update the map
        for (String word : wordDict){
            if (s.length() - i < word.length()) continue;
            String ss = s.substring(i, i + word.length());

            // System.out.println("i: " + i);
            // System.out.println("word: " + word);
            // System.out.println("ss: " + ss);
            
            if (ss.equals(word)){
               if (dfs(i + word.length())){
                    dp.put(i, true);
                    return true;
               }
            }
        }
        dp.put(i, false);
        return false;
    }
}
