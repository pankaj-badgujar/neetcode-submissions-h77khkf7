class Solution {
    private boolean isAlphaNumeric(char c){
        return (c >= '0' &&  c <= '9') ||
	    (c >= 'A' &&  c <= 'Z') ||
		(c >= 'a' &&  c <= 'z');

    }
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        for(int l = 0, r = s.length() - 1; r > l; l++, r--){

            while(l < r && !isAlphaNumeric(s.charAt(l))){
                l++;
            }
            while(r > l && !isAlphaNumeric(s.charAt(r))){
                r--;
            }
            
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
        }
        return true;
        
    }
}
