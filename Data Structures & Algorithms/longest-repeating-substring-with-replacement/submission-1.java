class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
        
        int l = 0;
        int r = 0;
        int maxFreq = 0;
        
        while (r < s.length()){
            char rc = s.charAt(r);
            map.merge(rc, 1, Integer::sum);
            maxFreq = Math.max(maxFreq, map.get(rc));
            
            while ((r - l + 1) - maxFreq > k){
                char lc = s.charAt(l);
                map.merge(lc, -1, Integer::sum);
                l++;
            }
            longest = Math.max(longest, r - l + 1);
            r++;
        }

        return longest;        
    }
}





