class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // we start at either ends
        // if their total is target, we return indices
        // else we check l, r-1
        // if that goes over that target, we move r back.
        // if that is under, we move l forward
        // each time we check if new l and r make the target.
        int l = 0, r = numbers.length - 1;
        while (  l < r ){
            if(numbers[l] + numbers[r] == target){
                return new int[]{l+1 , r+1};
            }
            if(numbers[l+1] + numbers[r] > target){
                r--;
            } else {
                l++;
            }
        }
        return new int[0];
    }
}
