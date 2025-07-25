class Solution {
    public int maxSum(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        int sum =0;
        int minV = Integer.MIN_VALUE;
        boolean zero = false;
        for(int num:nums){
            if(num > 0  && !set.contains(num)){
                sum+=num;
                set.add(num);
            }else if(num < 0){
                minV = Math.max(num, minV);
            }else if(num==0) zero = true;
        }
        if(sum==0) {
            if(zero) return 0;
            else return minV;
        }
        return sum;
    }
}