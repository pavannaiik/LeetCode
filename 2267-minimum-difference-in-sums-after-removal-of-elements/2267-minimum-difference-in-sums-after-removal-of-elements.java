import java.util.PriorityQueue;

class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length;

        // Priority queues for max (prefix) and min (suffix)
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> minPQ = new PriorityQueue<>();

        // Suffix sum array
        long[] suffixSum = new long[n];
        long sumSuff = 0;

        // Calculate the suffix sums
        for (int i = n - 1; i >= n / 3; i--) {
            sumSuff += nums[i];
            minPQ.add(nums[i]);
            if (minPQ.size() > n / 3) {
                sumSuff -= minPQ.poll();
            }
            if (minPQ.size() == n / 3) {
                suffixSum[i] = sumSuff;
            }
        }

        long sumPref = 0;
        long result = Long.MAX_VALUE;

        // Calculate the prefix sums and find the minimum difference
        for (int i = 0; i < n - n / 3; i++) {
            sumPref += nums[i];
            maxPQ.add(nums[i]);
            if (maxPQ.size() > n / 3) {
                sumPref -= maxPQ.poll();
            }
            if (maxPQ.size() == n / 3) {
                result = Math.min(result, sumPref - suffixSum[i + 1]);
            }
        }

        return result;
    }
}
