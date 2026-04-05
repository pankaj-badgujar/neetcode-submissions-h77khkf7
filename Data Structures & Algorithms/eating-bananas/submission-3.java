class Solution {
    private int getHrsByK(int[] piles, int k){
        int hrs = 0;
        for(int i = 0; i < piles.length; i++){
            int hrsForEachPile = (piles[i] + k -1)/ k;
            hrs += hrsForEachPile;
        }
        return hrs;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int minK = Integer.MAX_VALUE;
        Arrays.sort(piles);

        int max = piles[piles.length - 1];

    
        int l = 1, r = max;

        while(l <= r){
            int k = l + (r - l)/2;


            int hrs = getHrsByK(piles,k);
            System.out.printf("l: %d, r: %d, k: %d, hrs: %d\n", l,r,k, hrs);
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
