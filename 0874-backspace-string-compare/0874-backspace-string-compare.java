class Solution {
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }
    public String build(String s){
        Stack<Character> stack = new Stack<>();
        for(int p=0;p<s.length();p++){
            if(s.charAt(p)!='#')
                stack.push(s.charAt(p));
            else if(!stack.isEmpty()){
                stack.pop();
            }
        }
        return String.valueOf(stack);
    }
}