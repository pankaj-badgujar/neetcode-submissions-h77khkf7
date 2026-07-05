class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> leftParStack = new ArrayDeque<>();
        Deque<Integer> starStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if (c == '(') leftParStack.push(i);
            else if (c == '*') starStack.push(i);
            else {
                // we have a ')'
                if (!leftParStack.isEmpty()){
                    leftParStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }
        // once all rights are done now check if left and star can work
        while (!leftParStack.isEmpty()){
            if (starStack.isEmpty() || starStack.peek() < leftParStack.peek()){
                return false;
            }
            starStack.pop();
            leftParStack.pop();
        }

        return true;
    }
}
