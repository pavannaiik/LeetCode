class Solution {
    private int mod = 1000000007;
    public int numFactoredBinaryTrees(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Long> dp = new HashMap<>();
        Arrays.sort(arr);
        long ans = 0L;
        for(int i=0;i<n;i++){
            dp.put(arr[i],1L);
            for(int j=0;j<i;j++){
                if( arr[i] % arr[j] == 0){
                    dp.put(arr[i],(dp.get(arr[i])+(dp.get(arr[j])*dp.getOrDefault(arr[i]/arr[j],0L)))%mod);
                }
            }
            ans = (ans+dp.get(arr[i]))%mod;
        }
        return (int)ans%mod;
    }
}