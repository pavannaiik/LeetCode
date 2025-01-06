class Solution {
    public int calculate(String s) {
        Stack<Integer>stack = new Stack<>();
        int n = s.length();
        int curNumber =0;
        char operation = '+';
        for(int i=0;i<n;i++){
            char curChar = s.charAt(i);
            if(Character.isDigit(curChar)){
                curNumber = (curNumber * 10) +( curChar-'0');
            }
            if(!Character.isDigit(curChar) && !Character.isWhitespace(curChar) || i == n-1){
                if(operation =='+'){
                    stack.push(curNumber);
                }else if(operation =='-'){
                    stack.push(-curNumber);
                }else if(operation =='*'){
                    stack.push(stack.pop() * curNumber);
                }else if(operation =='/'){
                    stack.push(stack.pop() / curNumber);
                }
                operation=curChar;
                curNumber=0;
            }
        }
        int result=0;
        while(!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}