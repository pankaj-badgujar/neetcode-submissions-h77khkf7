class Solution {

    public int maxArea(int[] heights) {
        int water = 0;

        // only move left or right if the water it offers is more than current
        int l = 0, r = heights.length - 1;

        while (l < r){
            int width = r - l;
            int height = Math.min(heights[l], heights[r]);

            water = Math.max(water, width * height);
            
            if (heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }
        return water;
    }
}
