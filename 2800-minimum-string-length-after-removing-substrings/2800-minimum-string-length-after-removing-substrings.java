class Solution {
    public int minLength(String s) {
        Stack<Character>stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='B' && !stack.isEmpty() && stack.peek()=='A'){
                stack.pop();
            }else if(ch=='D' && !stack.isEmpty() && stack.peek()=='C'){
                 stack.pop();
            }else{
                stack.add(ch);
            }
        }
        return stack.size();
    }
}