class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        boolean[] seen = new boolean[51];  // Assuming values are between 1 to 50
        int commonCount = 0;

        for (int i = 0; i < n; i++) {
            if (seen[A[i]]) {
                commonCount++;
            } else {
                seen[A[i]] = true;
            }

            if (seen[B[i]]) {
                commonCount++;
            } else {
                seen[B[i]] = true;
            }

            result[i] = commonCount;
        }
        return result;
    }
}
