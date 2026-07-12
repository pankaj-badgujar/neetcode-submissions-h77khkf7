class Solution {
    Set<Integer> seen = new HashSet<>();

    public boolean isHappy(int n) {
        return dfs(n);
    }

    private boolean dfs(int n){
        if (n == 1){
            return true;
        }
        if (seen.contains(n)){
            return false;
        }

        seen.add(n);

        int sum = 0;
        
        while ( n > 0){
            
            sum += (n % 10) * (n % 10);
            n = n / 10;
            
        }
        return dfs(sum);
    }
}
