class Solution {
    public String longestPalindrome(String s) {
        int resIdx = 0;
        int resLen = 0;

        for (int i = 0; i < s.length(); i++){
            // odd length
            int l = i, r = i;
            while (
                l >=0 &&
                r < s.length() &&
                s.charAt(l) == s.charAt(r)
            ){
                int subsLen = r - l + 1;
                if (subsLen > resLen){
                    resIdx = l;
                    resLen = subsLen;
                }
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (
                l >=0 &&
                r < s.length() &&
                s.charAt(l) == s.charAt(r)
            ){
                int subsLen = r - l + 1;
                if (subsLen > resLen){
                    resIdx = l;
                    resLen = subsLen;
                }
                l--;
                r++;
            }
        }

    return s.substring(resIdx, resIdx + resLen);   
    }
}
