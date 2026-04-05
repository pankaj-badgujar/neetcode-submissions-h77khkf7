class Solution {
    private int getHrsByK(int[] piles, int k){
        int hrs = 0;
        for(int i = 0; i < piles.length; i++){
            hrs += Math.ceil((double)piles[i]/ k);
        }
        return hrs;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int minK = r;

        while(l <= r){
            int k = l + (r - l)/2;
            int hrs = getHrsByK(piles,k);
            if(hrs <= h){
                // we can do better
                minK = Math.min(minK,k) ;
                r = k - 1;
            } else if(hrs > h) {
                l = k + 1;
            }
        }
        return minK;
    }
}
