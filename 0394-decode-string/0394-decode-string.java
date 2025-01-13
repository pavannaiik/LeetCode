class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // Build the number
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // Push the current number and string onto the stack
                stack.push(currentString.toString());
                stack.push(String.valueOf(num));
                // Reset for new segment
                currentString = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                // Pop the number from the stack
                int repeatTimes = Integer.parseInt(stack.pop());
                // Pop the previous string from the stack
                StringBuilder prevString = new StringBuilder(stack.pop());
                // Repeat the current string and append it to the previous string
                for (int i = 0; i < repeatTimes; i++) {
                    prevString.append(currentString);
                }
                // Update the current string
                currentString = prevString;
            } else {
                // Append regular characters to the current string
                currentString.append(c);
            }
        }
        return currentString.toString();
    }
}
