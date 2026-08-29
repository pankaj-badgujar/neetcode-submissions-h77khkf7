class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // we maintain a hashmap of key (sorted string act as identifier) -> list[]

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs); // nlogn
            map.computeIfAbsent(key, k -> new ArrayList<String>()).add(s);
        }
        
        return new ArrayList<>(map.values());
        
    }
}
