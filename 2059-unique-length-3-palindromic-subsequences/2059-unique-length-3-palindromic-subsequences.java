class Solution {
    private int n;
    private HashSet<Character>set = new HashSet<>();
    public int countPalindromicSubsequence(String s) {
        n = s.length();
        int ans =0;
        for(int c = 97;c<=122;c++){
            int i =0, j=n-1;
            int f =-1, l=-1;
            while(i<n){
                if(s.charAt(i)==(char)c){
                    f = i;
                    break;
                }
                i++;
            }
            while(j>=0){
                if(s.charAt(j)==(char)c){
                    l=j;
                    break;
                }
                j--;
            }
            set.clear();
            if( f!=-1 && l!=-1 &&l-f>1){
                for (int k = f + 1; k < l; k++) {
                    set.add(s.charAt(k));
                }
                ans += (set.size());
            }
        }
        return ans;
    }
}