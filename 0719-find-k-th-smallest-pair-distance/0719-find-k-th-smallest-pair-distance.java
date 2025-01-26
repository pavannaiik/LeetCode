class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0;
        int r = nums[n-1] - nums[0];

        while (l <= r){
            int mid = (l + r) / 2;
            int pairs = sliding(nums, mid, n);

            if (pairs < k){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }

    private int sliding(int[] nums, int mid, int n){
        int count = 0;
        int j = 0;

        for (int i = 0; i < n; i++){

            while (nums[i] - nums[j] > mid){ // sliding window
                j += 1;
            }
            count += i - j; // the number inbetween also < mid so i - j
        }

        return count;
    }
}