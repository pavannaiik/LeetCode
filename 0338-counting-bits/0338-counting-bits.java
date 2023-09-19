class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++){
            ans[i]=totalSetBitsOf(i);
        }
        return ans;
    }
    public int totalSetBitsOf(int i){
        int ans=0;
        while(i!=0){
            if((i&1)==1){
                ans++;
            }
            i = i >>1;
        }
        return ans;
    }
}