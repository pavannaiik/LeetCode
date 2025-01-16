class Solution {
    public int minimumOperations(int[] nums) {
        boolean[] has = new boolean[101];
        for (int i = nums.length-1; i >=0; i--) {
            if (has[nums[i]]) return (i+3) / 3;
            has[nums[i]] = true;
        }
        return 0;
    }
}