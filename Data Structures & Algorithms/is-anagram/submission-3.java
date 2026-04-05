class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            char candidate = s.charAt(i);
            map.put(candidate, map.getOrDefault(candidate, 0) + 1);
        }

        for(int i = 0; i < s.length(); i++){
            char target = t.charAt(i);
            if (!map.containsKey(target) || map.get(target) == 0){
                return false;
            }
            int newValue = map.get(target) - 1;
            if(newValue == 0){
                map.remove(target);
            } else{
            map.put(target, newValue);
            }
        }

        System.out.println(map.toString());
        return map.isEmpty();

    }
}
