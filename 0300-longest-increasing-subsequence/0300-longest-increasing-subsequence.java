class Solution {
    public int lengthOfLIS(int[] nums) {
        ArrayList<Integer>ans = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i==0 || nums[i] > ans.get(ans.size()-1)){
                ans.add(nums[i]);
            }else{
                int index = binarySearch(ans, nums[i]);
                ans.set(index, nums[i]);
            }
        }
        return ans.size();
    }
    public int binarySearch(ArrayList<Integer>ans, int num){
        int i=0, j = ans.size();
        while(i < j){
            int mid = i+(j-i)/2;
            if(ans.get(mid)==num){
                return mid;
            }else if(ans.get(mid)<num){
                i=mid+1;
            }else{
                j=mid;
            }
        }
        return i;
    }
}