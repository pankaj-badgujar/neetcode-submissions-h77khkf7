import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
Problem 2 — Two Pointers

3Sum
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, j != k, and nums[i] + nums[j] + nums[k] == 0. 
The solution set must not contain duplicate triplets.
Input:  nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

Input:  nums = [0,1,1]
Output: []

Input:  nums = [0,0,0]
Output: [[0,0,0]]
Constraints:

3 <= nums.length <= 3000
-10^5 <= nums[i] <= 10^5
*/

public class ThreeSum {

    public static List<List<Integer>> solution(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        

        for(int i = 0; i <= nums.length - 3; i++){
            // skip duplicaate values of i
            if (i > 0 && nums[i] == nums[i-1] ){
                continue;
            }
            
            int j = i+1;
            int k = nums.length - 1;

            while (j < k){
                int total = nums[i] + nums[j] + nums[k];
                if (total == 0){
                    // found triplet
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while(nums[j] == nums[j + 1]){
                        j++;
                    }
                    while(k == k - 1){
                        k--;
                    }
                    j++;
                    k--;
                } else if (total > 0){
                    k--;
                } else {
                    j++;
                }
            }
        }
        return result;
    }

    public static void main (String[] args){
        List<List<Integer>> res = solution(new int[]{-1,0,1,2,-1,-4});
        System.out.println(res.toString());
    }
    
}