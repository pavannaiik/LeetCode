class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder(strs[0]);
        int n = strs.length;
        for(int i=1;i<n;i++){
            String t = strs[i];
            int j = Math.min(sb.length(), t.length());
            while( j >=0 && !sb.substring(0,j).equals(t.substring(0,j))){
                j--;
            }
            if(j>=0)
            sb = new StringBuilder(sb.substring(0,j));
        }
        return sb.toString();
    }
}