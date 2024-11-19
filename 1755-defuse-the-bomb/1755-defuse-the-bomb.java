class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        
        if (k == 0) {
            // If k is 0, all elements in the result are 0.
            return ans;
        }
        
        int sum = 0;
        int start, end;

        if (k > 0) {
            // Initialize the sliding window sum for k elements.
            for (int i = 1; i <= k; i++) {
                sum += code[i % n];
            }
            start = 1;
            end = k;
        } else {
            // For k < 0, initialize the sliding window sum for |k| elements.
            k = -k; // Make k positive for consistency.
            for (int i = 1; i <= k; i++) {
                sum += code[(n - i) % n];
            }
            start = n - k;
            end = n - 1;
        }

        // Sliding window processing for all elements.
        for (int i = 0; i < n; i++) {
            ans[i] = sum;
            if (k > 0) {
                sum -= code[start % n];
                sum += code[(end + 1) % n];
                start++;
                end++;
            } else {
                sum -= code[(start - 1 + n) % n];
                sum += code[(end - k + n) % n];
                start--;
                end--;
            }
        }

        return ans;
    }
}
