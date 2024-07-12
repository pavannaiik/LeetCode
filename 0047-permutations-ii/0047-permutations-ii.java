class Solution {
    List<List<Integer>>ans = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer>list = new ArrayList<>();
        backtrack(list, nums,new boolean[nums.length]);
        return ans;
    }
    private void backtrack(List<Integer>list, int[] nums, boolean[] used){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
        }else{
            for(int i=0;i<nums.length;i++){
                if(used[i] ||(i >0 && nums[i]==nums[i-1] && !used[i - 1])) continue;
                used[i]=true;
                list.add(nums[i]);
                backtrack(list, nums, used);
                used[i]=false;
                list.remove(list.size()-1);
            }
        }
    }
}