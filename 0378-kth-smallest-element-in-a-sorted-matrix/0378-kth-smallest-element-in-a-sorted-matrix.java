class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(matrix, mid);

            if (count >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    // Helper method to count elements less than or equal to 'mid'
    private int countLessEqual(int[][] matrix, int mid) {
        int count = 0;
        int n = matrix.length;
        int row = n - 1;
        int col = 0;

        // Start from bottom-left corner
        while (row >= 0 && col < n) {
            if (matrix[row][col] <= mid) {
                count += row + 1;
                col++;
            } else {
                row--;
            }
        }
        return count;
    }
}
