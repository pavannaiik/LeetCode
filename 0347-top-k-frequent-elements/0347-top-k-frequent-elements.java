class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer>freqMap = new HashMap<>();
        int maxFreq = 0;
        for(int num: nums){
            freqMap.put(num, freqMap.getOrDefault(num,0)+1);
            maxFreq = Math.max(maxFreq, freqMap.get(num));
        }
        List<List<Integer>>arrList = new ArrayList<>(maxFreq);
        for(int i=0;i<maxFreq;i++){
            arrList.add(new ArrayList<>());
        }
        for(int num:freqMap.keySet()){
            arrList.get(freqMap.get(num)-1).add(num);
        }
        int[] result = new int[k];
        int index=0;
        for(int i=maxFreq-1;i>=0;i--){
            if(index>=k){
                break;
            }
            for(int currNum: arrList.get(i)){
                if(index>=k){
                    break;
                }
                result[index++]=currNum;
            }
        }
        return result;
        
    }
}