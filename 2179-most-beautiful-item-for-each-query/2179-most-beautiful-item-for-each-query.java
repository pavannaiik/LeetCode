class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] ans = new int[queries.length];
        Arrays.sort(items, (a,b)->a[0]-b[0]);
        int p=0;
        int max = items[0][1];
        for (int i = 0; i < items.length; i++) {
            max = Math.max(max, items[i][1]);
            items[i][1] = max;
        }
        for(int query:queries){
            int i=0, j= items.length-1;
            int maxBeauty=0;
            while(i<=j){
                int mid =(j+i)/2;
                if(items[mid][0]<=query){
                    maxBeauty=Math.max(items[mid][1],maxBeauty);
                    i=mid+1;
                }else{
                    j=mid-1;
                }
            }
            ans[p++]=maxBeauty;
        }
        return ans;
    }
}