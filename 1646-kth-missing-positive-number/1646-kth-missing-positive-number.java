class Solution {
    public int findKthPositive(int[] arr, int k) {
        int m =0;
        int p =0;
        for(int i =1;i<=100000;i++){
            
            if(p < arr.length && arr[p] == i){
                p++;
            }else{
                m++;
            }
            if(m == k){
                return i;
            }
        }
        return -1;
    }
}