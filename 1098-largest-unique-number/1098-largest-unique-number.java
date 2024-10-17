class Solution {
    public int largestUniqueNumber(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int max=-1;
        for(int key:map.keySet()){
            if(map.get(key)==1){
                max=Math.max(key,max);
            }
        }
        return max;
    }
}