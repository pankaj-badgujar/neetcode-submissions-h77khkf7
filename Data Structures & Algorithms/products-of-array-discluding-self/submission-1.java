class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] res = new int[nums.length];
        res[0] = 1;

        // for prefix, lets put 1 in first index
        int prefix = 1;
        int postfix = 1;

        //[1,2,4,6] -> [1,1,]
        // we calculate prefix for each place
        for(int i = 0; i < nums.length - 1; i++){
            res[i+1] = nums[i] * prefix;
            prefix = res[i+1];
        }

        // now we calculate postfix;
        for(int i = nums.length - 1; i >= 0; i--){
            res[i] = res[i] * postfix;
            postfix = nums[i] * postfix;
        }

        // System.out.println(Arrays.toString(res));
        return res;





        // now we calculate postfix starting from right to left
        




        
    }
}  
