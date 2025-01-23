class Solution {
    public String shortestPalindrome(String s) {
    int n = s.length();

    int left = 0; // Pointer to track the longest palindromic prefix
    // Find the longest palindromic prefix by comparing characters from the start and end
    for (int j = 0; j < n; j++) {
      int right = n - j - 1;
      if (s.charAt(left) == s.charAt(right)) {
        left++;
      }
    }

    // If the entire string is already a palindrome, return it
    if (left == n) {
      return s;
    }

    String suffix = s.substring(left, n);
    return new StringBuilder(suffix).reverse().append(shortestPalindrome(s.substring(0, left))).append(suffix).toString();
  }
}