class Solution {
    List<List<Integer>>ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
            if(i > index && nums[i]==nums[i-1]) continue;
            temp.add(nums[i]);
            recur(nums, i+1, temp, sum+nums[i], target); // only difference is we are re using 
                                                        //same element unlike subsets here we do i, there we do i+1
            temp.remove(temp.size()-1);
        }
    }
}