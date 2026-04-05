class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        for(int i = 0 ; i < heights.length; i++){
            int h = heights[i];

            // for w, we check left and right bars
            int lw = 0;
            int rw = 0;

            for(int l = i - 1; l >= 0; l--){
                if(heights[l] >= h){
                    lw++;
                } else{
                    break;
                }
            }
            
            
            for(int r = i + 1; r < heights.length; r++){
            
                if(heights[r] >= h){
                    rw++;
                } else {
                    break;
                }
            }
            System.out.printf("lw: %d, rw: %d\n", lw, rw);
            maxArea = Math.max(h * (lw + rw + 1), maxArea);
        }
        return maxArea;
    }
}
