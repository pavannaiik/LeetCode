class Solution {
    public int kthGrammar(int n, int k) {
        int cur =0;
        int left =1, right = (int)Math.pow(2,n-1);
        for(int i=0;i<n;i++){
            int mid = (right+left)/2;
            if (k<= mid){
                right = mid;
            }else{
                left = mid+1;
                cur = 1-cur;
            }
        }
        return cur;
    }
}