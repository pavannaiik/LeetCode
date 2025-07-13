class MinStack {
    Node stack;
    public MinStack() {
        stack = new Node(-1, -1);
        stack.next = null;
    }
    
    public void push(int val) {
        Node newNode;
        if(stack.next==null){
            newNode = new Node(val, val);
            
        }else{
            newNode = new Node(Math.min(val, stack.min), val);
        }
        newNode.next = stack;
        stack = newNode;
    }
    
    public void pop() {
        if(stack.next == null) return;
        else{
            Node nextNode = stack.next;
            stack = nextNode;
        }
    }
    
    public int top() {
        return stack.val;
    }
    
    public int getMin() {
        return stack.min;
    }
}
class Node{
    int min;
    int val;
    Node next;
    Node(int min, int val){
        this.min = min;
        this.val = val;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */