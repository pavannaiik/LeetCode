class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder(strs[0]);
        int n = strs.length;
        for(int i=1;i<n;i++){
            StringBuilder temp = new StringBuilder();
            int size = Math.min(sb.length(), strs[i].length());
            int j=0;
            while(j< size && sb.charAt(j)==strs[i].charAt(j)){
                temp.append(sb.charAt(j));
                j++;
            }
            sb = temp;
        }
        return sb.toString();
    }
}