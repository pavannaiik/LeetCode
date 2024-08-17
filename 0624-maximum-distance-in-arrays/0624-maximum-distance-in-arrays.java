class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = Integer.MIN_VALUE;
        int min1 = arrays.get(0).get(0);
        int max1 = arrays.get(0).get(arrays.get(0).size()-1);
        for(int i=1;i<arrays.size();i++){
            int min2 = arrays.get(i).get(0);
            int max2 = arrays.get(i).get(arrays.get(i).size()-1);
            ans = Math.max(ans,Math.max(Math.abs(max2-min1), Math.abs(max1-min2)));
            min1 = Math.min(min1,min2);
            max1 = Math.max(max1,max2);
        }
        return ans;
    }
    
}