class Solution {
    int[] prefixArray;
    Random random;
    public Solution(int[] w) {
        random = new Random();
        prefixArray=new int[w.length];
        for(int i=0;i<w.length;i++){
            prefixArray[i]=(i==0?0:prefixArray[i-1])+w[i];
        }
    }
    
    public int pickIndex() {
        int target = random.nextInt(prefixArray[prefixArray.length-1])+1;
        return searchNum(target);
    }
    public int searchNum(int target){
        int i=0, j= prefixArray.length-1;
        while(i <j){
            int mid= i+(j-i)/2;
            if(prefixArray[mid] < target){
                i=mid+1;
            }else{
                j=mid;
            }
        }
        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */