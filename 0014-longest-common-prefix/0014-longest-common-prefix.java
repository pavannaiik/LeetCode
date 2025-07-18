class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        int n = strs.length;
        if(n==0) return "";
        StringBuilder sb = new StringBuilder(strs[0]);
        for(int i=1;i<n;i++){
            int j = Math.min(strs[i].length(), sb.length());
            while(j>=0 && !strs[i].substring(0, j).equals(sb.substring(0, j))) j--;
            if(j<=0) return "";
            sb = new StringBuilder(sb.substring(0, j));
        }
        return sb.toString();

    }
}