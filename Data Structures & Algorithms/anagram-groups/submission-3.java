class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // we maintain a hashmap of key (sorted string act as identifier) -> list[]

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs){
            int[] freq = new int[26];
            for (char c : s.toCharArray()){
                freq[c - 'a']++;
            }
            
            String key = Arrays.toString(freq);
            map.computeIfAbsent(key, k -> new ArrayList<String>()).add(s);
        }
        
        return new ArrayList<>(map.values());
        
    }
}
