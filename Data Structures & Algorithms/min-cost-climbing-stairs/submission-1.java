class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int twoJump = 0, oneJump = 0;

        for (int i = cost.length - 1; i >= 0; i--){
            int newCost = cost[i] + Math.min(oneJump, twoJump);
            twoJump = oneJump;
            oneJump = newCost;
        }
        return Math.min(oneJump, twoJump);
    }
}
