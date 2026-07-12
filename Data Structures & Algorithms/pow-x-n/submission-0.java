class Solution {
    public double myPow(double x, int n) {
        if (n == 0){
            return 1.0;
        }
        double res = 1;
        for (int i = 0; i < Math.abs(n); i++){
            if (n < 0){
                res /= x; 
            } else {
                res *= x;
            }
        }
        return res;
    }
}
