class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        Integer ans = Integer.MAX_VALUE;
        TreeSet<Integer>treeSet = new TreeSet<>();
        for(int i=x ;i<nums.size();i++){
            treeSet.add(nums.get(i-x));
            Integer val1 = treeSet.ceiling(nums.get(i)); // ceiling method returns the least element in the set greater than or equal to the given element 
            Integer val2 = treeSet.floor(nums.get(i)); // floor method returns the greatest element in the set less than or equal to the given element 
            //Now calculate the ans from 
            if(val1!=null)
            ans = Math.min(ans, Math.abs(val1 - nums.get(i)));
            if(val2!=null)
            ans = Math.min(ans, Math.abs(val2 - nums.get(i)));
        }
        return ans;
    }
} 