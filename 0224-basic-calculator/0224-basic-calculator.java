class Solution {
    public int calculate(String s) {
        int result =0;
        int i=0, j= s.length();
        int num=0;
        Stack<Integer>stack = new Stack<>();
        int sign =1;
        stack.push(sign);
        while(i < j){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10 + ch - '0';
            }else if(ch == '+' || ch == '-'){
                result += sign * num;
                sign = stack.peek() * ((ch=='+')?1:-1);
                num = 0;
            }else if(ch == '(') stack.push(sign);
            else if(ch == ')') stack.pop();
            i++;
        }
        return result + (num * sign);
    }
}