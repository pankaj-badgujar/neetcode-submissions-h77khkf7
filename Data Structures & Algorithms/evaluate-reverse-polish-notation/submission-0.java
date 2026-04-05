class Solution {
    public int evalRPN(String[] tokens) {

        // put each token into the stack unless its an operator.
        // if operator, then pull out first and second and do operation, put result in stack

        // do this until tokens end, return stack result.

        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            try{
                stack.push(Integer.parseInt(token));
            } catch (Exception e){
                // its an operand
                int y = stack.pop();
                int x = stack.pop();
                
                switch(token){
                    case "+":
                        stack.push(x + y);
                        break;
                    case "-":
                        stack.push(x - y);
                        break;
                    case "*":
                        stack.push(x * y);
                        break;
                    case "/":
                        stack.push(x / y);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();        
    }
}
