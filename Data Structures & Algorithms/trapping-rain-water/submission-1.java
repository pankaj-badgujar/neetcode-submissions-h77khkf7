class Solution {
    public int trap(int[] height) {
        int trapped = 0;
        int n = height.length;
        int[] maxLeftArr = new int[n];
        int[] maxRightArr = new int[n];
        
        maxLeftArr[0] = height[0];
        maxRightArr[n-1] = height[n-1];
        
        for(int i = 1; i < n; i++){
            maxLeftArr[i] = Math.max(height[i - 1], maxLeftArr[i-1]);
        }
        for(int i = n - 2; i >= 0; i--){
            maxRightArr[i] = Math.max(height[i + 1], maxRightArr[i+1]);
        }
        // System.out.println(Arrays.toString(maxLeftArr));
        // System.out.println(Arrays.toString(maxRightArr));

        for(int i = 0; i < n; i++){
            int water = Math.min(maxLeftArr[i], maxRightArr[i]) - height[i];
            trapped += water < 0 ? 0 : water;

        }
        return trapped;
    }
}
