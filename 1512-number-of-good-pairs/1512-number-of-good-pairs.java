class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int ans =0;
        for(int i:nums){
            ans+=map.getOrDefault(i,0);
            map.put(i,map.getOrDefault(i,0)+1);
        }
        return ans;
    }
}