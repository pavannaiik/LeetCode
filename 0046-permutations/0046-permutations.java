class Solution {
    List<List<Integer>>ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer>list = new ArrayList<>();
        backtrack(list, nums, 0);
        return ans;
    }
    private void backtrack(List<Integer>list, int[] nums, int index){
        if(index==nums.length){
            ans.add(new ArrayList<>(list));
        }else{
            for(int i=0;i<nums.length;i++){
                if(list.contains(nums[i])) continue;
                list.add(nums[i]);
                backtrack(list, nums, index+1);
                list.remove(list.size()-1);
            }
        }
    }
}