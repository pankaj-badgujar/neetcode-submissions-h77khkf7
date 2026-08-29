class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        Map<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            char sc = s.charAt(i);
            freq.merge(sc, 1, Integer::sum);
            if (freq.get(sc) == 0){
                freq.remove(sc);
            }

            char tc = t.charAt(i);
            freq.merge(tc, -1, Integer::sum);

            if (freq.get(tc) == 0){
                freq.remove(tc);
            }

        }

        return freq.size() == 0;
    }
}
