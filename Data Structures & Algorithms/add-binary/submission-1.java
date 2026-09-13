class Solution {
    public String addBinary(String a, String b) {
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();

        int i = 0;
        int c = 0;
        StringBuilder res = new StringBuilder();

        while (i < a.length() || i < b.length()){
            int ac = i < a.length() ? a.charAt(i) - '0' : 0;
            int bc = i < b.length() ? b.charAt(i) - '0' : 0;

            int sum = ac + bc + c;

            switch (sum){
                case 0: 
                    res.append('0'); 
                    c = 0;
                    break;
                case 1: 
                    res.append('1'); 
                    c = 0;
                    break;
                case 2: 
                    res.append('0'); 
                    c = 1;
                    break;
                case 3: 
                    res.append('1'); 
                    c = 1;
                    break;
                default:
                    break;

            }
            i++;
        }
        if (c > 0){
            res.append(c);
        }
        return res.reverse().toString();
    }
}