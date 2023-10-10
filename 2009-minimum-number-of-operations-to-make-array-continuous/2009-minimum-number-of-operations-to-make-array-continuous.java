class Solution {
    public int minOperations(int[] nums) {
        int n =nums.length;
        int ans = n;
        HashSet<Integer>set=new HashSet<>();
        for(int i:nums){
            if(!set.contains(i))
                set.add(i);
        }
        int[] res = new int[set.size()];
        int k=0;
        for(int i:set){
            res[k++]=i;
        }
        Arrays.sort(res);
        int j=0;
         for (int i = 0; i < res.length; i++) {
            while (j < res.length && res[j] < res[i] + n) {
                j++;
            }
            int count = j - i;
            ans = Math.min(ans, n - count);
        }
        return ans;
        
    }
}