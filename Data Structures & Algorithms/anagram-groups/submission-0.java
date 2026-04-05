class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // we need a map of string vs array of strings
        Map<String, List<String>> map = new HashMap<>();
            
        for(String s : strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String candidate = new String(cs);

            List<String> bucket = map.getOrDefault(candidate, new ArrayList<String>());
            bucket.add(s);
            map.put(candidate, bucket);            
        }
        return new ArrayList<>(map.values());
    }
}
