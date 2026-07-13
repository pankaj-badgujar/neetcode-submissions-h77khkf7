class Solution {
    public int reverse(int x) {
        boolean isNeg = x < 0;
        x = Math.abs(x);
        long sum = 0;

        while (x > 0){
            sum = (sum * 10) + (x % 10);
            x = x / 10;
        }
        
        return (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE) ? 0 : (isNeg ? (int) sum * -1 : (int) sum);
        
    }
}
