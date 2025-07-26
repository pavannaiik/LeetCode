
class Solution {

    public long maxSubarrays(int n, int[][] conflictingPairs) {
        // Step 1: Track the smallest and second smallest "end" (b) for each "start" (a)
        int[] smallestConflictEnd = new int[n + 2];
        int[] secondSmallestConflictEnd = new int[n + 2];
        Arrays.fill(smallestConflictEnd, Integer.MAX_VALUE);
        Arrays.fill(secondSmallestConflictEnd, Integer.MAX_VALUE);

        for (int[] pair : conflictingPairs) {
            int start = Math.min(pair[0], pair[1]);
            int end = Math.max(pair[0], pair[1]);

            // Keep the smallest and second smallest end for each start
            if (smallestConflictEnd[start] > end) {
                secondSmallestConflictEnd[start] = smallestConflictEnd[start];
                smallestConflictEnd[start] = end;
            } else if (secondSmallestConflictEnd[start] > end) {
                secondSmallestConflictEnd[start] = end;
            }
        }

        // Step 2: Sweep from right to left to count valid subarrays and track the gain
        long totalValidSubarrays = 0;
        int currentBestStart = n;                // Start index with the smallest conflict cutoff
        int currentSecondBestEnd = Integer.MAX_VALUE;
        long[] extraGainIfRemoved = new long[n + 2]; // Additional subarrays if removing conflict of currentBestStart

        for (int start = n; start >= 1; start--) {
            // Find the start that currently has the minimum conflict end
            if (smallestConflictEnd[currentBestStart] > smallestConflictEnd[start]) {
                currentSecondBestEnd = Math.min(currentSecondBestEnd, smallestConflictEnd[currentBestStart]);
                currentBestStart = start;
            } else {
                currentSecondBestEnd = Math.min(currentSecondBestEnd, smallestConflictEnd[start]);
            }

            // Count subarrays starting at 'start' and ending before the conflict cutoff
            totalValidSubarrays += Math.min(smallestConflictEnd[currentBestStart], n + 1) - start;

            // Track additional subarrays gained by removing the main conflict pair of currentBestStart
            int primaryCutoff = Math.min(smallestConflictEnd[currentBestStart], n + 1);
            int alternativeCutoff = Math.min(Math.min(currentSecondBestEnd, secondSmallestConflictEnd[currentBestStart]), n + 1);
            extraGainIfRemoved[currentBestStart] += alternativeCutoff - primaryCutoff;
        }

        // Step 3: Find the maximum gain among all possible pair removals
        long maxGain = 0;
        for (long gain : extraGainIfRemoved) {
            maxGain = Math.max(maxGain, gain);
        }

        return totalValidSubarrays + maxGain;
    }
}
