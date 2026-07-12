class Solution {

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (!seen.contains(n)){
            seen.add(n);
            n = sumOfSquares(n);
            if (n == 1){
                return true;
            }
        }
        return false;
    }

    private int sumOfSquares(int n){

        int sum = 0;
        
        while ( n > 0){
            
            sum += (n % 10) * (n % 10);
            n = n / 10;
            
        }
        return sum;
    }
}
