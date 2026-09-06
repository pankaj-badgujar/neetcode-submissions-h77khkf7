class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] ord = new int[26];
        for (int i = 0; i < 26; i++) {
            ord[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (!inOrder(words[i], words[i + 1], ord)) {
                return false;
            }
        }
        return true;
    }

    private boolean inOrder(String s1, String s2, int[] ord) {
        int minLen = Math.min(s1.length(), s2.length());
        for (int j = 0; j < minLen; j++) {
            char c1 = s1.charAt(j);
            char c2 = s2.charAt(j);
            if (c1 != c2) {
                return ord[c1 - 'a'] < ord[c2 - 'a'];
            }
        }
        // all matched up to minLen, so shorter (or equal) must come first
        return s1.length() <= s2.length();
    }
}