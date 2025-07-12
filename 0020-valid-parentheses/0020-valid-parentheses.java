class Solution {
    public boolean isValid(String s) {
        
        Stack<Character>stack = new Stack<>();
        for(Character ch:s.toCharArray()){
            if(ch == '{'){
                stack.add('}');
            }else if(ch == '['){
                stack.add(']');
            }else if(ch == '('){
                stack.add(')');
            }else{
                if(stack.isEmpty() || stack.peek() != ch){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}