class Solution {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        recur(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    public void recur(int[] nums, int index, List<Integer>temp, List<List<Integer>>ans){
        ans.add(new ArrayList<>(temp));
        if(index >= nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            recur(nums, i+1, temp, ans);
            temp.remove(temp.size()-1);
        }
    }
}