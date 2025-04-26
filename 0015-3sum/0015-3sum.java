class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        getThreeSum(nums, 0, 3, n, 0, new ArrayList<>());
        return result;
    }
    
    private void getThreeSum(int[] nums, int index, int k, int length, int sum, List<Integer> temp) {
        if (k == 2) {
            int i = index, j = length - 1;
            while (i < j) {
                int twoSum = nums[i] + nums[j];
                if (twoSum == sum) {
                    List<Integer>comb = new ArrayList<>(temp);
                    comb.add(nums[i]);
                    comb.add(nums[j]);
                    result.add(comb); 
                    i++;
                    j--;
                    while (i < j && nums[i] == nums[i - 1]) i++;
                    while (i < j && nums[j] == nums[j + 1]) j--;
                } else if (twoSum < sum) {
                    i++;
                } else {
                    j--;
                }
            }
            return;
        }
        
        for (int i = index; i < length - k + 1; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            getThreeSum(nums, i + 1, k - 1, length, sum - nums[i], temp);
            temp.remove(temp.size() - 1); // backtrack
        }
    }
}
