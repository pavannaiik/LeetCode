class Solution {
    public String reverseWords(String s) {
        // Split by any whitespace and trim input
        String[] words = s.trim().split("\\s+");

        // Use StringBuilder to build the reversed result
        StringBuilder sb = new StringBuilder();

        // Append words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            sb.append(words[i]);
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
