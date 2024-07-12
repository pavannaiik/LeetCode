class Solution {
    List<List<Integer>>ans;
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        recur(nums, 0, new ArrayList<>());
        return ans;
    }
    public void recur(int[] nums, int index, List<Integer>temp){
        ans.add(new ArrayList<>(temp));
        if(index >= nums.length){
            return;
        }
        for(int i=index;i<nums.length;i++){
            temp.add(nums[i]);
            recur(nums, i+1, temp);
            temp.remove(temp.size()-1);
        }
    }
}