class Solution {
    public int minSubarray(int[] nums, int p) {
        int sum =0;
        int minSubarray=nums.length;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int n= nums.length;
        for(int num:nums){
            sum =( sum+num)%p;
        }
        int target=sum%p;
        if(target==0){
            return 0;
        }
        int curSum=0;

        for(int i=0;i<nums.length;i++){
            curSum = (curSum+nums[i])%p;
            int required = (curSum-target+p)%p;
            if(map.containsKey(required)){
                minSubarray= Math.min(minSubarray, i-map.get(required));
            }
            map.put(curSum, i);
        }
        return minSubarray==n?-1:minSubarray;
    }
}