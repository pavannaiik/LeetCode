class Solution {
    public int[] findDiagonalOrder(int[][] nums) {
        int n = nums.length;
        List<Integer>ans = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int minVal =0, maxValue =0;
        for(int i=0;i<n;i++){
            int col = nums[i].length;
            for(int j=0;j<col;j++){
                maxValue = Math.max(maxValue, i+j);
                if(!map.containsKey(i+j)){
                    map.put(i+j, new ArrayList<>());
                }
                if((i+j)%2==0)
                map.get(i+j).add(0,nums[i][j]);
                else map.get(i+j).add(nums[i][j]);
            }
        }
        for(int i=minVal;i<=maxValue;i++){
            for(int num:map.get(i)){
                ans.add(num);
            }
        }
        int[] result = new int[ans.size()];
        int i=0;
        for(int num:ans){
            result[i++]=num;
        }
        return result;
    }
}