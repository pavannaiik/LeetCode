class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer,Integer>map = new HashMap<>();
        int max =0;
        int number =-1;
        for(int num :nums){
            map.put(num, map.getOrDefault(num,0)+1);
            if(map.get(num) > max ){
                max = map.get(num);
                number = num;
            }
        }
        List<Integer>list = new ArrayList<>();
        for(int key:map.keySet()){
            if(max == map.get(key))
            list.add(key);
        }
        if(max == 1){
            return 1;
        }else{
            int ans = Integer.MAX_VALUE;
            for(int val: list){
                int index1=0, index2 = 0;
            for(int i =0;i<nums.length;i++){
                if(val == nums[i]){
                    index1 = i;
                    break;
                }
            }
            for(int i =nums.length-1;i>=0;i--){
                if(val == nums[i]){
                    index2 = i;
                    break;
                }
            }
            if(ans > index2-index1+1){
                ans = index2-index1+1;
            }
            }
            return ans;
            
        }
    }
}