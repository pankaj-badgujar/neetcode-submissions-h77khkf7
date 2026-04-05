class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> prefix;

    public MinStack() {
        stack = new Stack<>();
        prefix = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()){
           prefix.push(val); 
           stack.push(val); 
        } else {
            prefix.push(Math.min(val, prefix.peek()));
            stack.push(val);
        }
    }
    
    public void pop() {
        stack.pop();
        prefix.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return prefix.peek();
    }
}
