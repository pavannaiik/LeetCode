class Solution {
    public boolean isValid(String s) {
        Stack<Character>stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stack.add(')');
            }else if(ch=='{'){
                stack.add('}');
            }else if(ch=='['){
                stack.add(']');
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if(stack.peek()==ch){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}