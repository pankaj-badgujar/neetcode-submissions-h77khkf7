class Solution {
    public int jump(int[] nums) {
        // [2,3,1,1,4]

        int res = 0;
        int l = 0, r = 0;

        while (r < nums.length - 1){
            int farthest = 0;
            for (int i = l; i <= r; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            res++;
        }
        return res;
    }
}
