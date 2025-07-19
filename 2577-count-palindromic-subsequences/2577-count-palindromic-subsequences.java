class Solution {
    public int countPalindromes(String s) {
        int[][] prefix = new int[10][10];
        int[][] suffix = new int[10][10];
        int[] left = new int[10];
        int[] right = new int[10];
        long result = 0;
        int mod = 1_000_000_007;
        int n = s.length();
        for(int i=n-1;i>=0;i--){
            int d = s.charAt(i)-'0';
            for(int j=0;j<10;j++){
                suffix[d][j] += right[j];
            }
            right[d]++;
        }
        for(int i=0;i<n;i++){
            //first remobve  from suffix
            int mid = s.charAt(i)-'0';
            right[mid]--;
            for(int j=0;j<10;j++){
                suffix[mid][j] -= right[j];
            }
            for(int a=0;a<10;a++){
                for(int b=0;b<10;b++){
                    result = (result + 1L * prefix[a][b] * suffix[b][a])%mod;
                }
            }
            //add to prefix
            for(int j=0;j<10;j++){
                prefix[j][mid] += left[j];
            }
            left[mid]++;
        }
        return (int)result;
    }
}