class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set = new HashSet<>();
        for(int n:nums){
            set.add(n);
        }
        int res =0;
        for(int n:set){
            if(!set.contains(n+1)){
                int next = n-1;
                while(set.contains(next)) next--;
                res = Math.max(res, n-next);
            }
        }
        return res;
    }
}