class Solution {
    public int jump(int[] nums) {
       int n = nums.length;
        int jumps = 0;         // Number of jumps taken
        int currentEnd = 0;    // End of the current jump range
        int farthest = 0;      // Farthest index reachable

        for (int i = 0; i < n - 1; i++) {
            // Update the farthest index reachable
            farthest = Math.max(farthest, i + nums[i]);

            // If we reach the end of the current jump range, increment jumps
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest; // Update the end of the next jump range
            }
        }

        return jumps;
    }
}