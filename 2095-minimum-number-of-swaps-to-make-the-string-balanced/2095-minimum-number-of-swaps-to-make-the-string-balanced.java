class Solution {
    public int minSwaps(String s) {
        Stack<Character>stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='['){
                stack.push(ch);
            }else{
                if(!stack.isEmpty())
                   stack.pop();
            }
        }
        return (int)Math.ceil((double)stack.size()/2);

    }
}