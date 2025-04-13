class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size();
        List<Integer>ans = new ArrayList<>();
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        int minVal =0, maxValue =0;
        for(int i=0;i<n;i++){
            int col = nums.get(i).size();
            for(int j=0;j<col;j++){
                maxValue = Math.max(maxValue, i+j);
                if(!map.containsKey(i+j)){
                    map.put(i+j, new ArrayList<>());
                }
                map.get(i+j).add(0,nums.get(i).get(j));
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