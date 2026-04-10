class Solution {
    private boolean matchFreqMaps(Map<Character, Integer> m1, Map<Character, Integer> m2){
        for(Map.Entry e : m1.entrySet()){
            char m1Key = (char)e.getKey();
            if(m2.get(m1Key) != e.getValue()){
                return false;
            }
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> m2 = new HashMap<>();
        Map<Character, Integer> m1 = new HashMap<>();

        for(char c : s1.toCharArray()){
            m1.merge(c, 1, Integer::sum);
        }


        for(int l = 0, r = 0; r < s2.length(); r++){
            if (r > l + s1.length() - 1){
                char lc = s2.charAt(l);
                m2.merge(lc, -1, Integer::sum);
                if(m2.get(lc) == 0){
                    m2.remove(lc);
                }
                l++;
            }
            char rc = s2.charAt(r);
            m2.merge(rc, 1, Integer::sum);

            if(r - l + 1 == s1.length()){
                if (m1.equals(m2)){
                    return true;
                }
            }
        }
        return false;        
    }
}
