class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        
        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            int l = i + 1, r = nums.length - 1;

            // now do two sum
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if(sum < 0){
                    // negative heavy,
                    l++;
                } else if(sum > 0){
                    // positive heavy
                    r--;
                } else{
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                    l++;
                    r--;

                    while(l < r && nums[l] == nums[l - 1]){
                        l++;
                    }
                    while(l < r && nums[r] == nums[r + 1]){
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
