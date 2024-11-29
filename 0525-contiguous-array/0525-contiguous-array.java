class Solution {
    public int findMaxLength(int[] nums) {
        int max =0;
        HashMap<Integer,Integer>map = new HashMap<>();
        map.put(0,-1);
        int sum =0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                nums[i]=-1;
            }
            sum+=nums[i];
            if(map.containsKey(sum)){
                max=Math.max(max,i-map.get(sum));
            }else map.put(sum, i);
        }
        
        return max;
    }
}