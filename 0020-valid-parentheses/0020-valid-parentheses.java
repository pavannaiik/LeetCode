class Solution {
    public boolean isValid(String s) {
     
        HashMap<Character, Character> hm = new HashMap<>();
        
        hm.put(')','(');
        hm.put('}','{');
        hm.put(']','[');

        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else{
                if( stack.isEmpty() || stack.peek() != hm.get(c))
                    return false;
                    stack.pop();
                }
            
            
            }
            return stack.isEmpty();
            
    }
}