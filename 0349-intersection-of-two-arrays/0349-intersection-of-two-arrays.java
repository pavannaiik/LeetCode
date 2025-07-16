class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] ans = new int[1001];
       // Arrays.fill(ans,-1);
        for(int num:nums1){
            ans[num]=1;
        }
        int c =0;
        for(int num:nums2){
            if(ans[num]==1){
                ans[num]++;
                c++;
            }
        }
        int[] res = new int[c];
        int j=0;
        for(int i=0;i<ans.length;i++){
            if(ans[i]==2){
                res[j++]=i;
            }
        }
        return res;
    }
}