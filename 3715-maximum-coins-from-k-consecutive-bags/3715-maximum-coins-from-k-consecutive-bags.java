import java.util.Arrays;

class Solution {
    public long maximumCoins(int[][] intervals, int k) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        long maxStart = calculateMaxStartingAtInterval(intervals, k);
        long maxEnd = calculateMaxEndingAtInterval(intervals, k);
        return Math.max(maxStart, maxEnd);
    }

    private long calculateMaxStartingAtInterval(int[][] intervals, int k) {
        long max = 0, currentSum = 0;
        int n = intervals.length;
        int right = 0;
        for (int left = 0; left < n; left++) {
            int windowStart = intervals[left][0];
            int windowEnd = windowStart + k - 1;
            // Expand right to include intervals fully inside the window
            while (right < n && intervals[right][1] <= windowEnd) {
                currentSum += getIntervalCoins(intervals[right]);
                right++;
            }
            // Check partial overlap with the next interval
            long partial = 0;
            if (right < n && intervals[right][0] <= windowEnd) {
                partial = (windowEnd - intervals[right][0] + 1L) * intervals[right][2];
            }
            max = Math.max(max, currentSum + partial);
            // Subtract the left interval as the window moves
            currentSum -= getIntervalCoins(intervals[left]);
        }
        return max;
    }

    private long calculateMaxEndingAtInterval(int[][] intervals, int k) {
        long max = 0, currentSum = 0;
        int n = intervals.length;
        int left = 0;
        for (int right = 0; right < n; right++) {
            currentSum += getIntervalCoins(intervals[right]);
            int windowEnd = intervals[right][1];
            int windowStart = windowEnd - k + 1;
            // Adjust left to exclude intervals completely before the window
            while (left <= right && intervals[left][1] < windowStart) {
                currentSum -= getIntervalCoins(intervals[left]);
                left++;
            }
            // Calculate partial overlap with the leftmost interval
            long partial = 0;
            if (left <= right) {
                int overlapStart = Math.max(intervals[left][0], windowStart);
                partial = (overlapStart - intervals[left][0]) * (long) intervals[left][2];
            }
            max = Math.max(max, currentSum - partial);
        }
        return max;
    }

    private long getIntervalCoins(int[] interval) {
        return (interval[1] - interval[0] + 1L) * interval[2];
    }
}