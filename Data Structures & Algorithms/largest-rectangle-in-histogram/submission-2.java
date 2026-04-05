class Solution {
    public int largestRectangleArea(int[] heights) {
        // we make sure we maintain the elements in stack in increasing order of heights only
        // so for every new h, we check if : h < top of stack 
        // if h is less, then top of stack's right has ended, calculate its area.
        // now check h with new top and keep repeating.
        // if top is less than h, we add h.

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i <= heights.length; i++){
            int h = (i == heights.length? 0 : heights[i]);
            
            while(!stack.isEmpty() && h < heights[stack.peek()]){
                int prevIdx = stack.pop();
                int leftIdx = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftIdx - 1;
                maxArea = Math.max(maxArea, heights[prevIdx] * width);
            }    
            stack.push(i);
        }
        return maxArea;
    }
}
