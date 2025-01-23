class Solution {
    public String longestPrefix(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0; // Length of the previous longest prefix-suffix
        int i = 1;

        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return str.substring(0,lps[n-1]);
    }
}