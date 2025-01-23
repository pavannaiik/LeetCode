class Solution {
public String longestPrefix(String s) {
    // Convert the string into a character array for efficient access
    char[] chars = s.toCharArray();
    int n = chars.length;

    // LPS array to store the lengths of the longest prefix-suffix at each position
    int[] lps = new int[n];
    int length = 0; // Tracks the current length of the matching prefix-suffix

    // Start building the LPS array from the second character
    for (int i = 1; i < n; ) {
        if (chars[i] == chars[length]) {
            length++;       // Increase length of the prefix-suffix match
            lps[i] = length; // Store the length in the LPS array
            i++;            // Move to the next character
        } else {
            if (length != 0) {
                length = lps[length - 1]; // Fall back to the previous LPS
            } else {
                lps[i] = 0; // No match, set LPS as 0
                i++;        // Move to the next character
            }
        }
    }

    // The longest prefix which is also a suffix is determined by lps[n - 1]
    return s.substring(0, lps[n - 1]);
}

}