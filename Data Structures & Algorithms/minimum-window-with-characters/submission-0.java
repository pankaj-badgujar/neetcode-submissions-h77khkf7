class Solution {
    public String minWindow(String s, String t) {
        if(t == "") return "";

        Map<Character, Integer> tMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();

        // create t map
        for(char c : t.toCharArray()){
            tMap.merge(c, 1, Integer::sum);
        }
        //ADOBECODEBANC
        int have = 0, need = tMap.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            windowMap.merge(c, 1, Integer::sum);

            if(tMap.containsKey(c) && windowMap.get(c).equals(tMap.get(c))){
                have++;
            }
                    
            while(have == need){
                if(r - l + 1 < resLen){
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                // pop from the left
                char lc = s.charAt(l);
                windowMap.merge(lc, -1, Integer::sum);
                if(tMap.containsKey(lc) && windowMap.get(lc) < tMap.get(lc)){
                    have--;
                }
                l++;
            }
        }
        return resLen != Integer.MAX_VALUE ? s.substring(res[0], res[1] + 1) : "";
    }
}
