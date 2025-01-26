class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1; // Smallest possible divisor
        int right = getMax(nums); // Largest possible divisor (max element in nums)

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (getSum(nums, mid) > threshold) {
                left = mid + 1; // Increase the divisor to reduce the sum
            } else {
                right = mid; // Decrease the divisor to find the smallest valid one
            }
        }

        return left; // Smallest divisor that satisfies the condition
    }

    // Helper function to get the maximum element in the array
    private int getMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    // Helper function to calculate the sum after division
    private int getSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor; // Equivalent to Math.ceil((double) num / divisor)
        }
        return sum;
    }
}