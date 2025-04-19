class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null) return "";
        int n = strs.length;
        if(n==1) return strs[0];
        StringBuilder sb = new StringBuilder(strs[0]);
        for(int i=1;i<n;i++){
            int index = Math.min(sb.length(), strs[i].length());
            while(!strs[i].substring(0, index).equals(sb.substring(0, index))){
                index--;
            }
            sb = new StringBuilder(sb.substring(0, index));
        }
        return sb.toString();
    }
}