class Solution {
    public int evalRPN(String[] tokens) {
        int ans=0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s = tokens[i];
            if(s.equals("+") || s.equals("-")||s.equals("*")||s.equals("/")){
                int a = stack.peek();
                stack.pop();
                int b= stack.peek();
                stack.pop();
                if(s.equals("+")) stack.push(b+a);
                else if(s.equals("-")) stack.push(b-a);
                else if(s.equals("*")) stack.push(b*a);
                else stack.push(b/a);
            }else stack.push(Integer.parseInt(s));
        }
        return stack.peek();
        
    }
}