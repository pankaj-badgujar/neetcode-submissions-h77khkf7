class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        // we use a stack, and maintain a map of temp vs their index.

        // iterate over temps. if stack is empty, put temp in stack, as well as in map.
        // and in res we put 0 for that index;
        // if stack is not empty, then peek the top
        // if top is less than curr temp, which means we have warmer
        // we check map and put in res curr index - their index(map value)


        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        int[] res = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            res[i] = 0;
            int currTemp = temperatures[i];

            while(!stack.isEmpty() && stack.peek() < currTemp){
                // we found warmer
                stack.pop();
                int topIdx = indexStack.pop();
                res[topIdx] = i - topIdx; 
            }
            stack.push(currTemp);
            indexStack.push(i);
        };
        return res;
    }
}
