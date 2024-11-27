class Solution {
    public boolean isValid(String s) {
        if(s.length()==1) return false;
        Stack<Character>stack= new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(') stack.push(')');
            else if(ch=='{') stack.push('}');
            else if(ch=='[') stack.push(']');
            else{
                if(stack.size()==0 || stack.peek()!=ch){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.size()==0;
    }
}