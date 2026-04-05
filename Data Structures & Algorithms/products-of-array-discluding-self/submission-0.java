class Solution {
    public int[] productExceptSelf(int[] nums) {
        int productWithoutZero = 1;
        int countOfZeroes = 0;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                countOfZeroes++;
                continue;
            }
            productWithoutZero *= nums[i];
        }
        System.out.println("productWithoutZero: " + productWithoutZero);
        int[] res = new int[nums.length];

        // now, we go through the nums, if the count is more than 1, then all are zero. 
        // else if only 1 is zero, then there we use product and rest is zero
        // else we use product

        
        for(int i = 0; i < nums.length; i++){
            if (countOfZeroes > 1){
                res[i] = 0;
            } else if (countOfZeroes == 1){
                if(nums[i] == 0){
                    res[i] = productWithoutZero;
                } else {
                    res[i] = 0;
                }
            } else {
                res[i] = productWithoutZero / nums[i];
            }
        }
        return res;
    }
}  
