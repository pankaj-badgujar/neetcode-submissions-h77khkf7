class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);

            // if we have closing brackets dont add to stack


            if( c == '}' || c == ')' || c == ']'){
                
                if( stack.isEmpty() || (c == '}' && stack.pop() != '{' ||
                    c == ')' && stack.pop() != '(' ||
                    c == ']' && stack.pop() != '[' )
                ){
                    return false;
                }
            } else {
        
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
