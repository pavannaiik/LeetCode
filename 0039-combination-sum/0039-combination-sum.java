class Solution {
    List<List<Integer>>ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        recur(candidates, 0, new ArrayList<>(), 0, target);
        return ans;
    }
    public void recur(int[] nums, int index, List<Integer>temp, int sum, int target){
        if(sum==target)
          ans.add(new ArrayList<>(temp));

        if (sum>target) return;
        
        if(index >= nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            recur(nums, i, temp, sum+nums[i], target);
            temp.remove(temp.size()-1);
        }
    }
}