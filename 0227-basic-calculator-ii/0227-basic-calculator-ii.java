class Solution {
    public int calculate(String s) {
        Stack<Integer>stack = new Stack<>();
        char operator = '#';
        int curVal = -1;
        int i=0, j= s.length();
        while(i < j){
            char ch = s.charAt(i);
            if(Character.isWhitespace(ch) ) {
                i++;
                continue;
            }
            if(Character.isDigit(ch)){
                int t =0;
                while(i< j && Character.isDigit(s.charAt(i))){
                    t = t * 10 + s.charAt(i)-'0';
                    i++;
                }
                curVal = t;
                i--;
            }else{
                operator = ch;
                i++;
                continue;
            }

            if(operator == '#' && curVal !=-1){
                stack.push(curVal);
            }else if(operator=='+'){
                stack.push(curVal);
            }else if(operator == '-'){
                stack.push(-curVal);
            }else if(operator=='*' ){
                int top = stack.pop();
                stack.push(top * curVal);
            }else {
                int top = stack.pop();
                stack.push(top / curVal);
            }
            curVal =0;
            i++;
        }
        int result = 0;
        while(!stack.isEmpty()) result += stack.pop();
        return result;
    }
}