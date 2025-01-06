class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int result = 0;
        int sign = 1;  // 1 for positive, -1 for negative

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');  // Convert char to int
            } else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;  // Set sign for next number
            } else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;  // Set sign for next number
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * num;
                num = 0;
                result *= stack.pop();  // Pop sign
                result += stack.pop();  // Pop previous result
            }
        }

        result += sign * num;  // Add the last number
        return result;
    }
}