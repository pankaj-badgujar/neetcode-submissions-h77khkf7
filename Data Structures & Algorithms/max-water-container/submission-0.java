class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;

        int l = 0, r = heights.length - 1;

        while(l < r){
            int width = r - l;
            int height = Math.min(heights[l], heights[r]);
            int area = width * height;

            maxArea = Math.max(area, maxArea);
            if(heights[l] < heights[r]){
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
