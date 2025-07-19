class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000000L, high = 10000000000L;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (countPairs(nums1, nums2, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private long countPairs(int[] A, int[] B, long mid) {
        long count = 0;
        for (int a : A) {
            if (a == 0) {
                if (mid >= 0) count += B.length;
            } else if (a > 0) {
                // Need b ≤ mid / a
                int l = 0, r = B.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long)a * B[m] <= mid) l = m + 1;
                    else r = m;
                }
                count += l;
            } else { // a < 0
                // Need b ≥ ceil(mid / a)
                int l = 0, r = B.length;
                while (l < r) {
                    int m = (l + r) / 2;
                    if ((long)a * B[m] <= mid) r = m;
                    else l = m + 1;
                }
                count += B.length - l;
            }
        }
        return count;
    }
}
