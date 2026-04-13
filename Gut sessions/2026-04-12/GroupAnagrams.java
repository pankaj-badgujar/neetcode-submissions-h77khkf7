import java.util.*;

/**
 
Problem 1 — Arrays & Hashing

Group Anagrams
Given an array of strings strs, group the anagrams together. You can return the answer in any order.
Input:  strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Input:  strs = [""]
Output: [[""]]

Input:  strs = ["a"]
Output: [["a"]]
Constraints:

1 <= strs.length <= 10^4
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters only
 */
public class GroupAnagrams {

    private static List<List<String>> solution(String[] strs){
        List<List<String>> res = new ArrayList<>();

        // lets just sort each string, and check if its in map
        // if it is, store its value, or else add it as a key

        Map<String, ArrayList<String>> map = new HashMap<>();
        for(String s : strs){
            char[] sc =  s.toCharArray();
            Arrays.sort(sc);
            String sorted = new String(sc);
            map.computeIfAbsent(sorted, k -> new ArrayList<String>()).add(s);
        }

        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) throws Exception{
        String[] strs1 = new String[]{"eat","tea","tan","ate","nat","bat"};
        String[] strs2 = new String[]{""};
        String[] strs3 = new String[]{"a"};

        System.out.println(solution(strs1).toString());
        
        // List<List<String>> result2 = solution(strs2);
        // List<List<String>> result3 = solution(strs3);


    }
    
}
