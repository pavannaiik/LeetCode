class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int maxFreq = Collections.max(map.values());
        List<List<Integer>>buckets= new ArrayList<>();
        for(int i=0;i<=maxFreq;i++){
            buckets.add(new ArrayList<Integer>());
        }
        for(Integer key:map.keySet()){
            int freq = map.get(key);
            buckets.get(freq).add(key);
        }
        int[] ans = new int[nums.length];
        int j=0;
        for(int i=1;i<buckets.size();i++){
            List<Integer>temp = buckets.get(i);
            Collections.sort(temp,Collections.reverseOrder());
            for(int num:temp){
                for(int k=0;k<i;k++){
                    ans[j++]=num;
                }
            }
        }
        return ans;
    }
}