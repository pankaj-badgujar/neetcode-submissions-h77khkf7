class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // we maintain a hashmap of key (sorted string act as identifier) -> list[]

        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (String s : strs){
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs); // nlogn
            map.computeIfAbsent(key, k -> new ArrayList<String>()).add(s);
        }

        for (List<String> list : map.values()){
            res.add(list);
        }
        
        return res;
        
    }
}
