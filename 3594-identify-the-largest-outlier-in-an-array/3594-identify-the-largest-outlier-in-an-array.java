class Solution {
    public int getLargestOutlier(int[] nums) {
       HashMap<Integer,Integer>countMap=new HashMap<>();
       int sum=0, res = Integer.MIN_VALUE;
       for(int num:nums){
        sum+=num;
        countMap.put(num, countMap.getOrDefault(num, 0)+1);
       }
       for(int num:nums){
        int outlier = sum-num-num;
        if(countMap.getOrDefault(outlier,0) > (outlier==num?1:0)){
            res=Math.max(outlier,res);
        }
       }
       return res;
    }
}
