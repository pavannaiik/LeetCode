class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer>aSet = new HashSet<>();
        int n = A.length;
        int[] result= new int[n];
        for(int i=0;i<n;i++){
            aSet.add(A[i]);
            aSet.add(B[i]);
            if(aSet.size()==i+1){
                result[i]=i+1;
            }else{
                if(aSet.size()<(i+1)*2){
                    result[i]=2*(i+1)-aSet.size();
                }else{
                    result[i]=0;
                }
            }
        }
        return result;
    }
}