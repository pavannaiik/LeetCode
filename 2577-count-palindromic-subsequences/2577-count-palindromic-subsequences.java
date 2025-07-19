class Solution {
    public int countPalindromes(String s) {
        int mod = 1_000_000_007;
        int n = s.length();
        int[][] prefix = new int[10][10];
        int[][] suffix = new int[10][10];
        int[] left = new int[10];
        int[] right = new int[10];

        // Count suffix pairs
        for (int i = n - 1; i >= 0; i--) {
            int d = s.charAt(i) - '0';
            for (int j = 0; j < 10; j++) {
                suffix[d][j] += right[j];
            }
            right[d]++;
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            int mid = s.charAt(i) - '0';

            // Remove current from suffix
            right[mid]--;
            for (int j = 0; j < 10; j++) {
                suffix[mid][j] -= right[j];
            }

            // Count combinations of form a b c b a
            for (int a = 0; a < 10; a++) {
                for (int b = 0; b < 10; b++) {
                    result = (result + 1L * prefix[a][b] * suffix[b][a]) % mod;
                }
            }

            // Update prefix
            for (int j = 0; j < 10; j++) {
                prefix[j][mid] += left[j];
            }
            left[mid]++;
        }

        return (int) result;
    }
}
