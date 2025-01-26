class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] left = new int[26]; // Tracks counts of characters seen so far
        int[] right = new int[26]; // Tracks counts of characters remaining
        Set<String> uniquePalindromes = new HashSet<>();

        // Initialize right array with the frequency of each character in the string
        for (char c : s.toCharArray()) {
            right[c - 'a']++;
        }

        // Iterate through the string
        for (int i = 0; i < n; i++) {
            char middle = s.charAt(i);
            right[middle - 'a']--; // Remove current character from right frequency

            // Check for potential palindromes with the current character as the middle
            for (int j = 0; j < 26; j++) {
                if (left[j] > 0 && right[j] > 0) {
                    String palindrome = "" + (char) (j + 'a') + middle + (char) (j + 'a');
                    uniquePalindromes.add(palindrome);
                }
            }

            // Add current character to left frequency
            left[middle - 'a']++;
        }

        return uniquePalindromes.size();
    }
}