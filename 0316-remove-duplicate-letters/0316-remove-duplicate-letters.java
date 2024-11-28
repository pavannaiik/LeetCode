class Solution {
    public String removeDuplicateLetters(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int[] count = new int[26]; // Frequency count of each character
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        boolean[] seen = new boolean[26]; 
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            count[ch - 'a']--; 

            if (seen[ch - 'a']) {
                continue; 
            }
            while (!stack.isEmpty() && stack.peek() > ch && count[stack.peek() - 'a'] > 0) {
                seen[stack.pop() - 'a'] = false; 
            }

            stack.push(ch);
            seen[ch - 'a'] = true; 
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
