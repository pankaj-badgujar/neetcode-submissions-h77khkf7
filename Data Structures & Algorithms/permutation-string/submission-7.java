class Solution {
    public boolean checkInclusion(String s1, String s2) {
        //abc
        //abxyzabc
        if (s2.length() < s1.length()) return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        //master map
        for(char c : s1.toCharArray()){
            s1Freq[c - 'a']++;
        }
        // we do this only once for initial slave map
        for (int i = 0; i <= s1.length() - 1; i++){
            char c = s2.charAt(i);
            s2Freq[c - 'a']++;
        }
        int matches = 0;

        //calculate initial matches
        for (int i = 0 ; i < 26; i++){
            if(s1Freq[i] == s2Freq[i]){
                matches++;
            }
        }

        int l = 0;
        int index;
        for (int r = s1.length(); r < s2.length(); r++){
            if (matches == 26){
                return true;
            }
            // we have visited new r now;
            index = s2.charAt(r) - 'a';
            s2Freq[index]++;

            if(s1Freq[index] == s2Freq[index]){
                matches++;
            } else if(s1Freq[index] + 1 == s2Freq[index]){
                matches--;
            }
            
            // now lets do this for l that we removed
            index = s2.charAt(l) - 'a';
            s2Freq[index]--;

            if(s1Freq[index] == s2Freq[index]){
                matches++;
            } else if(s1Freq[index] - 1 == s2Freq[index]){
                matches--;
            }
            l++;
        }
        return matches == 26;
    }
}
