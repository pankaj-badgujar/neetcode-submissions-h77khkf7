class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        int[] ord = new int[26];
        for (int i = 0; i < 26; i++){
            ord[order.charAt(i) - 'a'] = i;
        }
        
        // System.out.println(Arrays.toString(ord));

        for (int i = 0; i < words.length - 1; i++){
            String s1 = words[i];
            String s2 = words[i + 1];

            int j = 0;
            while (true){
                // handle prefix case
                if (j >= s1.length() && j < s2.length()){
                    break; // s1 is shorter after everything else matches
                }
                if (j >= s2.length() && j < s1.length()){
                    return false;
                }

                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);

                if (c1 == c2){
                    j++;
                } else {
                    if (ord[c1 - 'a'] < ord[c2 - 'a']){
                        break;
                    } else {
                        return false;
                    }
                }
            }
            
        }

        return true;
    }
}