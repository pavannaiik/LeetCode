class Solution {
    /**
     * Main function to create the maximum number of length k from two arrays.
     *
     * @param nums1 The first array of digits.
     * @param nums2 The second array of digits.
     * @param k     The desired length of the maximum number.
     * @return An array of digits representing the maximum number.
     */
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] maxNum = new int[k]; // To store the overall maximum number found

        // Iterate through all possible splits of k between nums1 and nums2
        // i is the number of digits taken from nums1, j is the number of digits taken from nums2
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int j = k - i; // Number of digits to take from nums2

            // 1. Get the maximum number of length i from nums1
            int[] subNum1 = maxArray(nums1, i);
            // 2. Get the maximum number of length j from nums2
            int[] subNum2 = maxArray(nums2, j);

            // 3. Merge the two maximum subarrays
            int[] mergedNum = merge(subNum1, subNum2);

            // 4. Compare the merged number with the current overall maximum
            if (compareArrays(mergedNum, 0, maxNum, 0) > 0) {
                maxNum = mergedNum; // Update the overall maximum
            }
        }

        return maxNum;
    }

    /**
     * Finds the lexicographically largest subarray of length k from a given array.
     * This is done using a greedy approach with a stack-like behavior.
     *
     * @param nums The input array of digits.
     * @param k    The desired length of the subarray.
     * @return The lexicographically largest subarray of length k.
     */
    private int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            return new int[0];
        }
        int[] result = new int[k];
        int top = 0; // Pointer for the result array (acts like a stack top)
        int drop = n - k; // Number of digits to drop from the original array

        for (int i = 0; i < n; i++) {
            // While the current digit is greater than the last digit in the result
            // and we still have digits to drop and the result is not empty,
            // remove the last digit from the result.
            while (top > 0 && nums[i] > result[top - 1] && drop > 0) {
                top--;
                drop--;
            }
            // If the result array is not yet full, add the current digit.
            if (top < k) {
                result[top++] = nums[i];
            } else {
                // If the result array is full, but we dropped a digit,
                // we still need to account for the dropped digit.
                drop--;
            }
        }
        return result;
    }

    /**
     * Merges two arrays of digits into a single lexicographically largest array.
     *
     * @param nums1 The first array of digits.
     * @param nums2 The second array of digits.
     * @return The merged array representing the lexicographically largest number.
     */
    private int[] merge(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] merged = new int[m + n];
        int p1 = 0, p2 = 0, current = 0;

        while (p1 < m || p2 < n) {
            // Compare the remaining parts of nums1 and nums2
            if (compareArrays(nums1, p1, nums2, p2) > 0) {
                merged[current++] = nums1[p1++];
            } else {
                merged[current++] = nums2[p2++];
            }
        }
        return merged;
    }

    /**
     * Compares two arrays of digits lexicographically starting from given indices.
     *
     * @param nums1 The first array.
     * @param start1 The starting index for the first array.
     * @param nums2 The second array.
     * @param start2 The starting index for the second array.
     * @return A positive value if nums1 is lexicographically greater,
     * a negative value if nums2 is lexicographically greater,
     * and 0 if they are equal.
     */
    private int compareArrays(int[] nums1, int start1, int[] nums2, int start2) {
        int m = nums1.length;
        int n = nums2.length;
        while (start1 < m && start2 < n) {
            if (nums1[start1] != nums2[start2]) {
                return nums1[start1] - nums2[start2];
            }
            start1++;
            start2++;
        }
        // If one array is a prefix of the other, the longer one is greater.
        return (m - start1) - (n - start2);
    }
}
