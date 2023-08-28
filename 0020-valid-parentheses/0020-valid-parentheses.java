class Solution {
    public boolean isValid(String s) {
        if(s.length()==1) return false;
        Stack<Character>stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' ){
                stack.push(')');
            }else if(ch == '{'){
                stack.push('}');
            }else if(ch == '['){
                stack.push(']');
            }else{
                if(stack.size()==0 || stack.peek()!=ch){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }
        if(stack.size()!=0) return false;
        return true;
    }
}