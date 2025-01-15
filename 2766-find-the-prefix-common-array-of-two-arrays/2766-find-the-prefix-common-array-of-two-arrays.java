class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer>aSet = new HashSet<>();
        HashSet<Integer>bSet = new HashSet<>();
        int n = A.length;
        int ans=0;
        int[] result= new int[n];
        for(int i=0;i<n;i++){
            int common=0;
            aSet.add(A[i]);
            bSet.add(B[i]);
            if(bSet.contains(A[i])){
                ans++;
            }
            if(aSet.contains(B[i]) && A[i]!=B[i]){
                ans++;
            }
            ans+=common;
            result[i]=ans;
        }
        return result;
    }
}