class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] leftCandles = new int[n];
        int[] rightCandles = new int[n];
        int[] totalCandles = new int[n];
        
        // Two-pointer approach to compute left, right, and total candles in one pass
        int leftC = -1, rightC = -1, totalC = 0;
        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (s.charAt(i) == '|') leftC = i;
            if (s.charAt(j) == '|') rightC = j;
            totalCandles[i] = totalC += (s.charAt(i) == '|') ? 1 : 0;
            leftCandles[i] = leftC;
            rightCandles[j] = rightC;
        }
        
        // Process queries
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = rightCandles[queries[i][0]];
            int right = leftCandles[queries[i][1]];
            if (left == -1 || right == -1 || left >= right) {
                res[i] = 0;
            } else {
                res[i] = (right - left + 1) - (totalCandles[right] - totalCandles[left] + 1);
            }
        }
        
        return res;
    }
}
