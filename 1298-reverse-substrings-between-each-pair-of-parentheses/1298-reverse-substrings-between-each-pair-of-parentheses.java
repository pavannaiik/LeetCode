class Solution {
    public String reverseParentheses(String s) {
        Stack<Character>stack = new Stack<>();
        int leftBrackets =0;
        for(char c:s.toCharArray()){
            if(c !=')'){
                if(c=='(')
                  leftBrackets++;
                stack.push(c);
            }else if(leftBrackets>0){
                StringBuilder sb = new StringBuilder();
                while(stack.size() >0 && stack.peek()!='('){
                    sb.append(stack.pop());
                }
                if(stack.size() >0 && stack.peek()=='('){
                    leftBrackets--;
                    stack.pop();
                }
                for(int i=0;i<sb.length();i++){
                    stack.push(sb.charAt(i));
                }
            }
        }
         StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}