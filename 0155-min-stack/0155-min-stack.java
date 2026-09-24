class MinStack {

    Stack<Long> s = new Stack<>();
    long minVal;

    public MinStack() {
        
    }
    
    public void push(int value) {
        if (s.isEmpty()) {
            s.push((long)value);
            minVal = value;
        } 
        else if (value < minVal) {
            s.push(2L * value - minVal);
            minVal = value;
        }
        else {
            s.push((long)value);
        }
    }
    
    public void pop() {
        if (s.peek() < minVal) {
            minVal = 2L * minVal - s.peek();
        }
        s.pop();
    }
    
    public int top() {
        if (s.peek() < minVal) {
            return (int)minVal;
        }
        return s.peek().intValue();
    }
    
    public int getMin() {
        return (int)minVal;
    }
}
/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */