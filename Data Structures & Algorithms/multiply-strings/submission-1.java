class Solution {
    public String multiply(String num1, String num2) {
        // zero check
        if (num1.equals("0") || num2.equals("0")) return "0";

        int[] res = new int[num1.length() + num2.length()];
        
        StringBuilder n1 = new StringBuilder(num1).reverse();
        StringBuilder n2 = new StringBuilder(num2).reverse();
        
        
        for (int i = 0; i < n1.length(); i++){
            for (int j = 0; j < n2.length(); j++){
                int digit = (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
                res[i + j] += digit; // we first just add the sum

                res[i + j + 1] += res[i + j] / 10; // put carry to next location
                res[i + j] %= 10; // then retain only units place
            }
        }

        System.out.println("res: " + Arrays.toString(res));

        StringBuilder sb = new StringBuilder();

        for (int i = res.length - 1; i >= 0; i-- ){
            if (sb.length() < 1 && res[i] == 0) continue;
            sb.append(res[i]);
        }
        return sb.toString();
        
    }
}
